package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * One thread server allowing to connect only one client. To makeexample work:
 * - start {@link EchoServer}
 * - start {@link EchoClient}
 * - use EchoClient console to write requests,
 * - EchoServer will display it and send back
 *
 * Example can be used not only locally ba also using network. Just set in EchoClient proper IP address.
 */
public class EchoServer {

    public static final int ECHOPORT = 7;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private ServerSocket sock;

    public static void main(String[] args) {
        new EchoServer(ECHOPORT).handle();
    }

    private EchoServer(int port) {
        try {
            sock = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void handle() {
        Socket ios = null;
        BufferedReader is = null;
        PrintWriter os = null;

        while (true) {
            try {
                System.out.println(ANSI_YELLOW + "Waiting for client..." + ANSI_RESET);
                ios = sock.accept();

                System.out.println(ANSI_YELLOW + "Accepted from " + ios.getInetAddress().getHostName() + ANSI_RESET);
                is = new BufferedReader(new InputStreamReader(ios.getInputStream(), "UTF-8"));
                os = new PrintWriter(new OutputStreamWriter(ios.getOutputStream(), "UTF-8"), true);
                String echoLine;

                while ((echoLine = is.readLine()) != null) {
                    System.out.println(ANSI_GREEN + "Request: " + echoLine + ANSI_RESET);
                    os.println(echoLine);
                    os.flush();
                    System.out.println(ANSI_BLUE + "Response: " + echoLine + ANSI_RESET);
                }

            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                try {
                    if (is != null)
                        is.close();
                    if (os != null)
                        os.close();
                    if (ios != null)
                        ios.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
