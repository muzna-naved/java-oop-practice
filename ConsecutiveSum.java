import java.util.Scanner;

public class ConsecutiveSum {
    static int sum(int n) {
        if(n==1) {
            return 1;
        } 
        else {
            return n + sum(n - 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int result = sum(n);
            System.out.println("The sum of all integers from 1 to " + n + " is: " + result);
        }
        scanner.close();
    }
}
