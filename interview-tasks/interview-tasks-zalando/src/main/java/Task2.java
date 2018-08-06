public class Task2 {
    final String A = "a";
    final String B = "b";

    public String solution(int a, int b) {
        if (a >= b) {
            return process(A, a, B, b);
        } else {
            return process(B, b, A, a);
        }
    }

    private String process(String N, int n, String M, int m) {
        StringBuilder result = new StringBuilder(n + m);
        int nTwoLetters = n / 2;
        int nOneLetter = (n % 2);
        int space = nTwoLetters + nOneLetter - 1;

        int twoLetters = m / 2;
        int oneLetter = m % 2;

        while (twoLetters + oneLetter < space) {
            twoLetters -= 1;
            oneLetter += 2;
        }

        for (int i = 0; i < nTwoLetters; i++) {
            result.append(N).append(N);
            if (twoLetters > 0) {
                result.append(M).append(M);
                twoLetters--;
            } else if (oneLetter > 0) {
                result.append(M);
                oneLetter--;
            }
        }

        if (nOneLetter > 0) {
            result.append(N);
        }

        if (oneLetter > 0) {
            result.append(M);
        }


        return result.toString();
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();

        System.out.println(task2.solution(100, 100));
    }
}
