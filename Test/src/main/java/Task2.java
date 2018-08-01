public class Task2 {
    public static void main(String[] args) {
        int x = 5;
//        String[] line = "5 5 5 7 2 3 5".split(" ");
        String[] line = "5 5 7 5 5".split(" ");
        int[] array = new int[line.length];
        int i = 0;
        for (String str : line) {
            array[i++] = Integer.valueOf(str);
        }
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(x, array));
    }
}

class Solution2 {
    public int solution(int X, int[] A) {
        int k = -1;
        if (A.length > 1) {
            int left = -1;
            int right = A.length;
            while (left < right) {
                while (left < right && A[++left] != X) {
                    //iterate
                }
                while (right > left && A[--right] == X) {
                    //iterate
                }
                if (left == right) {
                    k = right;
                }
            }

        }
        return k;
    }
}
