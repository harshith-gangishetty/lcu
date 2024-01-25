import java.io.*;
import java.net.*;

public class Client1 {
    private Socket socket;
    private BufferedReader input;
    private DataOutputStream output;

    public Client1(String address, int port) {
        try {
            // Creating a socket connection to the server
            socket = new Socket(address, port);
            System.out.println("Connection Successful");

            // Setting up input stream to read from the console
            input = new BufferedReader(new InputStreamReader(System.in));

            // Setting up output stream to send data to the server
            output = new DataOutputStream(socket.getOutputStream());

            // Reading input from the console and sending it to the server until "Over" is entered
            String line = "";
            while (!line.equals("Over")) {
                line = input.readLine();
                output.writeUTF(line);
            }

            // Closing streams and socket when the loop ends
            input.close();
            output.close();
            socket.close();
        } catch (Exception e) {
            // Handling exceptions (Note: It's generally not recommended to ignore exceptions)
        }
    }

    public static void main(String[] args) {
        // Creating an instance of the Client1 class with server address "127.0.0.1" and port 5000
        new Client1("127.0.0.1", 5000);
    }
}