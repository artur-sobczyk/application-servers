package pl.sda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DemoServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("request: " + request.getMethod() + " " + request.getRequestURI());
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(readHtml());
    }

    private String readHtml() {
        try {
            return Files.readAllLines(Paths.get(getClass().getResource("/demo-servlet.html").toURI()))
                    .stream()
                    .collect(Collectors.joining(""));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
