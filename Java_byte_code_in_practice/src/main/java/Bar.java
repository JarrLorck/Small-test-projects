/**
 *
 */
public class Bar {
    int foo(int i) {
        return foa(i + 1);
    }

    private int foa(int i ) {
        return foo(i + 1);
    }
}
