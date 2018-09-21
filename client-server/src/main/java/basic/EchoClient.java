package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import static basic.EchoServer.ANSI_BLUE;
import static basic.EchoServer.ANSI_GREEN;
import static basic.EchoServer.ANSI_RESET;
import static basic.EchoServer.ANSI_YELLOW;

/**
 * @see EchoServer
 */
public class EchoClient {

    public final static String HOST = "localhost";

    public static void main(String[] argv) {
        EchoClient c = new EchoClient();
        c.converse(HOST);
    }

    private void converse(String hostname) {
        Socket sock = null;
        try {
            sock = new Socket(hostname, EchoServer.ECHOPORT);

            BufferedReader stdin = new BufferedReader(
                    new InputStreamReader(System.in));
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(sock.getInputStream(), "UTF-8"));
            PrintWriter os = new PrintWriter(
                    new OutputStreamWriter(
                            sock.getOutputStream(), "UTF-8"), true);

            String line;
            System.out.println(ANSI_YELLOW + "Connected to server..." + ANSI_RESET);
            do {
                System.out.print(ANSI_GREEN + ">> " + ANSI_RESET);
                if ((line = stdin.readLine()) == null)
                    break;

                os.println(line);
                String reply = is.readLine();
                System.out.println(ANSI_BLUE + "<< " + reply + ANSI_RESET);
            } while (line != null);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {                    // cleanup
            try {
                if (sock != null)
                    sock.close();
            } catch (IOException ignoreMe) {
                // nothing
            }
        }
    }
}
