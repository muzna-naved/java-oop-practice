import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class EmployeeWiseSales {
    public static void main(String[] args) {
        try {
            // make a file object for the sales file
            File salesFile = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");

            // create a scanner to read the file
            Scanner fileReader = new Scanner(salesFile);

            // map to store total sales for each employee
            HashMap<String, Double> employeeTotalSales = new HashMap<>();

            fileReader.nextLine(); // skip the first line (headings)

            // read file line by line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                // split the line by tab space
                String[] columns = line.split("\\t");

                // get values from the line
                String employeeId = columns[2];         // Rep ID
                int quantity = Integer.parseInt(columns[4]); // Qty
                double unitPrice = Double.parseDouble(columns[5]); // Unit Price

                // calculate total sale for this line
                double lineTotal = quantity * unitPrice;

                // add to employee’s total sales
                if (employeeTotalSales.containsKey(employeeId)) {
                    double currentTotal = employeeTotalSales.get(employeeId);
                    employeeTotalSales.put(employeeId, currentTotal + lineTotal);
                } else {
                    employeeTotalSales.put(employeeId, lineTotal);
                }
            }

            // print each employee’s total sales
            for (String employeeId : employeeTotalSales.keySet()) {
                System.out.println(employeeId + " = " + employeeTotalSales.get(employeeId));
            }

            // close the file
            fileReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
