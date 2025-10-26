import java.util.Scanner;

public class LinkedList {
    private static final int MAX_SIZE = 10; // Maximum size of arrays
    private int[] data = new int[MAX_SIZE]; // Stores values
    private int[] next = new int[MAX_SIZE]; // Stores next indices
    private int head = -1; // Index of first node
    private int next_free = 0; // Next available index
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        while (true) {
            System.out.println("\n----Linked List Operations----");
            System.out.println("1. Create Linked List");
            System.out.println("2. Add elements to the linked list");
            System.out.println("3. Display Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = list.scanner.nextInt();
            switch (choice) {
                case 1:
                    list.createLinkedList();
                    break;
                case 2:
                    list.addElements();
                    break;
                case 3:
                    list.displayLinkedList();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    list.scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public void createLinkedList() {
        System.out.print("Enter the size of the linked list (max " + MAX_SIZE + "): ");
        int size = scanner.nextInt();
        if (size <= 0 || size > MAX_SIZE) {
            System.out.println("Invalid size! Must be between 1 and " + MAX_SIZE + ".");
            return;
        }
        // Reset the list
        head = -1;
        next_free = 0;
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            int value = scanner.nextInt();
            insertElement(value); // Insert in sorted order
        }
        System.out.println("Linked list created successfully.");
    }

    public void addElements() {
        if (next_free >= MAX_SIZE) {
            System.out.println("List is full! Cannot add more elements.");
            return;
        }
        System.out.print("Enter element to add: ");
        int value = scanner.nextInt();
        insertElement(value);
        System.out.println("Element " + value + " added successfully.");
    }

    private void insertElement(int value) {
        if (next_free >= MAX_SIZE) {
            return; // Silent return if full (handled in addElements)
        }
        // Allocate new node
        int newIndex = next_free;
        data[newIndex] = value;
        next[newIndex] = -1; // Initialize next as end
        next_free++;

        // Insert into empty list or at start
        if (head == -1 || data[head] >= value) {
            next[newIndex] = head;
            head = newIndex;
            return;
        }

        // Find insertion point (middle or end)
        int prev = head;
        int curr = next[head];
        while (curr != -1 && data[curr] < value) {
            prev = curr;
            curr = next[curr];
        }
        // Link new node
        next[newIndex] = curr;
        next[prev] = newIndex;
    }

    public void displayLinkedList() {
        if (head == -1) {
            System.out.println("Linked list is empty.");
            return;
        }
        System.out.print("Linked list elements (sorted): ");
        int curr = head;
        while (curr != -1) {
            System.out.print(data[curr]);
            curr = next[curr];
            if (curr != -1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}