package com.jc;

public class Solution3 {

    public int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 11 == 0 && A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int A[] = new int[]{-6, -91, 1011, -100, 84, -22, 0, 1, 473, 484};

        Solution3 solution3 = new Solution3();
        int solution = solution3.solution(A);
        System.out.println(solution);
    }
}
