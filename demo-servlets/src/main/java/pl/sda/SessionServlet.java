package pl.sda;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * See what happen if you remove JSESSIONID cookie.
 */
public class SessionServlet extends HttpServlet {

    private static int counter = 0;

    private static final String COUNTER_ATTRIBUTE_NAME = "COUNTER";
    private static final String TIME_ATTRIBUTE_NAME = "TIME";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(true);

        if (!session.getAttributeNames().hasMoreElements()) {
            session.setAttribute(TIME_ATTRIBUTE_NAME, LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            session.setAttribute(COUNTER_ATTRIBUTE_NAME, counter++);
        }

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>counter: " + session.getAttribute(COUNTER_ATTRIBUTE_NAME) + "</h1>");
        out.println("<h1>time: " + session.getAttribute(TIME_ATTRIBUTE_NAME) + "</h1>");
    }
}