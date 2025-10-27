import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TotalSalesAmount {
    public static void main(String[] args) {
        try {
            // make a file object for the sales data file
            File salesFile = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");

            // make a scanner to read the file
            Scanner fileReader = new Scanner(salesFile);

            double totalSalesAmount = 0; // this will store total sales of all employees

            fileReader.nextLine(); // skip the first line (headings)

            // read file line by line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine(); // read one line

                // split the line by tab space
                String[] columns = line.split("\\t");

                // get quantity and unit price
                int quantity = Integer.parseInt(columns[4]);
                double unitPrice = Double.parseDouble(columns[5]);

                // calculate total for this line
                double lineTotal = quantity * unitPrice;

                // add to total sales amount
                totalSalesAmount = totalSalesAmount + lineTotal;
            }

            // print total sales amount
            System.out.println("Total Sales Amount: " + totalSalesAmount);

            // close the file
            fileReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
