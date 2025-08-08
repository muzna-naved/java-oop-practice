// This Java program accesses a webpage, saves its content to a file, and opens it in Google Chrome.

import java.io.*;
import java.net.*;

public class AccessWebpage {
    public static void main(String[] args) {
        try {
            // Step 1: Create a URL object for the webpage you want to access
            URL url = new URL("https://uok.edu.pk/");

            // Step 2: Set the full path where you want to save the webpage file
            String outputFile = "C:\\Java\\webpage.html"; // Make sure this folder exists

            // Step 3: Create a BufferedReader to read data from the webpage
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream())
            );

            // Step 4: Create a BufferedWriter to write the data into a file
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(outputFile)
            );

            // Step 5: Read each line from the webpage and write it into the file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);     // write line to file
                writer.newLine();       // write new line character
            }

            // Step 6: Close the reader and writer to free system resources
            reader.close();
            writer.close();

            // Step 7: Show confirmation message in the console
            System.out.println("Webpage saved to: " + outputFile);

            // Step 8: Open the saved file in Google Chrome using Windows command
            String command = "cmd /c start chrome \"" + outputFile + "\"";
            Runtime.getRuntime().exec(command);

        } catch (Exception e) {
            // Step 9: Print any errors if they occur
            e.printStackTrace();
        }
    }
}
