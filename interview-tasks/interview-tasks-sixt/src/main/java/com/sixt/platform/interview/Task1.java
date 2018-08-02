package com.sixt.platform.interview;

import java.util.Arrays;

public class Task1 {

    public boolean isAnagram(String lhs, String rhs) {
        //I assume that empty strings are not anagrams and return false
        if (lhs == null || rhs == null || lhs.length() == 0 || rhs.length() == 0 || lhs.length() != rhs.length()) {
            return false;
        }

        char[] left = lhs.toCharArray();
        char[] right = rhs.toCharArray();
        //Use common Java libs to sort arrays
        Arrays.sort(left);
        Arrays.sort(right);

        for (int i = 0; i < right.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        boolean anagram = task1.isAnagram("anagramw", "nagaramt");
        System.out.println(anagram);
    }
}
