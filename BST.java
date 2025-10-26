import java.util.*;
import java.io.*;

public class BST {

    // Read tree from text file
    static void DisplayTree() {
        try {
            FileReader r = new FileReader("C:\\Users\\saad\\Documents\\BST.tab");
            try {
                int i;
                while ((i = r.read()) != -1) {
                    System.out.print((char) i);
                }
            } finally {
                r.close();
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Inorder Traversal
    static void inorder(int index, int[][] node) {
        if (index == -1) {
            return;
        }
        inorder(node[index][0], node);
        System.out.println(node[index][1]);
        inorder(node[index][2], node);
    }

    public static void main(String[] args) {
        int[][] node = {
                { 3, 45, 1 },
                { 4, 52, 2 },
                { 7, 77, 8 },
                { -1, 17, 5 },
                { -1, 49, -1 },
                { 6, 38, -1 },
                { -1, 20, 10 },
                { -1, 60, -1 },
                { -1, 93, 9 },
                { -1, 95, -1 },
                { -1, 25, -1 }
        };

        int left = 0, data = 1, right = 2;
        int rootIndex = 0;
        int i;

        String message = "";
        Scanner input = new Scanner(System.in);
        while (!message.equalsIgnoreCase("quit")) {
            // Menu options
            System.out.println("------Options:------");
            System.out.println("1. Print all the leaf nodes.");
            System.out.println("2. Search a value in the tree.");
            System.out.println("3. Search a value and print its child and parent.");
            System.out.println("4. Inorder Traversal of the tree.");
            System.out.println("5. Display tree from text file.");
            System.out.println("--------------------");
            System.out.println();
            System.out.println("Enter your choice (1-5): ");
            int choice = input.nextInt();
            input.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    // Print leaf node
                    System.out.println("Leaf nodes: ");
                    for (i = 0; i < node.length; i++) {
                        if (node[i][left] == -1 && node[i][right] == -1) {
                            System.out.println(node[i][data]);
                        }
                    }
                    break;
                case 2:
                    // Searches a value
                    System.out.print("Enter a value to search in tree: ");
                    int value = input.nextInt();
                    input.nextLine(); 
                    boolean found = false;

                    for (i = 0; i < node.length; i++) {
                        if (node[i][1] == value) {
                            System.out.println("Value " + value + " found in tree at index (" + i + "," + data + ")");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Value " + value + " not found in tree");
                    }
                    break;
                case 3:
                    // Searches a value and print its child and parent
                    System.out.print("Enter a value to search its parent and child in tree: ");
                    int searchvalue = input.nextInt();
                    input.nextLine(); 
                    boolean searchfound = false;

                    for (i = 0; i < node.length; i++) {
                        if (node[i][data] == searchvalue) {
                            System.out
                                    .print("Value " + searchvalue + " found in tree at index (" + i + "," + data + ")");
                            if (node[i][left] != -1) {
                                System.out.print(", Left Child: " + node[node[i][left]][data]);
                            } else {
                                System.out.print(", Left Child: null");
                            }
                            if (node[i][right] != -1) {
                                System.out.print(", Right Child: " + node[node[i][right]][data]);
                            } else {
                                System.out.print(", Right Child: null");
                            }

                            // Find parent
                            boolean parentFound = false;
                            for (int j = 0; j < node.length; j++) {
                                if (node[j][left] == i || node[j][right] == i) {
                                    System.out.print(", Parent: " + node[j][data]);
                                    parentFound = true;
                                }
                            }
                            if (!parentFound) {
                                System.out.print(", Parent: null");
                            }
                            System.out.println();
                            searchfound = true;
                            break;
                        }
                    }
                    if (!searchfound) {
                        System.out.println("Value " + searchvalue + " not found in tree");
                    }
                    break;
                case 4:
                    // Inorder Traversal
                    System.out.println("Inorder Traversal of the tree:");
                    inorder(rootIndex, node);
                    break;
                case 5:
                    // Display tree from text file
                    System.out.println("Tree from text file:");
                    DisplayTree();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-5).");
                    break;
            }
            System.out.println("\nEnter 'quit' to exit or press Enter to continue: ");
            message = input.nextLine();
        }
        input.close();
    }
}