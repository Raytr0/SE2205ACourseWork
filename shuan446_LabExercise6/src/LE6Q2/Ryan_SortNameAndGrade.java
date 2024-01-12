package LE6Q2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Ryan_SortNameAndGrade {

    public static void main (String []args) {
        //Three arrays with 8 first names, 8 last names and 8 randomly generated grades between 60 and 85 inclusive have been created below for your use
        myHeader(6);
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 +
                Math.random() * 26)};

        Vector<StudentGrade> sg = new Vector<>();
        for (int i = 0; i < fnArray.length; i++) {
            sg.add(new StudentGrade(fnArray[i], lnArray[i], grd[i]));
        }

        System.out.println("Unsorted array:");
        printArray(sg);
        System.out.println();

        Collections.sort(sg);
        System.out.println("Sorted by Grades:");
        printArray(sg);
        System.out.println();

        StudentGrade[] studentArray = new StudentGrade[fnArray.length];
        sg.copyInto(studentArray);
        sort(studentArray, 1);
        System.out.println("Sorted by First Names: ");
        printArray(studentArray);

        System.out.println();
        sort(studentArray, 2);
        System.out.println("Sorted by Last Names: ");
        printArray(studentArray);

        myFooter(6);
    }

    public static void printArray(Vector<StudentGrade> array) {
        for (StudentGrade student : array) {
            System.out.println(student);
        }
    }

    public static void printArray(StudentGrade[] array) {
        for (StudentGrade student : array) {
            System.out.println(student);
        }
    }

    public static void sort(StudentGrade[] array, int key) {
        // Implement your sorting logic based on the given key
        // For example, you can use stable sorting, insertion sort, or merge sort
        // Update the array accordingly
        // Ensure to modify compareTo method in StudentGrade accordingly
        if (key == 1) {
            Arrays.sort(array, Comparator.comparing(StudentGrade::getFirstName));
        } else if (key == 2) {
            Arrays.sort(array, Comparator.comparing(StudentGrade::getLastName));
        }
    }

    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q2\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Understanding Sorting Algos!\n" +
                "=======================================================");
    }
    //Footer function
    public static void myFooter(int lab){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q2 is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
}





