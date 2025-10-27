import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class ProductWiseSales {
    public static void main(String[] args) {
        try {
            // make a file object for the sales data
            File salesFile = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");

            // make a scanner to read the file
            Scanner fileReader = new Scanner(salesFile);

            // to store total sales for each product
            HashMap<String, Double> productTotalSales = new HashMap<>();

            fileReader.nextLine(); // skip the first line (headings)

            // read file line by line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine(); // read one line
                String[] columns = line.split("\\t"); // split by tab space

                // get product name, quantity and unit price
                String productName = columns[3];
                int quantity = Integer.parseInt(columns[4]);
                double unitPrice = Double.parseDouble(columns[5]);

                // calculate total for this product in this line
                double lineTotal = quantity * unitPrice;

                // add this line total to the product’s total sales
                if (productTotalSales.containsKey(productName)) {
                    double currentTotal = productTotalSales.get(productName);
                    productTotalSales.put(productName, currentTotal + lineTotal);
                } else {
                    productTotalSales.put(productName, lineTotal);
                }
            }

            // print each product’s total sales
            for (String productName : productTotalSales.keySet()) {
                System.out.println(productName + " = " + productTotalSales.get(productName));
            }

            // close the file
            fileReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
