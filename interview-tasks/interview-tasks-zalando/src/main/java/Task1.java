public class Task1 {
    private enum Seasons {
        WINTER, SPRING, SUMMER, AUTUMN
    }
    public String solution(int[] T) {
        int duration = T.length / 4;
        int i = 0;
        int max = Integer.MIN_VALUE;
        Seasons result = Seasons.WINTER;
        for (Seasons season: Seasons.values()) {
            int diff = calculateDifference(T, i, i + duration - 1);
            if (diff > max) {
                max = diff;
                result = season;
            }
            i += duration;
        }

        return result.toString();
    }

    private int calculateDifference(int[] T, int start, int end) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            if (max < T[i]) {
                max = T[i];
            }
            if (min > T[i]) {
                min = T[i];
            }
        }

        return Math.abs(max - min);
    }


    public static void main(String[] args) {
        Task1 task1 = new Task1();

//        System.out.println(task1.solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}));
        System.out.println(task1.solution(new int[]{
                -5,
                8,
                50,
                5}));
//        System.out.println(task1.solution(new int[]{
//                2, -3, -10, -5,
//                3, 1, 10, 8,
//                5, 50, 2, 5,
//                13, 5, 5, -5}));
    }

}
