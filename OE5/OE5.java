import java.util.InputMismatchException;
import java.util.Scanner;

public class OE5 {
    public static Scanner input = new Scanner(System.in);
    public static Scanner promptAndWait = new Scanner(System.in);

    public static void main(String[] args) {
        //Classes instances
        IOHandler ioh = new IOHandler();

        int n = ioh.getNumInput("Enter the number of elements in the array: ");
        int[] len = new int[n];
        input.nextLine();

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            len[i] = ioh.getNumInput("User:> ");
        }

        funcs.quickSort(len, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(len[i] + " ");
        }
        System.out.println();

        ioh.promptAndWait();
        input.close();
    }

    private static class IOHandler {
        private void promptAndWait() {
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
    }

    private static class funcs {
        public static int arrItems(int[] len, int min, int max) {
            int pivot = len[max];
            int i = min - 1;
    
            for (int j = min; j < max; j++) {
                if (len[j] <= pivot) {
                    i++;
    
                    int temp = len[i];
                    len[i] = len[j];
                    len[j] = temp;
                }
            }
    
            int temp = len[i + 1];
            len[i + 1] = len[max];
            len[max] = temp;
    
            return i + 1;
        }
        
        public static void quickSort(int[] len, int min, int max) {
            if (min < max) {
                int pivotIndex = arrItems(len, min, max);
    
                quickSort(len, min, pivotIndex - 1);
                quickSort(len, pivotIndex + 1, max);
            }
        }
    }
}
