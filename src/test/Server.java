package test;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 4200), 0);
            HttpHandler httpHandler = new RequestHandler();

            server.createContext("/", httpHandler);

            server.start();
        } catch (IOException e) {
            System.err.println("Ran into error with the server.");
        }
    }
}
