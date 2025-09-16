package tcpPackage;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            name = in.readLine();
            System.out.println(name + " has joined the chat!");

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("quit")) {
                    System.out.println(name + " has left the chat!");
                    break;
                }
                System.out.println(name + ": " + message);
                out.println("Message received");
            }
        } catch (IOException e) {
            System.out.println("Connection error with " + name);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}