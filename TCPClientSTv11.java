import java.io.*;
import java.net.*;

class TCPClientSTv11
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 1000);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msgForServer = "";
        String stream = "";

        while (true) {
            // Get message from user
            System.out.print("Write your message for the server: ");
            msgForServer = br.readLine();

            // Send message to server
            dos.writeUTF(msgForServer);
            dos.flush();

            // Check if client typed "bye"
            if (msgForServer.equalsIgnoreCase("bye")) {
                // Wait for server's "bye" response
                stream = dis.readUTF();
                System.out.println("Response from Server: " + stream);
                break; // Exit the loop to end communication
            }

            // Read server's response
            stream = dis.readUTF();
            System.out.println("Response from Server: " + stream);

            // Check if server sent "bye"
            if (stream.equalsIgnoreCase("bye")) {
                break; // Exit the loop to end communication
            }
        }

        // Close all streams and socket
        br.close();
        dos.close();
        dis.close();
        s.close();
    }
}