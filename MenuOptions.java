import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MenuOptions {
    // method to open the sales file
    public static Scanner openSalesFile() throws FileNotFoundException {
        // file object for the sales data file
        File salesFile = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");
        // scanner to read the file
        Scanner fileReader = new Scanner(salesFile);
        fileReader.nextLine(); // skip headings
        return fileReader;
    }

    // method to calculate total sales amount
    public static void totalSalesAmount() {
        try {
            Scanner fileReader = openSalesFile();
            double totalSalesAmount = 0;

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
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // method to calculate employee-wise sales total
    public static void employeeWiseSalesTotal() {
        try {
            Scanner fileReader = openSalesFile();

            // map to store total sales for each employee
            HashMap<String, Double> employeeTotalSales = new HashMap<>();

            // read file line by line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();

                // split the line by tab space
                String[] columns = line.split("\\t");

                // get values from the line
                String employeeId = columns[2]; // Rep ID
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
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // method to calculate product-wise sales
    public static void productWiseSales() {
        try {
            Scanner fileReader = openSalesFile();

            // to store total sales for each product
            HashMap<String, Double> productTotalSales = new HashMap<>();

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
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // method to calculate region-wise sales
    public static void regionWiseSales() {
        try {
            Scanner fileReader = openSalesFile();

            // to store total sales for each region
            HashMap<String, Double> regionTotalSales = new HashMap<>();

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
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // method to calculate month-wise sales
    public static void monthWiseSales() {
        try {
            Scanner fileReader = openSalesFile();

            // create hashmap to store total sales for each month
            HashMap<String, Double> monthSales = new HashMap<>();

            // read file line by line
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine(); // read one line
                String[] parts = line.split("\\t"); // split by tab

                // get month name from date
                String date = parts[0];
                String month = date.split("-")[1]; // take middle part

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
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    // main method
    public static void main(String[] args) {
        try {
            // Open file
            File file = new File("C:\\Users\\saad\\Downloads\\EVE01Sales.txt");
            Scanner fileReader = new Scanner(file);

            // Read the header line
            String headerLine = fileReader.nextLine();
            String[] headers = headerLine.split("\\t"); // split by tab

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n---- MENU ----");
                System.out.println("1. Total sales amount");

                // print options automatically using header names
                for (int i = 1; i <= 4 && i < headers.length; i++) {
                    System.out.println((i + 1) + ". " + headers[i] + " wise sales amount");
                }
                System.out.println("6. Quit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You selected: Total sales amount");
                        totalSalesAmount();
                        break;
                    case 2:
                        System.out.println("You selected: Employee wise sales total");
                        employeeWiseSalesTotal();
                        break;
                    case 3:
                        System.out.println("You selected: Product wise sales amount");
                        productWiseSales();
                        break;
                    case 4:
                        System.out.println("You selected: Region wise sales amount");
                        regionWiseSales();
                        break;
                    case 5:
                        System.out.println("You selected: Month wise sales amount");
                        monthWiseSales();
                        break;
                    case 6:
                        System.out.println("Quitting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again!");
                }

            } while (choice != 6);

            fileReader.close();
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
