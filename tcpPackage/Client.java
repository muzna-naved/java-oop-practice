package tcpPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String ip;
    private int port;
    private String name;

    public Client(String ip, int port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }

    public void send() {
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            out.println(name); // Send the name to server

            String message;
            while (true) {
                System.out.print("You: ");
                message = sc.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("quit")) {
                    System.out.println("You left the chat.");
                    break;
                }

                String response = in.readLine();
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}