import java.io.*;
import java.net.*;

class TCPServerSTv11 
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(1000);
        Socket s;

        DataInputStream dis;
        DataOutputStream dos;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String replyFromServer;
        String rcvdFromClient;

        System.out.print("Waiting for client connection ...");

        s = ss.accept();
        System.out.println("Client connected");

        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

        while (true) {
            // Read message from client
            rcvdFromClient = dis.readUTF();
            System.out.println("Client Said: " + rcvdFromClient);

            // Check if client sent "bye"
            if (rcvdFromClient.equalsIgnoreCase("bye")) {
                replyFromServer = "bye";
                dos.writeUTF(replyFromServer);
                dos.flush();
                break; // Exit the loop to end communication
            }

            // Server reads a reply from console
            System.out.print("Enter server's reply: ");
            replyFromServer = br.readLine();

            // Send reply to client
            dos.writeUTF(replyFromServer);
            dos.flush();

            // Check if server typed "bye"
            if (replyFromServer.equalsIgnoreCase("bye")) {
                break; // Exit the loop to end communication
            }
        }

        // Close all streams and sockets
        br.close();
        dis.close();
        dos.close();
        s.close();
        ss.close();
    }
}