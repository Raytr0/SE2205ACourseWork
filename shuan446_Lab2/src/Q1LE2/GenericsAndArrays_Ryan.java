package Q1LE2;

import com.sun.net.httpserver.Headers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericsAndArrays_Ryan {
    public static Scanner input = new Scanner(System.in);//New scanner input
    public static void main(String[] args){
        myHeader(2);
        //New arraylists
        ArrayList<Integer> years = new ArrayList(Arrays.asList(2,3,4,3,2,2));
        ArrayList<String> names = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));
        Pair<Integer, String>[] combo = new Pair[names.size()];
        //Fills up the array with the given arraylists
        for (int i = 0; i < names.size(); i++) {
            combo[i] = new Pair<>(years.get(i), names.get(i));
        }
        System.out.println("This program prints the names of the student leaders from year 2, 3 and 4.\n" +
                "To see the list of the students from a specific year enter an integer between 2 and 4 when\n" +
                "prompted.");
        //Prompts the user to enter a year and displays the information
        while(true) {
            int n;
            while (true) {
                //Asks user for which year they want to view and checks for error in user input
                try {
                    System.out.print("Enter Academic Year (2, 3 or 4): ");
                    n = input.nextInt();
                    while (n<2 || n>4) {
                        System.out.print("Incorrect input! Enter Academic Year (2, 3 or 4): ");
                        n = input.nextInt();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Incorrect input! ");
                    input.nextLine();
                }
            }
            //Gets the information of the students
            int numOfStudent = 0;
            ArrayList<String> studentInfo = new ArrayList<>();
            for (Pair<Integer, String> pair : combo) {
                if (pair.getKey() == n) {
                    studentInfo.add(pair.getValue());
                    numOfStudent++;
                }
            }
            //Prints out the information
            System.out.printf("Found %d leader(s) from year %d.\n", numOfStudent, n);
            System.out.println("Here is the list:");
            String str = "[";
            for (String s : studentInfo) {
                str = str + s + ", ";
            }
            str = str.substring(0, str.length()-2);
            System.out.println(str + "]");
            //Ends the program when user inputs anything other than y
            System.out.print("Do you wish to continue? (Press y to continue or any other key to terminate): ");
            input.nextLine();
            String ans = input.nextLine();
            if(!ans.equals("y")){
                break;
            }
        }
        myFooter(2);
    }
    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q1\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Working with generics and arrays!\n" +
                "=======================================================");
    }
    public static void myFooter(int lab){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q1 is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
}
