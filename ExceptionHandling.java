public class ExceptionHandling {
    public static void main(String[] args) {

        // Divide two numbers

        try {
           int divide = 10/0;
           System.out.println("Result of division: " + divide);
        } catch (ArithmeticException e) {
            System.out.println("Caught an arithmetic exception: " + e.getMessage());
        }

        // Multiple Exceptions

         try {
            // 1. Arithmetic Exception
            int result = 10 / 0;

            // 2. Array Index Out of Bounds Exception
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);

            // 3. Null Pointer Exception
            String text = null;
            System.out.println(text.length());

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception caught: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception caught: " + e.getMessage());
        } catch (Exception e) {
            // General catch block for any other exception
            System.out.println("Some other exception caught: " + e.getMessage());
        }

        System.out.println("Program continues after handling exceptions.");
    }        
}
    

