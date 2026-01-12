import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ShoutServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(777);
        Socket clientSocket = serverSocket.accept();

        PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        out.println("connection made");

        String inputLine = null;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine.toUpperCase());
            if (inputLine.equals("bye")) {
                break;
            }
            out.println(inputLine.toUpperCase());
        }
        out.println("BYE");

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
