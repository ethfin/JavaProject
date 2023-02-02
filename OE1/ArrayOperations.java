import java.util.Scanner;

public class ArrayOperations {
    
    private static final int MAX = 100;
    
    public static void main(String[] args) {
        int[] input = new int[MAX];
        int inp, c;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number of indices in the array : ");
        inp = sc.nextInt();

        // Read array elements
        for (int i = 0; i < inp; i++) {
            System.out.print("Enter the index [" + i + "] number :");
            input[i] = sc.nextInt();
        }

        do {
            // Display the array elements
            System.out.print("\nArray list {");
            for (int x = 0; x < inp; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.print(" }\n");

            // Display the menu
            System.out.println("[1] Searching Array");
            System.out.println("[2] Delete an element on the Array");
            System.out.println("[3] Update an element on the Array");
            System.out.println("[4] Traverse the Arrays");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");
            c = sc.nextInt();

            switch (c) {
                case 1 -> {
                    search(input, inp);
                    promptAndWait();
                }
                
                case 2 -> {
                    del(input, inp);
                    promptAndWait();
                }
                
                case 3 -> {
                    upd(input, inp);
                    promptAndWait();
                }
                    
                case 4 -> {
                    tra(input, inp);
                    promptAndWait();
                }
    
                case 0 -> {
                    System.out.println("Closing the program...");
                    return;
                }
                
                default -> {
                    System.out.println("Error, please try again...");
                    promptAndWait();
                }
            }
            
        } while (true);
    }
    
    public static void search(int[] input, int inp) {
        int searchIndex;
        boolean found = false;
        do {
            System.out.print("Enter an index to find the Element: ");
            Scanner sc = new Scanner(System.in);
            searchIndex = sc.nextInt();
            if (searchIndex >= 0 && searchIndex < inp) {
                System.out.println("Element at index " + searchIndex + " is " + input[searchIndex]);
                found = true;
            } else {
                System.out.println("Invalid index to search, please try again.");
            }
        } while (!found);
    }


    public static void promptAndWait() {
        System.out.print("Press any key to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    
    //delete an element in the array
    public static void del(int[] input, int inp) {
        Scanner sc = new Scanner(System.in);
        int deleteIndex;
        boolean isDeleted = false;
        do {
            System.out.print("Array list {");
            for (int x = 0; x < inp; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.println(" }");

            System.out.print("Enter the index to delete: ");
            deleteIndex = sc.nextInt();

            if (deleteIndex >= 0 && deleteIndex < inp) {
                input[deleteIndex] = 0;
                System.out.println("Element at index " + deleteIndex + " is deleted");
                isDeleted = true;
            } else {
                System.out.println("Invalid index to delete, please try again.");
            }
        } while (!isDeleted);
    }


    //update an element in the array
    //This method updates a specific index in an array list
    public static void upd(int[] input, int inp) {
        //Create Scanner object
        Scanner sc = new Scanner(System.in);
        while (true) {
            //Print elements of array
            System.out.print("Array list {");
            for (int x = 0; x < inp; x++) {
                System.out.print(" " + input[x]);
            }
            System.out.println(" }");
    
            //Ask for index to update
            System.out.print("Enter the index to update: ");
            int updateIndex = sc.nextInt();
            //Check if the index is valid
            if (updateIndex >= 0 && updateIndex < inp) {
                //Ask for new value
                System.out.print("Enter the number to update: ");
                input[updateIndex] = sc.nextInt();
                System.out.println("Element at index " + updateIndex + " is updated.");
                break;
            } else {
                //If index is not valid print error message
                System.out.println("Invalid index to update, please try again");
            }
        }
    }
    
    

    //traverse the array
    // Prints an array with the index and value of each element
    public static void tra(int[] input, int inp) {
        System.out.println("Array list:");
        for(int x = 0; x < inp; x++) {
            // Prints the index and value of each element
            System.out.printf("Number on indexd contains value of %d  \n", x, input[x]);
        }
    }
    
}