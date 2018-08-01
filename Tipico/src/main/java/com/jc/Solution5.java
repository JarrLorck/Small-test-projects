package com.jc;

public class Solution5 {
    public int[] solution(int N) {
        int a[] = new int[N];
        //init
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        change(a, a.length - 1);
        return a;
    }

    public void change(int[] a, int index) {
        if (index > 0) {
            a[index - 1] = -a[index];
            index -= 2;
            change(a, index);
        }
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] a = solution5.solution(1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
