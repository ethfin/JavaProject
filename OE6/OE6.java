import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class OE6 {

    public static Scanner input = new Scanner(System.in);
    public static Scanner promptAndWait = new Scanner(System.in);

    public static void main(String[] args) {
        
        IOHandler ioh = new IOHandler();

        int n = ioh.getNumInput("Enter the number of elements to sort: ");

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = ioh.getNumInput("Prompt: ");
        }

        funcs.quicksort(arr, 0, n - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static class funcs {
        public static void quicksort(int[] arr, int start, int end) {
            // Use quicksort for large arrays
            if (start < end) {
                int pivot = partition(arr, start, end);
                quicksort(arr, start, pivot - 1);
                quicksort(arr, pivot + 1, end);
            }
        }
    
        public static int partition(int[] arr, int start, int end) {
            int pivot = arr[end];
            int i = start - 1;

            for (int j = start; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, end);
            return i + 1;
        }
    
        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static class IOHandler {    
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
}