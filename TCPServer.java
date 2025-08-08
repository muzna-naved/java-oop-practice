import java.io.*;
import java.net.*;

// Original TCPServer.java code

// public class TCPServer {
//     public static void main(String args[]) throws IOException 
//     {
//         // create a server socket on port number 9090
//         ServerSocket serverSocket = new ServerSocket(9090);
//         System.out.println("Server is running and waiting for client connection...");

//         // Accept incoming client connection
//         Socket clientSocket = serverSocket.accept();
//         System.out.println("Client connected!");

//         // Setup input and output streams for communication with the client
//         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

//         // Read message from client
//         String message = in.readLine();
//         System.out.println("Client says: " + message);

//         // Send response to the client
//         out.println("Message received by the server.");

//         // Close the client socket
//         clientSocket.close();
//         // Close the server socket
//         serverSocket.close();
//     }
// }

// Code after modification

// The connection continues until the client sends the keyword "quit".

// public class TCPServer {
//     public static void main(String[] args) throws IOException {
//         // Create a server socket listening on port 9090
//         ServerSocket serverSocket = new ServerSocket(9090);
//         System.out.println("Server Started. Waiting for client to connect...");

//         // Accept the incoming client connection (blocking call)
//         Socket clientSocket = serverSocket.accept();
//         System.out.println("Client Connected.");

//         // Create input stream to read messages from client
//         BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//         // Create output stream to send messages to client
//         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

//         String message;

//         // Keep reading messages from the client until "quit" is received
//         while ((message = br.readLine()) != null) {
//             if (message.equalsIgnoreCase("quit")) {
//                 // If client sends "quit", close connection
//                 System.out.println("Client disconnected.");
//                 break;
//             }

//             // Print received message and send response
//             System.out.println("Client says: " + message);
//             out.println("Message received: " + message);
//         }

//         // Close sockets after communication ends
//         clientSocket.close();
//         serverSocket.close();
//     }
// }




