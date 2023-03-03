import java.util.Scanner;

public class OE3 {
    private static final Scanner scan = new Scanner(System.in);
    private Node list;

    // Node class
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    // Insertion at the beginning
    public void inBeg(int data) {
        Node insertBeg = new Node(data);
        insertBeg.next = list;
        list = insertBeg;
    }

    // Insertion at the end
    public void inEnd(int data) {
        Node inEnd = new Node(data);
        if (list == null) {
            list = inEnd;
            return;
        }
        Node current = list;
        while (current.next != null) {
            current = current.next;
        }
        current.next = inEnd;
    }

    // Insertion after specified node
    public void inAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null.");
            return;
        }
        Node inAfter = new Node(data);
        inAfter.next = prevNode.next;
        prevNode.next = inAfter;
    }

    // Print the linked list
    public void printList() {
        Node current = list;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node search(int data) {
        Node current = list;
        while (current != null && current.data != data) {
            current = current.next;
        }
        return current;
    }

    public static void promptAndWait() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press any key to continue...");
        sc.nextLine();
    }
    public static void main(String[] args) {
        OE3 list = new OE3();

        while (true) {//Loop the entire menu in order to give the user an option to choose.
            System.out.print("\033[H\033[2J");
            System.out.println("Please choose an operation:");
            System.out.println("[1] Insert value from beginning of the list (Choose this first in inital start of the program)");
            System.out.println("[2] Insert value from end");
            System.out.println("[3] Insert value after node");
            System.out.println("[4] Print list");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            int ch = scan.nextInt();
        
            switch (ch) {
                case 1:
                    System.out.print("Enter numbers to insert (separated by space): ");
                    scan.nextLine();
                    String inBeg = scan.nextLine();
                    
                    if (inBeg.isEmpty()) {
                        System.out.println("No input provided.");
                        return;
                    }
                    
                    String[] inBegNum = inBeg.split(" ");
                    for (int i = 0; i < inBegNum.length; i++) {
                        try {
                            int n = Integer.parseInt(inBegNum[i]);
                            list.inEnd(n);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input: " + inBegNum[i] + " is not an integer.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter multiple values to insert (separated by space): ");
                    scan.nextLine();
                    String inEnd = scan.nextLine();
                    
                    if (inEnd.isEmpty()) {
                        System.out.println("No input provided.");
                        return;
                    }
                    
                    String[] inEndNum = inEnd.split(" ");
                    for (int i = 0; i < inEndNum.length; i++) {
                        try {
                            int n = Integer.parseInt(inEndNum[i]);
                            list.inEnd(n);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input: " + inEndNum[i] + " is not an integer.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter multiple values to insert: ");
                    int inAfterNum = scan.nextInt();
                    System.out.print("Enter the value after which to insert: ");
                    int inPreNum = scan.nextInt();
                    Node inAfterPrev = list.search(inPreNum);
                    list.inAfter(inAfterPrev, inAfterNum);
                    break;
                case 4:
                    list.printList();
                    promptAndWait();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Error... Invalid choice. Please try again.");
            }
        }
    }
}