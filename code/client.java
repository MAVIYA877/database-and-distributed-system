import java.io.*;
import java.net.*;

public class client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        PrintWriter output = 
                new PrintWriter(socket.getOutputStream(), true);

        output.println("hello Distributes System!");

        socket.close();
    }
}