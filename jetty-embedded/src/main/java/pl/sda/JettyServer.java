package pl.sda;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyServer {

    private Server server;

    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[]{connector});

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(DemoServlet.class, "/*");
        server.setHandler(servletHandler);
        server.start();
    }

    public static void main(String... s) throws Exception{
        System.out.println("http://localhost:8090/");
        new JettyServer().start();
    }
}
