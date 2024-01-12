package LA3Q1;

import java.util.Scanner;

public class DemoStackAndQueue_Ryan {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        myHeader(3);

        System.out.println("This code performs a demo for Stack and Queue:\n");
        //Loops the menu and prints corresponding info that matches user input
        while (true) {
            System.out.println("Main Demo-Menu:");
            System.out.println("1: Stack\n2: Queue\n3: Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    RyanArray stack = new RyanArray();
                    System.out.println("\nYou have an empty stack: []");
                    stackDemo(stack);
                    break;
                case 2:
                    RyanArray queue = new RyanArray();
                    System.out.println("\nYou have an empty queue: []");
                    queueDemo(queue);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    myFooter(3);
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    //Stack function which removes elements from the last position
    public static void stackDemo(RyanArray stack){
        Scanner input = new Scanner(System.in);

        while (true) {
            //Prompts user to enter a decision
            System.out.println("\nStack Operation Menu:\na: Push\nb: Pop\nc: Exit\n");
            System.out.print("Enter your choice: ");
            String choice = input.next().toLowerCase();
            //Switch to check user input and outputs the corresponding info
            switch (choice) {
                //Adds user inputted information into the array
                case "a":
                    System.out.println("Let's push a data-item into the stack....");
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    System.out.print("Enter name: ");
                    String name = input.next();
                    stack.addAtLastIndex(new Pair<>(year, name));
                    System.out.println("The current stack: " + stack.toString());
                    break;
                case "b":
                    //Removes the last element and returns the new array
                    System.out.println("Let's pop a data-item ....");
                    try {
                        Pair<?,?> delete = stack.removeFromLastIndex();
                        System.out.println(delete.toString() + "is removed! The current stack: " + stack.toString());
                    } catch (IllegalStateException e) {
                        System.out.println("FYI: The stack is empty");
                    }
                    break;
                case "c":
                    //Ends the demo
                    System.out.println("Ending Stack-demo! Goodbye!\n");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    //Queue function which removes elements from the first position
    public static void queueDemo(RyanArray queue){
        Scanner input = new Scanner(System.in);

        while (true) {
            //Prompts user to enter a decision
            System.out.println("\nQueue Operation Menu:\na: Enqueue\nb: Dequeue\nc: Exit");
            System.out.print("Enter your choice: ");
            String choice = input.next().toLowerCase();
            //Switch to check user input and outputs the corresponding info
            switch (choice) {
                case "a":
                    System.out.println("Let's enqueue a data-item in the queue....");
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    System.out.print("Enter name: ");
                    String name = input.next();
                    queue.addAtLastIndex(new Pair<>(year, name));
                    System.out.println("The current queue: " + queue.toString());
                    break;
                case "b":
                    //Removes the first element and returns the new array
                    System.out.println("Let's dequeue a data-item ....");
                    try {
                        Pair<?,?> delete = queue.removeFromFirstIndex();
                        System.out.println(delete.toString() + "is dequeued! The current queue: " + queue.toString());
                    } catch (IllegalStateException e) {
                        System.out.println("FYI: The stack is empty");
                    }
                    break;
                case "c":
                    //Ends the demo
                    System.out.println("Ending Stack-demo! Goodbye!\n");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    //Header function
    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q1\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Stack and Queuing!\n" +
                "=======================================================");
    }
    //Footer function
    public static void myFooter(int lab){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q1 is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
}
