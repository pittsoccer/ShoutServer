import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		
		ServerSocket ss = new ServerSocket(80);
		
		ss.accept();
		
		System.out.println("Connection Accepted");
	}
}
