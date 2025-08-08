import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {

        float[][] sales = { 
          // A     B     C    D     E    F
            {530, 1035, 304, 220, 258, 546},  // E011
            {820,  945, 192,  60,  96, 966},  // E012
            {110, 1320, 568, 200,  90,1386},  // E013
            {660,  270, 392, 230,  90,1386}   // E014
        };

        String[] repIds = {"E011", "E012", "E013", "E014"};

        String[] products = {"Product A", "Product B", "Product C", "Product D", "Product E", "Product F"};

        // Total sales amount of employee id E013

        int employeeIndex = 2; // E013
        float total = 0;
        for (int i = 0; i < sales[employeeIndex].length; i++) {
            total += sales[employeeIndex][i];
        }
        System.out.println("\nTotal sales amount of employee id E013: " + total);

        int productIndex = 4; // Product E
        total = 0;
        for(int i=0;i<sales.length;i++){
            total += sales[i][productIndex];
        }

        // Total sales amount of product E

        System.out.println("Total sales amount of product E: " + total);

        //Sales amount of product F by E014

        System.out.println("Sales amount of product F by E014: " + sales[3][5]);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose an option:");
        System.out.println("1 - RepID wise sum");
        System.out.println("2 - Product wise sum");
        int choice = scanner.nextInt();

        // Choices

        if(choice ==1){
            System.out.println("Please choose Rep ID.");
            for (int i=0 ; i<repIds.length; i++) {
                System.out.println((i+1) + " - " + repIds[i]);
            }
            int repChoice = scanner.nextInt() - 1;
            if (repChoice >= 0 && repChoice < repIds.length) {
                total = 0;
                for (int i = 0; i < sales[repChoice].length; i++) {
                    total += sales[repChoice][i];
                }
                System.out.println("Total sales amount of " + repIds[repChoice] + ": " + total);
            } else {
                System.out.println("Invalid Rep ID choice.");
            }
        }
        else if(choice == 2){
            System.out.println("Please choose Product.");
            for (int i=0 ; i<products.length; i++) {
                System.out.println((i+1) + " - " + products[i]);
            }
            int productChoice = scanner.nextInt() - 1;
            if (productChoice >= 0 && productChoice < products.length) {
                total = 0;
                for (int i = 0; i < sales.length; i++) {
                    total += sales[i][productChoice];
                }
                System.out.println("Total sales amount of " + products[productChoice] + ": " + total);
            } else {
                System.out.println("Invalid Product choice.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}