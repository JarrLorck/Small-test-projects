import java.util.concurrent.CompletableFuture;

public class TestForCompletableFuture<T> {

    public CompletableFuture<T> ask() {
        final CompletableFuture<T> completableFuture = new CompletableFuture<T>();

        return completableFuture;
    }
}
