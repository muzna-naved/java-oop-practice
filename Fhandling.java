
import java.io.*;

public class Fhandling {

    public static void main(String[] args) throws IOException{
    //     Creating a File

        // File file = new File("C:\\Users\\Dell\\Documents\\NewFile.txt");
        // try{
        //     if(file.createNewFile()){
        //     System.out.println("File Created!!");
        // }
        // else{
        //     System.out.println("Already exist");
        // }
        // }
        // catch(IOException e){
        //     System.out.println("I/O");
        // }
        // catch(Exception e){
        //     System.out.println("Exception handled");
        // }

    //  File Information

        // File file = new File("C:\\Users\\Dell\\Documents\\NewFile.txt");
        // if(file.exists()){
        //     System.out.println("File Name:"+ file.getName());
        //     System.out.println("File Path:"+ file.getAbsolutePath());
        //     System.out.println("Readable"+ file.canRead());
        //     System.out.println("Writeable:"+ file.canWrite());
        //     System.out.println("File Size:"+ file.length());
        // }
        // else{
        //     System.out.println("File doesn't exist");
        // }

    //Writing Data

    // Using FileWriter
    // try{
    //     FileWriter file = new FileWriter("C:\\Users\\Dell\\Documents\\NewFile.txt");
    //     try{
    //         file.write("Hey I'm Muzna...");
    //         System.out.println("Done!");
    //     }
    //     finally{
    //         file.close();
    //     }
    //     System.out.println("Done");
    // }
    // catch(Exception e){
    //      System.out.println(e);
    // }

    // Using BufferedWriter

    // try{
    //     FileWriter file = new FileWriter("C:\\Users\\Dell\\Documents\\NewFile.txt");
    //     BufferedWriter myFile = new BufferedWriter(file);

    //     try{
    //         myFile.write("I love coding<3");
    //         System.out.println("Done!");
    //     }
    //     finally{
    //         myFile.close();
    //     }
    //     System.out.println("Done");
    // }
    // catch(Exception e){
    //      System.out.println(e);
    // }

    // Using Fileoutputstream

    //  try{
       
    //     FileOutputStream myFile = new FileOutputStream("C:\\\\Users\\\\Dell\\\\Documents\\\\NewFile.txt",true);

    //     try{
    //         myFile.write("I love coding<3".getBytes());
    //         System.out.println("Done!");
    //     }
    //     finally{
    //         myFile.close();
    //     }
    //     System.out.println("Done");
    // }
    // catch(Exception e){
    //      System.out.println(e);
    // }

    // Using PrintWriter

    //  try{
        //  PrintWriter myFile = new PrintWriter("C:\\\\Users\\\\Dell\\\\Documents\\\\NewFile.txt");

    //     try{
    //         myFile.write("Java Program..");
    //         System.out.println("Done!");
    //     }
    //     finally{
    //         myFile.close();
    //     }
    //     System.out.println("Done");
    // }
    // catch(Exception e){
    //      System.out.println(e);
    // }

    // Read Data

    // Using FileReader

    // try{
    //      FileReader r = new FileReader("C:\\\\Users\\\\Dell\\\\Documents\\\\NewFile.txt");

    //      try{
    //         int i;
    //         while ((i= r.read())!=-1) {
    //             System.out.print((char)i);
    //         }
    //      }
    //      finally{
    //         r.close();
    //      }
    // }
    // catch(Exception e){
    //     System.out.println("File read successfully");
    // }

    // Using BufferedReader

    // try{
    //      BufferedReader r = new BufferedReader(new FileReader("C:\\\\\\\\Users\\\\\\\\Dell\\\\\\\\Documents\\\\\\\\NewFile.txt"));

    //      try{
    //         String i;
    //         while ((i= r.readLine())!=null) {
    //             System.out.print(i);
    //         }
    //      }
    //      finally{
    //         r.close();
    //      }
    // }
    // catch(Exception e){
    //     System.out.println("File read successfully");
    // }

    // Using Scanner Class

    // try{
    //      File file = new File("C:\\Users\\Dell\\Documents\\NewFile.txt");
    //       Scanner input = new Scanner(file);
    //      try{

    //         while (input.hasNextLine()) {
    //             String line = input.nextLine();
    //             System.out.print(line);
    //         }
    //      }
    //      finally{
    //         input.close();
    //      }
    // }
    // catch(Exception e){
    //     System.out.println("File read successfully");
    // }

     // Using Fileinputstream
     
    // try{
    //      FileInputStream r = new FileInputStream("C:\\\\\\\\Users\\\\\\\\Dell\\\\\\\\Documents\\\\\\\\NewFile.txt");

    //      try{
    //         int i;
    //         while ((i= r.read())!=-1) {
    //             System.out.print((char)i);
    //         }
    //      }
    //      finally{
    //         r.close();
    //      }
    // }
    // catch(Exception e){
    //     System.out.println("File read successfully");
    // }

    //Rename File

    // File f = new File("C:\\Users\\Dell\\Documents\\NewFile.txt");
    // File f1 = new File("C:\\Users\\Dell\\Documents\\TextFile.txt");
    
    //     if (f.exists()) {
    //         boolean success = f.renameTo(f1);
    //         if (success) {
    //             System.out.println("Renamed successfully!");
    //         } else {
    //             System.out.println("Rename failed!");
    //         }
    //     } else {
    //         System.out.println("File does not exist");
    //     }

    //Copy content from one file to another 

    // FileInputStream r = new FileInputStream("C:\\\\Users\\\\Dell\\\\Documents\\\\NewFile.txt");
    // FileOutputStream w = new FileOutputStream("C:\\\\Users\\\\Dell\\\\Documents\\\\MyFile.txt");
    // int i;
    // while ((i = r.read()) != -1) {
    //     w.write((char)i);
    //     }
    //     System.out.println("Data copied successfully!!");
    //     r.close();
    //     w.close();    
        
    }

}
