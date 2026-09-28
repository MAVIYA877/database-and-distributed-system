import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws Exception{
        
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("server started...");
        System.out.println("waiting for client...");

        Socket socket = serverSocket.accept();

        BufferedReader input = 
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
        String message = input.readLine();
        
        System.out.println("Client says: " + message);

        socket.close();
        serverSocket.close();

    } 
}