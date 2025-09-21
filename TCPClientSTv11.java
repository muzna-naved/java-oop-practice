import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClientSTv11
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 1000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String msgForServer = "";
        String response = "";

        boolean clientbye = false;
        boolean serverbye = false;

        while (true) {
            // Get and send message from user
            System.out.print("You: ");
            msgForServer = sc.nextLine();
            dos.writeUTF(msgForServer);
            dos.flush();

            // Check if client sent "bye"
            if (msgForServer.equalsIgnoreCase("bye")) {
                clientbye = true;
            }

            // Read and print server's response
            response = dis.readUTF();
            System.out.println("Server says: " + response);

            // Check if server sent "bye"
            if (response.equalsIgnoreCase("bye")) {
                serverbye = true;
            }

            // Check if both have sent "bye" to end
            if (clientbye && serverbye) {
                break;
            }
        }

        // Close all streams and socket
        sc.close();
        dos.close();
        dis.close();
        s.close();
    }
}