import java.util.InputMismatchException;
import java.util.Scanner;

public class PT2 {
    public static Scanner input = new Scanner(System.in); //For user input.
    public static Scanner promptAndWait = new Scanner(System.in); //Pauses the program in order for better reading.
    private static int MAX; //Maximum size for the list.
    private static Node head; //Node for the LinkedList

    public static class Node {
        int data; //Stored values
        Node prev; //previous node
        Node next; //next node
        Node(int d) { data = d; }
    }

    public static void main(String[] args) {
        funcs list = new funcs();
        IOHandler ioh = new IOHandler();
        int ch; //User's choice of function.

        System.out.println("Enter the MAX value for the Node:");
        MAX = ioh.getNumInput("User:> ");
        input.nextLine();

        System.out.println("Enter " + MAX + " values to insert (separated by spaces. Ex:'1 2 3 4 5'):");
        String insNodeData = ioh.getStrInput("User:> ");
        String[] insNodeDataArr = insNodeData.split(" ");
        for (int i = 0; i < MAX; i++) {
            int insNodeSplitData = Integer.parseInt(insNodeDataArr[i]);
            list.inNode(insNodeSplitData);
        }
        ioh.promptAndWait();

        do {
            ioh.cls();
            list.trFrontNode();
            System.out.println("Choose an operation:");
            System.out.println("[1] Insert.");
            System.out.println("[2] Delete.");
            System.out.println("[3] Search.");
            System.out.println("[4] Traverse.");
            System.out.println("[0] Exit.");
            ch = ioh.getNumInput("User:> ");
            switch (ch) {
                case 1:
                    System.out.println("Enter the value to insert");
                    int insNodeDataNew = ioh.getNumInput("User:> ");
                    list.inNode(insNodeDataNew);
                    ioh.promptAndWait();
                    break;
                case 2:
                list.trFrontNode();
                    System.out.println("Enter the value to delete");
                    int delNodeData = ioh.getNumInput("User:> ");
                    list.deNode(delNodeData);
                    ioh.promptAndWait();
                    break;
                case 3:
                    System.out.println("Enter the value to search.");
                    int seaNodeData = ioh.getNumInput("User:> ");
                    if (list.seNode(seaNodeData)) {
                        System.out.println("Node with data " + seaNodeData + " found in the list.");
                    } else {
                        System.out.println("Node with data " + seaNodeData + " not found in the list.");
                    }
                    ioh.promptAndWait();
                    break;
                case 4:
                    list.trFrontNode();
                    list.trBackNode();
                    ioh.promptAndWait();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid operation.");
                    ioh.promptAndWait();
            }
        } while(ch !=0);
        input.close();
        promptAndWait.close();
    }

    private static class IOHandler { //Handler for better optimization
        private void promptAndWait() { //Wait for the user's input before proceeding
            System.out.print("Press any key to continue...");
            promptAndWait.nextLine();
        }
    
        private int getNumInput(String prompt) { //Gets the user's input value. Must be an integer.
            int i = 0;
            boolean valid = false;
            do {
                try { //check the input if its a integer or a string
                    System.out.print(prompt);
                    i = input.nextInt();
                    valid = true;
                } catch (InputMismatchException e) { //if input is string, then repeat the prompt.
                    System.out.println("Please provide an integer value.");
                    input.nextLine();
                }
            } while (!valid);
            return i;
        }

        private String getStrInput(String prompt) { //Gets the user's input for string.
            System.out.print(prompt);
            return input.nextLine();
        }
    
        private void cls() { //clears the terminal for better view.
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static class funcs{
        public void trFrontNode() { //traverse the LinkedList
            Node current = head;
            System.out.print("List: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void trBackNode() {
            Node current = head;
            Node previous = null;
            current = head;
            Node next = null;
        
            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
        
            // Set the head of the linked list to the last node, which is now the first node after the reversal
            head = previous;
        
            // Traverse the reversed linked list
            current = head;
            System.out.print("Reversed List: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void inNode(int ins_NodeData) { //Insert data into Node.
            Node new_node = new Node(ins_NodeData);
            new_node.next = head;
            new_node.prev = null;
            if (head != null)
                head.prev = new_node;
            head = new_node;
            System.out.println("Node with data " + ins_NodeData + " inserted at the beginning of the list.");
            return;
        }
    
        public void deNode(int del_NodeData) { //Delete a specific value in LinkedList.
            Node temp = head;
            if (temp != null && temp.data == del_NodeData) {
                head = temp.next;
                head.prev = null;
                System.out.println("Node with data " + del_NodeData + " deleted from the list.");
                return;
            }
            while (temp != null && temp.data != del_NodeData) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Node with data " + del_NodeData + " not found in the list.");
                return;
            }
            temp.prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            System.out.println("Node with data " + del_NodeData + " deleted from the list.");
            return;
        }
    
        public boolean seNode(int sea_NodeData) { //search for a value in LinkedList.
            Node current = head;
            while (current != null) {
                if (current.data == sea_NodeData) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }
}