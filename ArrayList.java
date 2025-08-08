import java.util.*;

public class ArrayList {
    public static void main(String[] args) {
        // Create an ArrayList
        java.util.ArrayList a = new java.util.ArrayList();
        // Add elements to the ArrayList
        a.add(10);
        a.add(30);
        a.add(1, 10);
        a.remove(1); // Remove element at index 1
        a.clear(); // Clear the ArrayList
        System.out.println("ArrayList: " + a); // Print the ArrayList

        // String ArrayList example
        java.util.ArrayList b = new java.util.ArrayList();
        b.add("Cars");
        b.add("Bikes");
        b.add("Trucks");
        b.contains(b.get(0)); // Check if the first element is in the list
        b.set(0, "Buses"); // Replace the first element with "Buses"
        b.sort(null); // Sort the ArrayList

        // Print the sorted ArrayList
        for (Object vehicles : b) {
            System.out.println(vehicles);
        }
    }
}