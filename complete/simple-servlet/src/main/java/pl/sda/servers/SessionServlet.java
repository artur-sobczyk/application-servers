package pl.sda.servers;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Integer counter = 0;

        if (session.getAttribute("counter") != null) {
            counter = (Integer) session.getAttribute("counter");
        }

        counter++;
        session.setAttribute("counter", counter);

        resp.getWriter().write("counter: " + counter);
    }
}