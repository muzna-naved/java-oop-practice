public class MaxOfAnArray {

    // Recursive function to find the maximum value in the array
    static int findMax(int[] arr, int index) {

        // Base case: If we reach the last element, return it
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursive call: Find the max value in the rest of the array
        int maxOfRest = findMax(arr, index + 1);

        // Compare current element with max of rest and return the larger one
        if (arr[index] > maxOfRest) {
            return arr[index];
        } else {
            return maxOfRest;
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] numbers = {5, 8, 2, 9, 1};

        // Call the function starting from index 0
        int max = findMax(numbers, 0);

        // Print the maximum value
        System.out.println("Maximum value in the array is: " + max);
    }
}
