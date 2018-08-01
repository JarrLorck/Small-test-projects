package com.jc;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String solution(String S, String C) {
        StringBuilder answer = new StringBuilder();
        C = "@" + C.toLowerCase() + ".com";
        String DELIMITER = "; ";
        String[] fullNames = S.split(DELIMITER);
        Map<String, Integer> nameCount = new HashMap<String, Integer>();
        for (String fullName: fullNames) {
            String name = convertForEmail(fullName);
            if (name != null) {
                if (answer.length() > 0) {
                    answer.append(DELIMITER);
                }

                answer.append(fullName).append(" ");
                Integer count = nameCount.get(name);
                if (count == null) {
                    count = 1;
                    answer.append("<").append(name).append(C).append(">");
                } else {
                    count += 1;
                    answer.append("<").append(name).append(count).append(C).append(">");
                }
                nameCount.put(name, count);
            }
        }
        return answer.toString();
    }

    public String convertForEmail(String fullName) {
        String[] tokens = fullName.split(" ");
        if (tokens.length >= 2) {
            String firstName = tokens[0].toLowerCase().replaceAll("[^a-z]", "");;
            String lastName = tokens[tokens.length - 1].toLowerCase().replaceAll("[^a-z]", "");
            if (lastName.length() > 8) {
                lastName = lastName.substring(0, 8);
            }
            return firstName + "." + lastName;
        }
        return null;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String C = "Example";
        String S = "Eugene Abcdefghijk; J----ohn Doe; Peter Benj```amin Parker; Mary Jane Wa$$tson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String solution = solution2.solution(S, C);
        System.out.println(solution);
    }
}
