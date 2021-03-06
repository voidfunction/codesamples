package my.sample.httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import sun.security.krb5.internal.crypto.Des;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class MyHttpServer {
    private static HttpServer server;
    private static final int NUMBER_OF_THREADS = 100;
    private static ExecutorService executorService;
    private static boolean isEnabled = false;
    private static int port = -1;

    public static void main(String[] args) {

        initialize();
    }

    public synchronized static void close() {
        if (server != null) {
            server.stop(0);
        }
        if (executorService != null) {
            executorService.shutdown();
            try {
                executorService.awaitTermination(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
            }
        }
        isEnabled = false;
    }


    public synchronized static void initialize() {
        if (isEnabled) {
            return;
        }

        try {
            // try to get a random socket port
            ServerSocket s = new ServerSocket(1234);
            s.close();

            InetSocketAddress socketAddress = new InetSocketAddress(s.getLocalPort());
            port = socketAddress.getPort();
            System.out.println(port);
            server = HttpServer.create(socketAddress, 10);
            server.createContext("/actions", (httpExchange -> {
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                if ( Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.baidu.com"));
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                    }));
            server.createContext("/applications", (httpExchange) -> {
                String message = "<button>my click</button>";
                // access problem
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                httpExchange.sendResponseHeaders(200, message.length());
                // Content-Type: text/html; charset=utf-8
                httpExchange.getResponseHeaders().add("Content-Type","text/html");
                OutputStream stream = httpExchange.getResponseBody();
                stream.write(message.getBytes());
                stream.close();
            });

            executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
            server.setExecutor(executorService);
            server.start();
            isEnabled = true;
        } catch (IOException e) {
        }
    }
}
