package test;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exch) throws IOException {
        System.out.printf("[%1$tH:%1$tM:%1$tS] Request received.\n", LocalDateTime.now());
        System.out.printf("\tMethod: %s\n\tAddress: %s\n", exch.getRequestMethod(), exch.getRequestURI().toString());

        Headers header = exch.getResponseHeaders();
        header.set("Content-Type", "text/html");

        exch.sendResponseHeaders(200, 0);

        PrintStream out = new PrintStream(exch.getResponseBody());
        out.println("<h1>Hallöchen</h1>");
        out.close();

        exch.close();
    }
}
