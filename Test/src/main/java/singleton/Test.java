package singleton;

import java.util.Arrays;

public final class Test {
    private static class Inner {
        private final static Test INSTANCE = new Test();
    }
    private Test() {
        System.err.println("singleton created at " + System.nanoTime());
    }

    private final String[] something = new String[] {"some1", "some2", "some3"};
    public void printSomething() {
        System.err.println(Arrays.toString(something));
    }

    public static Test getInstance() {
        return Inner.INSTANCE;
    }
}
