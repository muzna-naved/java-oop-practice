// The connection continues until the client sends the keyword "quit".

import java.io.*;
import java.net.*;
public class TCPClient_quit {

    public static void main(String[] args) throws IOException {
        // Connect to server running on localhost and port 9090
        Socket socket = new Socket("localhost", 9090);

        // Output stream to send messages to server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Input stream to receive messages from server
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // To read user input from keyboard
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String input;
        System.out.println("Type messages to send to server. Type 'quit' to exit.");

        // Continuously take user input, send to server, and print server's response
        while (true) {
            System.out.print("You: ");
            input = userInput.readLine();  // Read message from user
            out.println(input);            // Send message to server

            // If user types "quit", exit the loop
            if (input.equalsIgnoreCase("quit"))
                break;

            // Read and display server response
            String response = br.readLine();
            System.out.println("Server says: " + response);
        }

        // Close socket after communication ends
        socket.close();
    }
}

