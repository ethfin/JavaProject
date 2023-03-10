import java.util.Scanner;

public class OE4 {
    public static Scanner input = new Scanner(System.in);
    public static Scanner promptAndWait = new Scanner(System.in);
    public static void main(String[] args) {
        //Classes instances
        Recursion rec = new Recursion();
        IOHandler ioh = new IOHandler();
        //-----------------
        int ch;//Stores the value the user wants to pick
        do {
            ioh.cls();
            System.out.println("[1] Fibonacci series number");
            System.out.println("[2] Factorial of a number");
            System.out.println("[3] Reverse a number");
            System.out.println("[4] Reverse a word");
            System.out.println("[5] Tower of Hanoi");
            System.out.println("[0] Exit the program");
            ch = ioh.getNumInput("Select your choice: ");
            switch (ch) {
                case 1://Fibonacci Algorithm
                    int fibNum = ioh.getNumInput("Enter the number of terms in the Fibonacci series: ");
                    System.out.print("Fibonacci series: ");
                    for (int i = 0; i < fibNum; i++) {
                        System.out.print(rec.fib(i) + " ");
                    }
                    System.out.println();
                    ioh.promptAndWait();
                    break;
                case 2://Factorial Algorithm
                    int facNum = ioh.getNumInput("Enter a positive integer: ");
                    System.out.println("Factorial of " + facNum + " = " + rec.fac(facNum));
                    ioh.promptAndWait();
                    break;
                case 3://Reverse a Integer Algorithm
                    int revNum = ioh.getNumInput("Enter a positive integer: ");
                    System.out.println("Reverse of " + revNum + " = " + rec.revNum(revNum, 0));
                    ioh.promptAndWait();
                    break;
                case 4://Reverse a String Algorithm
                    String revWord = ioh.getStrInput("Enter a word: ");
                    System.out.println("Reverse of " + revWord + " = " + rec.revString(revWord));
                    ioh.promptAndWait();
                    break;
                case 5://Tower of Hanoi Algorithm
                    int TOHNum = ioh.getNumInput("Enter the number of disks: ");
                    System.out.println("Moves required to solve Tower of Hanoi:");
                    rec.TOH(TOHNum, 'A', 'C', 'B');
                    ioh.promptAndWait();
                    break;
                case 0://Exit the program
                    System.out.println("Exiting the program...");
                    break;
                default://Automatically falls to default if a user input an invalid Integer
                    System.out.println("Invalid choice. Please try again.");
                    ioh.promptAndWait();
            }
        } while (ch != 0);
        input.close();
        promptAndWait.close();
    }
    
    //This class is for optimizing
    private static class IOHandler {
        private void promptAndWait() {
            System.out.print("Press any key to continue...");
            promptAndWait.nextLine();
        }
    
        private int getNumInput(String prompt) {
            System.out.print(prompt);
            return input.nextInt();
        }
    
        private String getStrInput(String prompt) {
            System.out.print(prompt);
            return input.next();
        }
    
        private void cls() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
    
    //Algorithms are stored in class for better organization and encapsulation
    private static class Recursion {
        public int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            return fib(n-1) + fib(n-2);
        }
        
        public int fac(int num) {
            if (num == 0) {
                return 1;
            }
            return num * fac(num-1);
        }
        
        public int revNum(int x, int rev) {
            if (x == 0) {
                return rev;
            }
            return revNum(x / 10, rev * 10 + x % 10);
        }
        
        public String revString(String word) {
            if (word.length() == 0) {
                return "";
            }
            return word.charAt(word.length()-1) + revString(word.substring(0, word.length()-1));
        }
        
        public void TOH(int disks, char source, char destination, char auxiliary) {
            if (disks == 1) {
                System.out.println(source + " >>> " + destination);
                return;
            }
            TOH(disks-1, source, auxiliary, destination);
            System.out.println(source + " >>> " + destination);
            TOH(disks-1, auxiliary, destination, source);
        }
    }
}