import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class Server {
    private final static int PORT = 8080;

    public CompletableFuture<String> start() throws IOException {
            final ServerSocket socket = new ServerSocket(PORT);

            final CompletableFuture<Socket> socketFuture = CompletableFuture.supplyAsync(() -> {
                System.err.println("wait for connection");
                Socket accept = null;
                try {
                    accept = socket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.err.println("someone was connected");
                return accept;
            });

            CompletableFuture<String> completableFuture = socketFuture.thenCompose(socket1 -> {
                final InputStream inputStream;
                CompletableFuture<String> future = new CompletableFuture<>();
                try {
                    inputStream = socket1.getInputStream();
                    int available = inputStream.available();
                    if (available > 0) {
                        final byte[] array = new byte[available];
                        int read = inputStream.read(array);
                        System.err.println(read + " bytes were read");
                        future.complete(new String(array));
                    } else {
                        System.err.println("no bytes to read");
                    }
                } catch (IOException e) {
                    future.completeExceptionally(e);
                }
                return future;
            });
        return completableFuture;
    }

}
