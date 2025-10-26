import java.util.Scanner;

// Main class to manage a linked list using an array of Nodes
public class Linked_List {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Initialize the starting index for the linked list
        Node.startingIndex = 1;
        
        // Initialize the linked list with some sample nodes
        Node[] linkedList = { new Node(65, 3), new Node(15, 2), new Node(45, 0), new Node(72, -1) };

        // Main program loop to handle user actions
        String message = "";
        while (!message.equalsIgnoreCase("quit")) {
            // Display the menu of available actions
            System.out.println("ACTIONS:\n\t1. Create a new linked list.");
            System.out.println("\t2. Add an element to the list.");
            System.out.println("\t3. Print all the elements of the list.");
            System.out.print("\nPlease choose an action from above (1-3): ");

            // Read the user's choice
            message = scanner.nextLine().trim();

            // Handle the user's choice
            if (message.equalsIgnoreCase("1")) {
                // Option 1: Create a new empty linked list
                linkedList = new Node[0];
                Node.startingIndex = -1; // Reset the starting index
                System.out.println("New linked list created.");
            } else if (message.equalsIgnoreCase("2")) {
                // Option 2: Add a new element to the list
                System.out.print("Enter the element: ");
                try {
                    float num = scanner.nextFloat(); // Read the number to add
                    scanner.nextLine(); // Clear the newline character from input
                    linkedList = addElement(num, linkedList); // Add the number
                    System.out.println("Element " + num + " added to the list.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                }
            } else if (message.equalsIgnoreCase("3")) {
                // Option 3: Print the linked list
                printLinkedList(linkedList);
            } else if (!message.equalsIgnoreCase("quit")) {
                // Handle invalid menu options
                System.out.println("Invalid choice! Please select 1, 2, 3, or 'quit'.");
            }
        }

        // Close the scanner to free resources
        scanner.close();
        System.out.println("Program terminated.");
    }

    // Method to print all elements in the linked list
    public static void printLinkedList(Node[] linkedList) {
        System.out.println("\nLinked List:");
        if (Node.startingIndex == -1) {
            // Handle empty list case
            System.out.println("The list is empty.");
        } else {
            // Follow the nextIndex links to print each node's data
            int currentIndex = Node.startingIndex;
            while (currentIndex != -1) {
                System.out.println(linkedList[currentIndex].data);
                currentIndex = linkedList[currentIndex].nextIndex; // Move to the next node
            }
        }
        System.out.println("\n");
    }

    // Method to add a new element to the linked list in sorted order
    public static Node[] addElement(float newNum, Node[] linkedList) {
        int currentIndex = Node.startingIndex; // Current node index
        int previousIndex = Node.startingIndex; // Previous node index

        if (linkedList.length == 0) {
            // If the list is empty, add the new node as the first element
            linkedList = addListElement(linkedList, new Node(newNum, -1));
            Node.startingIndex = 0; // Set the starting index to 0
        } else if (newNum < linkedList[currentIndex].data) {
            // If the new number is smaller than the first node, add it at the start
            Node.startingIndex = linkedList.length; // New node will be at the end of the array
            linkedList = addListElement(linkedList, new Node(newNum, currentIndex));
        } else {
            // Find the correct position to insert the new number
            while (currentIndex != -1 && linkedList[currentIndex].data <= newNum) {
                previousIndex = currentIndex; // Keep track of the previous node
                currentIndex = linkedList[currentIndex].nextIndex; // Move to the next node
            }

            // Insert the new node after the node at previousIndex
            linkedList[previousIndex].nextIndex = linkedList.length; // Point previous node to new node
            linkedList = addListElement(linkedList, new Node(newNum, currentIndex)); // Add new node
        }

        return linkedList; // Return the updated array
    }

    // Helper method to add a new node to the end of the array
    public static Node[] addListElement(Node[] linkedList, Node element) {
        // Create a new array with one more slot
        Node[] newLinkedList = new Node[linkedList.length + 1];

        // Copy existing nodes to the new array
        for (int i = 0; i < linkedList.length; i++) {
            newLinkedList[i] = linkedList[i];
        }

        // Add the new node at the end
        newLinkedList[newLinkedList.length - 1] = element;

        return newLinkedList; // Return the new array
    }
}

// Node class to represent an element in the linked list
class Node {
    static int startingIndex; // Static variable to store the index of the first node
    float data; // The value stored in the node
    int nextIndex; // The index of the next node in the array (-1 for the last node)

    // Constructor to create a new node
    Node(float data, int nextIndex) {
        this.data = data;
        this.nextIndex = nextIndex;
    }
}