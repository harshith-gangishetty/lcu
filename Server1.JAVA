import java.io.*;
import java.net.*;

public class    Server1 {
    private Socket socket;
    private ServerSocket server;
    private DataInputStream input;

    public Server1(int port) {
        try {
            // Creating a server socket to listen on the specified port
            server = new ServerSocket(port);
            System.out.println("Server Started");
            System.out.println("Waiting for client .....");

            // Accepting a connection from a client
            socket = server.accept();
            System.out.println("Client accepted");

            // Setting up input stream to receive data from the client
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            // Reading data from the client until "Over" is received
            String line = "";
            while (!line.equals("Over")) {
                line = input.readUTF();
                System.out.println(line);
            }

            // Closing the connection when the loop ends
            System.out.println("Closing connection");
            socket.close();
            input.close();
        } catch (Exception e) {
            // Handling exceptions (Note: It's generally not recommended to ignore exceptions)
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the Server1 class with port 5000
        new Server1(5000);
    }
}