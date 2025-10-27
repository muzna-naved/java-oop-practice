import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class MonthWiseSales {
    public static void main(String[] args) {
        try {
            // make file object for your sales file
            File file = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");

            // make scanner to read file
            Scanner input = new Scanner(file);

            // create hashmap to store total sales for each month
            HashMap<String, Double> monthSales = new HashMap<>();

            input.nextLine(); // skip the first line (headings)

            // read file line by line
            while (input.hasNextLine()) {
                String line = input.nextLine(); // read one line
                String[] parts = line.split("\\t"); // split by tab

                // get month name from date (like "Jun" from "17-Jun-2019")
                String date = parts[0];
                String month = date.split("-")[1]; // take middle part (Jun, Jul, Aug)

                // get quantity and unit price
                int qty = Integer.parseInt(parts[4]);
                double price = Double.parseDouble(parts[5]);

                // find total for this line
                double total = qty * price;

                // add total to that month
                if (monthSales.containsKey(month)) {
                    monthSales.put(month, monthSales.get(month) + total);
                } else {
                    monthSales.put(month, total);
                }
            }

            // print total sales for each month
            System.out.println("Month-wise Total Sales:");
            for (String month : monthSales.keySet()) {
                System.out.println(month + " = " + monthSales.get(month));
            }

            // close file
            input.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
