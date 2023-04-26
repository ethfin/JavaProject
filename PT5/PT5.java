import java.util.Scanner;
import java.util.InputMismatchException;

public class PT5 {
    public static Scanner input = new Scanner(System.in);
    public static Scanner promptAndWait = new Scanner(System.in);

    public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        IOHandler ioh = new IOHandler();
        Functions fun = new Functions();

        int n = ioh.getNumInput("Enter the number of nodes: ");
        Node root = null;
        for (int i = 0; i < n; i++) {
            int val = ioh.getNumInput("Enter the value of node " + (i + 1) + ": ");
            root = fun.insert(root, val);
        }
        System.out.println("Binary tree created successfully!");
        ioh.promptAndWait();

        do {
            ioh.cls();
            System.out.println("Choose the traversal option: ");
            System.out.println("[1] In-order Traversal");
            System.out.println("[2] Pre-order Traversal");
            System.out.println("[3] Post-order Traversal");
            System.out.println("[0] Exit.");
            int option = ioh.getNumInput("Prompt:>");
            switch (option) {
                case 1:
                    System.out.println("In-order Traversal:");
                    fun.inOrder(root);
                    ioh.promptAndWait();
                    break;
                case 2:
                    System.out.println("Pre-order Traversal:");
                    fun.preOrder(root);
                    ioh.promptAndWait();
                    break;
                case 3:
                    System.out.println("Post-order Traversal:");
                    fun.postOrder(root);
                    ioh.promptAndWait();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selected");
                    ioh.promptAndWait();
            }
        } while (true);
    }

    public static class Functions{
        public Node insert(Node root, int val) {
            if (root == null) {
                return new Node(val);
            }
            if (val < root.val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root;
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }

        public void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }
    
    private static class IOHandler {    
        private int getNumInput(String prompt) {
            int i = 0;
            boolean valid = false;
            do {
                try {
                    System.out.print(prompt);
                    i = input.nextInt();
                    valid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please provide an integer value.");
                    input.nextLine();
                }
            } while (!valid);
            return i;
        }

        private void promptAndWait() {
            System.out.println("");
            System.out.print("Press any key to continue...");
            promptAndWait.nextLine();
        }

        private void cls() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}