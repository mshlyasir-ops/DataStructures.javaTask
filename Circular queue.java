
import java.util.Scanner;

class CircularQueue {
    int[] queue;
    int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    void enqueue(int value) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full!");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;

        System.out.println(value + " inserted");
    }

    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println(queue[front] + " removed");

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int n = sc.nextInt();

        CircularQueue cq = new CircularQueue(n);

        while (true) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    cq.enqueue(value);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
                    break;

                case 4:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}