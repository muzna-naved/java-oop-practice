import java.io.*;
import java.net.*;

public class WebPageReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://uok.edu.pk/"); // Replace with your URL
            InputStreamReader isr = new InputStreamReader(url.openStream());
            BufferedReader reader = new BufferedReader(isr);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print or save each line
            }

            reader.close(); // Always close the reader
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


