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

        boolean clientbye = false;
        boolean serverbye = false;

        System.out.print("Waiting for client connection ...");

        s = ss.accept();
        System.out.println("Client connected");

        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

        while (true) {
            // Read message from client
            rcvdFromClient = dis.readUTF();
            System.out.println("Client says: " + rcvdFromClient);

            // Check if client sent "bye"
            if (rcvdFromClient.equalsIgnoreCase("bye")) {
                clientbye = true;
            }

            // Prepare and send response
            System.out.print("You: ");
            replyFromServer = br.readLine();
            dos.writeUTF(replyFromServer);
            dos.flush();

            // Check if server sent "bye"
            if (replyFromServer.equalsIgnoreCase("bye")) {
                serverbye = true;
            }

            // Check if both have sent "bye" to end
            if (clientbye && serverbye) {
                break;
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