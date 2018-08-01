public class Task3 {
    public static void main(String[] args) {
        String[] line = "6".split(" ");
        int[] array = new int[line.length];
        int i = 0;
        for (String str : line) {
            array[i++] = Integer.valueOf(str);
        }
        Solution3 solution = new Solution3();
        System.out.println(solution.solution(array));
    }
}

class Solution3 {
    public boolean solution(int[] A) {
        boolean a = true;
        if (A.length > 1) {
            int i = 0;
            while (i < A.length - 1 && A[i] <= A[i + 1]) {
                i++;
            }

            int j = A.length - 1;
            while (j > 0 && A[j - 1] <= A[j]) {
                j--;
            }

            if (i < j) {
                while (i > 0 && A[i] == A[i - 1]) {
                    i--;
                }
                while (j < A.length - 1 && A[j] == A[j+1]) {
                    j++;
                }
                int c = A[i];
                A[i] = A[j];
                A[j] = c;
            }

            while (i < A.length - 1 && a) {
                if (A[i] > A[i + 1]) {
                    a = false;
                }
                i++;
            }
        }
        return a;
    }
}
