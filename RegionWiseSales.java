import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class RegionWiseSales {
    public static void main(String[] args) {
        try {
            // make a file object for the sales data
            File salesFile = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");

            // make a scanner to read the file
            Scanner fileReader = new Scanner(salesFile);

            // to store total sales for each region
            HashMap<String, Double> regionTotalSales = new HashMap<>();

            fileReader.nextLine(); // skip the first line (headings)

            // read file line by line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine(); // read one line
                String[] columns = line.split("\\t"); // split by tab space

                // get region, quantity and unit price
                String regionName = columns[1];
                int quantity = Integer.parseInt(columns[4]);
                double unitPrice = Double.parseDouble(columns[5]);

                // calculate total sale for this line
                double lineTotal = quantity * unitPrice;

                // add this sale to region’s total
                if (regionTotalSales.containsKey(regionName)) {
                    double currentTotal = regionTotalSales.get(regionName);
                    regionTotalSales.put(regionName, currentTotal + lineTotal);
                } else {
                    regionTotalSales.put(regionName, lineTotal);
                }
            }

            // print total sales for each region
            for (String regionName : regionTotalSales.keySet()) {
                System.out.println(regionName + " = " + regionTotalSales.get(regionName));
            }

            // close the file
            fileReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
