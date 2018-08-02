package com.sixt.platform.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Task2 {
    public List<Integer> buildExecutionPlan(List<Integer> allScripts) {
        Set<Integer> processedScripts = new HashSet<Integer>(allScripts.size());
        List<Integer> plan = new ArrayList<Integer>(allScripts.size());
        processScript(allScripts, processedScripts, plan);
        return plan;
    }


    private void processScript(List<Integer> scripts, Set<Integer> processedScripts, List<Integer> plan) {
        if (scripts == null) {
            return;
        }

        for (Integer scriptId : scripts) {
            if (!processedScripts.contains(scriptId)) {
                VulnerabilityScript script = getScript(scriptId);
                if (script != null) {
                    List<Integer> dependencies = script.getDependencies();
                    processScript(dependencies, processedScripts, plan);
                    plan.add(scriptId);
                    processedScripts.add(scriptId);
                }
            }
        }
    }

    protected abstract VulnerabilityScript getScript(Integer scriptId);
}
