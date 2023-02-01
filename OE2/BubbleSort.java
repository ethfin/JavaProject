import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] ary = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the index [" + i + "] number :");
            ary[i] = sc.nextInt();
        }

        do {
            System.out.print("Enter [1] for Bubble Sort.");
            System.out.println("Enter [2] for Insertion Sort.");
            System.out.println("Enter [0] to Exit the Program.");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bubbleSort(ary);
                    promptAndWait();
                    break;
                case 2:
                    insertionSort(ary);
                    promptAndWait();
                    break;
                case 0:
                    System.out.println("Closing the program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    promptAndWait();
            }
        } while (true);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int iteration = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                iteration++;
            }
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        int iteration = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                iteration++;
            }
            arr[j + 1] = key;
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void print(String str){
        System.out.println(str);
    }

}
