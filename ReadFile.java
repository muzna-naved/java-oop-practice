import java.io.FileReader;


public class ReadFile {

    // Method to read a file and display its content in the console

    static void  DisplayConsole() {
    try{
         FileReader r = new FileReader("C:\\Users\\Dell\\Downloads\\Text.txt");

         try{
            int i;
            while ((i= r.read())!=-1) {
                System.out.print((char)i);
            }
         }
         finally{
            r.close();
         }
        }
        catch(Exception e){
        System.out.println("Error reading file: " + e.getMessage());
        }    
    }

    // Method to display content in Notepad
    static void displayNotepad(){

        // Using Runtime to open the file in Notepad
        try {
            Runtime.getRuntime().exec("notepad.exe C:\\Users\\Dell\\Downloads\\Text.txt");
        } catch (Exception e) {
            System.out.println("Error opening file: " + e.getMessage());
        }

        // Using ProcessBuilder to open the file in Notepad
        // try {
        // ProcessBuilder builder = new ProcessBuilder("notepad.exe", "C:\\Users\\Dell\\Downloads\\Text.txt");
        // builder.start(); // Starts a new process
        // } catch (Exception e) {
        // System.out.println("Error opening Notepad: " + e.getMessage());
        // }

    }

    public static void main(String[] args) {
        
        DisplayConsole();
        displayNotepad();

    }
    
}
