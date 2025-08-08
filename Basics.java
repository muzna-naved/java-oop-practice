import java.util.Scanner;

public class Basics {

    //Method to find a factorial of a number

    public static double factorial (int n) {
        double fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {

        // This program prompts the user for their name and age, then prints a greeting message.
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        System.out.println("Hello " + name + ", you are " + age + " years old.");

        // This program calculates the sum and product of an array of integers.

        System.out.println("Calculating sum and product of array elements:");

        int[] arr = {1,2,3,4,5};
        int sum = 0,product = 1;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            product *= arr[i];
        } 

        System.out.println("Sum of array elements:" + sum );
        System.out.println("Product of array elements:" + product );

        // Calling the factorial method

        System.out.println("Enter a number to find its factorial:");
        int number = sc.nextInt();  
        double fact = factorial(number);
        System.out.println("Factorial of " + number + " is: " + fact);
        sc.close();
    }
    
}
