package pl.sda;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * add to tomcat-users-xml suitable role and user
 * <p>
 * <role rolename="user"/>
 * <user username="admin" password="admin" roles="user"/>
 * <p>
 * decode Authentication header at https://www.base64decode.org/
 */
public class SecuredServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "This is secured content" + "</h1>");
    }
}
