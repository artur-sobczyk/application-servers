package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class WebServer {
    public static final int HTTP = 80;
    public static final String CRLF = "\r\n";
    private ServerSocket s;

    public static void main(String[] argv) throws Exception {
        System.out.println("WebServer starting...");
        WebServer w = new WebServer();
        w.runServer(HTTP);
    }

    private ServerSocket getServerSocket(int port) throws Exception {
        return new ServerSocket(port);
    }

    private void runServer(int port) throws Exception {
        s = getServerSocket(port);
        while (true) {
            try {
                Socket us = s.accept();
                Handler(us);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void Handler(Socket s) {
        try {
            String from = s.getInetAddress().toString();
            System.out.println("Accepted connection from " + from);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String singleLine = reader.readLine();
            while (singleLine != null) {
                System.out.println(singleLine);

                if (!reader.ready()) {
                    break;
                }

                singleLine = reader.readLine();
            }

            PrintWriter os = new PrintWriter(s.getOutputStream(), true);
            os.println("HTTP/1.0 200 Here is your data");
            os.println("Content-Type: text/html; charset=UTF-8");
            String reply1 = readHtml();
            os.println("Content-length: " + reply1.length() + "\n");
            os.println(reply1);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    private String readHtml() throws IOException, URISyntaxException {
        return Files.readAllLines(Paths.get(getClass().getResource("/server.html").toURI())).stream()
                .collect(Collectors.joining(""));
    }
}

