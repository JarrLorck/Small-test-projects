import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExceptionHandling implements Runnable {

    @Override
    public void run() {
        while (true) {
            int a  = 1 / 0;
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = new ForkJoinPool(1);

        ThreadExceptionHandling th = new ThreadExceptionHandling();
        ex.submit(th);

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
