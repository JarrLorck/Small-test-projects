import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server();

        CompletableFuture<String> start = server.start();
        System.err.println("Server was started");
        try {
            System.err.println("Start get: " + start.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
