public class Task1 {
    public static void main(String[] args) {
        int x = 5;
        String[] line = "5 8 20 12 2 7 4 0 0 0 0 6 0 1 0".split(" ");
        int[] array = new int[line.length];
        int i = 0;
        for (String str : line) {
            array[i++] = Integer.valueOf(str);
        }

        Tree tree = Tree.construct(array, 0);

        Solution solution = new Solution();
        System.out.println(solution.solution(tree));
    }
}

class Solution {
    public int solution(Tree T) {
        if (T == null) {
            return -1;
        }
        return process(new CustomTree(T), -1);
    }

    public int process(CustomTree current, int p) {
        if (current == null) {
            return -1;
        }

        int left = process(current.l, p);
        int right = process(current.r, p);




        int currentP = Math.abs(current.x);
        int currentLeft = 0;
        int currentRight = 0;
        if (current.l != null) {
            currentLeft = Math.abs(current.x - current.l.x);
        }
        if (current.r != null) {
            currentRight = Math.abs(current.x - current.r.x);
        }


        if (p < currentP) {
            p = currentP;
        }
        return 0;
    }
}

class CustomTree {
    public CustomTree(Tree tree) {
        this.x = tree.x;
        this.m = tree.x;
        this.l = tree.l != null ? new CustomTree(tree.l) : null;
        this.r = tree.r != null ? new CustomTree(tree.r) : null;
    }
    public int x;
    public CustomTree l;
    public CustomTree r;

    public int m;
    public int p = -1;
}

class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public static Tree construct(int[] array, int index) {
        Tree current = null;
        if (index < array.length && array[index] != 0) {
            current = new Tree();
            current.x = array[index];

            current.l = construct(array, 2 * index + 1);
            current.r = construct(array, 2 * index + 2);
        }
        return current;
    }
}
