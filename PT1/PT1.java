import java.util.Scanner;

public class PT1 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        do {
            int ch;

            System.out.print("\033[H\033[2J");
            System.out.println("[1] Stack Algo");
            System.out.println("[2] Queue Algo");
            System.out.println("[0] Exit Program");
            System.out.print("\nSelect an Option: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: {
                    int[] arr1 = new int[5];
                    System.out.println("Enter 5 elements: ");
                    for (int i = 0; i < arr1.length; i++) {
                        arr1[i] = sc.nextInt();
                    }
                    Stack Stack = new Stack();
                    System.out.println("Initial Stack is Empty : " + Stack.isEmpty());
                    Stack.push(arr1[0]);
                    Stack.push(arr1[1]);
                    Stack.push(arr1[2]);
                    Stack.push(arr1[3]);
                    Stack.push(arr1[4]);

                    System.out.println("After Pushing\n");
                    System.out.println("Element at the top of the stack " + "[" + Stack.peek() + "]\n");
                    Stack.display();
                    promptAndWait();
                    Stack.pop();
                    Stack.pop();

                    System.out.println("\nAfter Popping\n");
                    Stack.display();
                    promptAndWait();
                    break;
                }
                case 2: {
                    int[] arr2 = new int[4];
                    System.out.println("Enter 4 elements: ");
                    for (int i = 0; i < arr2.length; i++) {
                        arr2[i] = sc.nextInt();
                    }
                    Queue Queue = new Queue(4);

                    System.out.println("Initial Queue:");
                    Queue.QueueDisplay();
                    Queue.Queue_Enqueue(arr2[0]);
                    Queue.Queue_Enqueue(arr2[1]);
                    Queue.Queue_Enqueue(arr2[2]);
                    Queue.Queue_Enqueue(arr2[3]);

                    System.out.println("After Enqueue:");
                    Queue.QueueDisplay();
                    Queue.QueueFront();

                    Queue.Queue_Enqueue(90);
                    Queue.QueueDisplay();
                    Queue.Queue_Dequeue();
                    Queue.Queue_Dequeue();
                    System.out.printf("\nQueue after two dequeue operations:");
                    Queue.QueueDisplay();
                    Queue.QueueFront();
                    promptAndWait();
                    break;
                }
                case 0: {
                    return;
                }
            }
        } while (true);
    }

    public static class Stack {
        int t, MAXSIZE = 5;
        int[] arr = new int[MAXSIZE];

        Stack() {
            t = -1;
        }

        boolean isEmpty() {
            return (t < 0);
        }

        boolean push(int n) {
            if (t == MAXSIZE - 1) {
                System.out.println("Stack Overflow");
                return false;
            } else {
                t++;
                arr[t] = n;
                return true;
            }
        }

        boolean pop() {
            if (t == -1) {
                System.out.println("Stack Underflow");
                return false;
            } else {

                System.out.println("\nItem popped: " + arr[t--]);
                return true;
            }
        }

        int peek() {
            return arr[t];
        }

        void display() {
            System.out.println("Printing stacked elements:");
            for (int i = t; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
        }

    }

    public static void promptAndWait() {
        System.out.print("\nPress any key to continue:");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static class Queue {
        private static int top, cap, bottom;
        private static int queue[];

        Queue(int size) {
            top = bottom = 0;
            cap = size;
            queue = new int[cap];
        }

        static void Queue_Enqueue(int i) {
            if (cap == bottom) {
                System.out.printf("\nQueue is full\n");
                return;
            }

            else {
                queue[bottom] = i;
                bottom++;
            }
            return;
        }

        static void Queue_Dequeue() {

            if (top == bottom) {
                System.out.printf("\nQueue is empty\n");
                return;
            }

            else {
                for (int i = 0; i < bottom - 1; i++) {
                    queue[i] = queue[i + 1];
                }

                if (bottom < cap)
                    queue[bottom] = 0;

                bottom--;
            }
            return;
        }

        static void QueueDisplay() {
            int i;
            if (top == bottom) {
                System.out.printf("Queue is Empty\n");
                return;
            }

            for (i = top; i < bottom; i++) {
                System.out.printf(" %d ", queue[i]);
            }
            return;
        }

        static void QueueFront() {
            if (top == bottom) {
                System.out.printf("Queue is Empty\n");
                return;
            }
            System.out.printf("\nFront Element of the queue: %d", queue[top]);
            return;
        }
    }
}
