// The connection continues until the client sends the keyword "quit".

import java.io.*;
import java.net.*;

public class TCPServer_quit {

    public static void main(String[] args) throws IOException {
        // Create a server socket listening on port 9090
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server Started. Waiting for client to connect...");

        // Accept the incoming client connection (blocking call)
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client Connected.");

        // Create input stream to read messages from client
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Create output stream to send messages to client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String message;

        // Keep reading messages from the client until "quit" is received
        while ((message = br.readLine()) != null) {
            if (message.equalsIgnoreCase("quit")) {
                // If client sends "quit", close connection
                System.out.println("Client disconnected.");
                break;
            }

            // Print received message and send response
            System.out.println("Client says: " + message);
            out.println("Message received: " + message);
        }

        // Close sockets after communication ends
        clientSocket.close();
        serverSocket.close();
    }
}

