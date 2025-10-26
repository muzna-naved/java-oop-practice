import java.util.Scanner;

/**
 * This program finds a root (where f(x) = 0) for the equation f(x) = 3x^2 - 5x + 6
 * using the Bisection Method. It asks for two points (a and b) and a small number (epsilon)
 * to decide how precise the answer should be. If inputs are invalid, it asks again.
 */
public class BisectionMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, epsilon;

        // Keep asking for inputs until they are valid
        while (true) {
            // Get inputs with clear prompts
            a = getNumber(scanner, "Enter the start of the interval (a, like -3): ");
            b = getNumber(scanner, "Enter the end of the interval (b, like 0): ");
            epsilon = getNumber(scanner, "Enter a small number for precision (epsilon, like 0.0001): ");

            // Check if a < b
            if (a >= b) {
                System.out.println("Oops! The start (a) must be less than the end (b). Try again!");
                continue;
            }

            // Check if epsilon is positive
            if (epsilon <= 0) {
                System.out.println("Oops! Precision (epsilon) must be a positive number. Try again!");
                continue;
            }

            // Check function values at a and b
            double fa = calculateFunction(a);
            double fb = calculateFunction(b);

            // Check if the function changes sign (f(a) * f(b) < 0)
            if (fa * fb >= 0) {
                System.out.println("Oops! No root found between a and b. The function needs opposite signs.");
                System.out.println("f(a) = " + fa + ", f(b) = " + fb + ". Try different numbers!");
                continue;
            }

            // If all checks pass, break the loop
            break;
        }

        scanner.close(); // Done with input

        // Perform the Bisection Method
        double mid = 0; // Midpoint of the interval
        while (b - a >= epsilon) {
            mid = (a + b) / 2; // Find the middle point
            double fMid = calculateFunction(mid); // Check function at midpoint

            // Decide which half of the interval to keep
            if (calculateFunction(a) * fMid < 0) {
                b = mid; // Root is in left half
            } else {
                a = mid; // Root is in right half
            }
        }

        // Show the answer
        System.out.printf("The root is about: %.6f%n", mid);
    }

    /**
     * Calculates the value of f(x) = 3x^2 - 5x + 6.
     * @param x The number to plug into the function.
     * @return The result of the function.
     */
    private static double calculateFunction(double x) {
        return 3 * x * x - 5 * x + 6;
    }

    /**
     * Gets a number from the user and checks if it's valid.
     * @param scanner The tool to read user input.
     * @param message The message to show the user.
     * @return A valid number entered by the user.
     */
    private static double getNumber(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // Clear bad input
            }
        }
    }
}