import java.net.*;
import java.io.*;

public class Server {

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	
	public Server(int port)
	{
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server Started");
			
			System.out.println("Waiting for a client...");
			
			socket = server.accept();
			System.out.println("Client Accepted");
			
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String line = "";
			
			while(!line.contentEquals("Over"))
			{
				try
				{
					line = in.readUTF();
					System.out.println(line);
				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			System.out.println("Closing Connection");
			socket.close();
			in.close();
			
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server(5001);
	}

}