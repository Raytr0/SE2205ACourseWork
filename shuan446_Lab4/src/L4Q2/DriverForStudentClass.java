package L4Q2;

import java.util.ArrayList;
import java.util.Collections;

public class DriverForStudentClass {
    public static void main(String[] args){
        Student myInfo = new Student();
        myHeader(myInfo,4,2);
        //Creates new ArrayList and adds elements to it
        ArrayList<Student> nameList = new ArrayList<>();
        nameList.add(new Student());
        nameList.add(new Student("Harry","Potter", 75.50));
        nameList.add(new Student("Ronald","Weasley",86.00));
        nameList.add(new Student("Hermione","Granger",91.70));
        nameList.add(new Student("Parvati","Patil",93.75));
        System.out.println("The Score Card: ");
        //Prints out the list
        for(Student index: nameList){
            System.out.println(index);
        }
        System.out.println();

        //Sorts the list by descending order and prints it out
        System.out.println("The sorted list in terms of score in descending order....");
        Collections.sort(nameList, Collections.reverseOrder());
        for(Student index: nameList){
            System.out.println(index);
        }
        System.out.println();
        //Sorts the list by last names and prints it out
        System.out.println("The sorted list in terms of Last Names....");
        Collections.sort(nameList, new HelperClassCompareLastNames());
        for(Student index: nameList){
            System.out.println(index);
        }
        System.out.println();
        //Sorts the list by first names and prints it out
        System.out.println("The sorted list in terms of First Names....");
        Collections.sort(nameList, new HelperClassCompareFirstNames());
        for(Student index: nameList){
            System.out.println(index);
        }
        System.out.println();
        myFooter(4,2);
    }
    public static void myHeader(Student myinfo, int labE_number, int q_number){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + labE_number + "-Q" + q_number + "\n" +
                "Prepared By: " + myinfo.getFirstName() +" "+ myinfo.getLastName() + "\n"+
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Understanding Comparator, Collections, and Comparable!\n" +
                "=======================================================");
    }
    //Footer function
    public static void myFooter(int labE_number, int q_number){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + labE_number +   "-Q" + q_number + " is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
}
