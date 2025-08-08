public class BinarySearch {

    static int BS(int arr[],int target, int start,int end) {
        if(start <= end) {
            int mid = start + (end - start) / 2; // To avoid overflow
            if(target > arr[mid]) {
                return BS(arr, target, mid + 1, end); // Search in the right half
            }
            else if(target < arr[mid]) {
                return BS(arr, target, start, mid - 1); // Search in the left half
            }
            else {
                return mid; // Target found
            }
        }
        else {
            return -1; // Target not found
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 3, 5, 9,12};
        int target = 8;
        int n = arr.length;

        int result = BS(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("Element not found in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
