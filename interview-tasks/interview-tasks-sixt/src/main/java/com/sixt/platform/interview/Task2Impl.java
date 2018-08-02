package com.sixt.platform.interview;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task2Impl extends Task2 {
    final Map<Integer, VulnerabilityScript> scripts;

    @SuppressWarnings("unchecked")
    public Task2Impl() {
        scripts = new HashMap<Integer, VulnerabilityScript>();

        scripts.put(1, new VulnerabilityScript(1, List.of(2,3)));
        scripts.put(2, new VulnerabilityScript(2, Collections.EMPTY_LIST));
        scripts.put(3, new VulnerabilityScript(3, List.of(4,5)));
        scripts.put(4, new VulnerabilityScript(4, List.of(5)));
        scripts.put(5, new VulnerabilityScript(5, Collections.EMPTY_LIST));
        scripts.put(6, new VulnerabilityScript(6, List.of(7)));
        scripts.put(7, new VulnerabilityScript(7, List.of(1)));

    }

    protected VulnerabilityScript getScript(Integer scriptId) {
        return scripts.get(scriptId);
    }

    public void test() {
        java.util.List<Integer> integers = buildExecutionPlan(new ArrayList<Integer>(scripts.keySet()));
        System.out.println(integers);
    }

    public static void main(String[] args) {
        Task2Impl task2 = new Task2Impl();
        task2.test();
    }
}
