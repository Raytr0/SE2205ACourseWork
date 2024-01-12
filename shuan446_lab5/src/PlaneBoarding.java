import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlaneBoarding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Two different queues for different priorities
        Queue<String> priorityQueue = new LinkedList<>();
        Queue<String> regularQueue = new LinkedList<>();
        myHeader(5);
        System.out.println("Airplane Boarding and Disembarking Application");
        System.out.println("Enter the choice number when choosing options.");

        while (true) {
            //Options to chose for boarding, disembarking, displaying queues, and quitting the program
            System.out.println("1. Add Passenger to Boarding Queue");
            System.out.println("2. Disembark Passengers");
            System.out.println("3. Display Boarding Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //Asks user which priority the passenger is
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();

                    System.out.println("Select passenger type:");
                    System.out.println("1. Priority (Military, Family with Young Children, Elderly, Disabled ect.)");
                    System.out.println("2. Regular");
                    System.out.print("Enter passenger type: ");

                    int passengerType = scanner.nextInt();
                    scanner.nextLine();

                    //Checks the input and confirms which queue the passenger is added to
                    switch (passengerType) {
                        case 1:
                            priorityQueue.add(passengerName);
                            System.out.println(passengerName + " added to the priority boarding queue.");
                            break;
                        case 2:
                            regularQueue.add(passengerName);
                            System.out.println(passengerName + " added to the regular boarding queue.");
                            break;
                        default:
                            System.out.println("Invalid passenger type. Please enter a valid option.");
                            break;
                    }
                    break;

                case 2:
                    /*Checks if queue is empty or not, and then disembarks people from the plane
                    normal passengers are disembarked first so that people with priority boarding can then get assistance
                    easier after plane is more empty which normally happens*/
                        while(!regularQueue.isEmpty()) {
                            String disembarkingPassenger = regularQueue.poll();
                            System.out.println(disembarkingPassenger + " disembarked from the regular queue.");
                        }
                        while(!priorityQueue.isEmpty()){
                        String disembarkingPassenger = priorityQueue.poll();
                        System.out.println(disembarkingPassenger + " disembarked from the priority queue.");
                        }
                        System.out.println("Boarding queues are empty. No passengers left to disembark.");
                    break;

                    //Displays the queue
                case 3:
                    if (!priorityQueue.isEmpty()) {
                        System.out.println("Priority Boarding Queue: " + priorityQueue);
                    } else {
                        System.out.println("Priority boarding queue is empty.");
                    }

                    if (!regularQueue.isEmpty()) {
                        System.out.println("Regular Boarding Queue: " + regularQueue);
                    } else {
                        System.out.println("Regular boarding queue is empty.");
                    }
                    break;
                //Exits the application
                case 4:
                    System.out.println("Exiting the application.");
                    myFooter(5);
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    //Footer and header methods
    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q1\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Plane boarding and disembarking!\n" +
                "=======================================================");
    }
    //Footer function
    public static void myFooter(int lab){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q5 is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
}