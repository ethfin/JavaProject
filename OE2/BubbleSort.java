import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] defaultArray = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the index [" + i + "] number :");
            defaultArray[i] = sc.nextInt();
        }

        do {
            System.out.println("Enter [1] for Bubble Sort.");
            System.out.println("Enter [2] for Insertion Sort.");
            System.out.println("Enter [0] to Exit the Program.");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bubbleSort(defaultArray);
                    promptAndWait();
                    break;
                case 2:
                    insertionSort(defaultArray);
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

    public static void bubbleSort(int[] tempArr) {
        int n = tempArr.length;
        int iteration = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tempArr[j] > tempArr[j + 1]) {
                    int temp = tempArr[j];
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = temp;
                }
                iteration++;
            }
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    public static void insertionSort(int[] tempArr) {
        int n = tempArr.length;
        int iteration = 0;

        for (int i = 1; i < n; i++) {
            int key = tempArr[i];
            int j = i - 1;

            while (j >= 0 && tempArr[j] > key) {
                tempArr[j + 1] = tempArr[j];
                j = j - 1;
                iteration++;
            }
            tempArr[j + 1] = key;
        }

        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println("\nNumber of iterations: " + iteration);
    }

    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}