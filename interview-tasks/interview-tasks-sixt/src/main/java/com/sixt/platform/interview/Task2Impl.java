package com.sixt.platform.interview;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public abstract class Task2Impl extends Task2 {

    public static class Task2Test {
        Random r = new Random();
        @Test
        public void testFixedList() {
            final Map<Integer, VulnerabilityScript> scripts = new HashMap<Integer, VulnerabilityScript>();

            scripts.put(1, new VulnerabilityScript(1, ImmutableList.of(2,3)));
            scripts.put(2, new VulnerabilityScript(2, Collections.<Integer>emptyList()));
            scripts.put(3, new VulnerabilityScript(3, ImmutableList.of(2)));
            scripts.put(6, new VulnerabilityScript(6, ImmutableList.of(7)));
            scripts.put(7, new VulnerabilityScript(7, ImmutableList.of(1)));
            Task2Impl task2 = new Task2Impl() {
                protected VulnerabilityScript getScript(Integer scriptId) {
                    return scripts.get(scriptId);
                }
            };

            java.util.List<Integer> integers = task2.buildExecutionPlan(new ArrayList<Integer>(scripts.keySet()));
            List<Integer> actual = ImmutableList.of(2,3,1,7,6);
            assertEquals(actual, integers);
        }

        @Test
        public void testRandomList() {
            int size = 20;
            List<Integer> ids = new ArrayList<Integer>(size);
            for (int i = 1; i <= size; i++) {
                ids.add(i);
            }
            Collections.shuffle(ids);

            final Map<Integer, VulnerabilityScript> scripts = new HashMap<Integer, VulnerabilityScript>();

            //put first two elements without dependencies
            scripts.put(ids.get(0), new VulnerabilityScript(ids.get(0), Collections.<Integer>emptyList()));
            scripts.put(ids.get(1), new VulnerabilityScript(ids.get(1), Collections.<Integer>emptyList()));

            //build random dependency tree
            for (int i = 2; i < ids.size(); i++) {
                int id = ids.get(i);
                List<Integer> subList = new ArrayList<Integer>(ids.subList(0, i));
                Collections.shuffle(subList);
                List<Integer> idsToDependOn = subList.subList(0, r.nextInt(subList.size()));
                scripts.put(id, new VulnerabilityScript(id, idsToDependOn));
            }

            Task2Impl task2 = new Task2Impl() {
                protected VulnerabilityScript getScript(Integer scriptId) {
                    return scripts.get(scriptId);
                }
            };

            List<Integer> idsToTest = new ArrayList<Integer>(scripts.keySet());
            Collections.shuffle(idsToTest);
            java.util.List<Integer> plan = task2.buildExecutionPlan(idsToTest);

            //check for right tree
            Set<Integer> inInitState = new HashSet<Integer>(size);
            for (Integer id: plan) {
                Assert.assertFalse(inInitState.contains(id));
                List<Integer> dependencies = scripts.get(id).getDependencies();
                for (Integer depId: dependencies) {
                    Assert.assertTrue(inInitState.contains(depId));
                }
                inInitState.add(id);
            }
        }


    }
}
