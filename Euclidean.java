import java.util.Scanner;

public class Euclidean {
    static int gcd(int m, int n) {
        if (m == 0) {
            return n;  // Base case: gcd(0, n) = n
        }
        return gcd(n % m, m);  // Recursive case: gcd(n mod m, m)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter the second number (n): ");
        int n = scanner.nextInt();
        System.out.println("GCD of " + m + " and " + n + " is: " + gcd(m, n));
        scanner.close();
    }
}