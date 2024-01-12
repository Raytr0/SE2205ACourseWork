package L4Q1;

public class Driver_DoublyLinkedList {
    public static void main(String[] args){
        myHeader(4,1);
        DoublyLinkedList<MyStudent> ryanList = new DoublyLinkedList<MyStudent>();

        //Declares the information
        MyStudent s1 = new MyStudent("Harry", 67.35);
        MyStudent s2 = new MyStudent("Luna", 87.5);
        MyStudent s3 = new MyStudent("Vincent", 60.5);
        MyStudent s4 = new MyStudent("Hermonie", 89.2);
        MyStudent s0 = new MyStudent();
        //Adds declared info into nodes
        ryanList.addLast(s0);
        ryanList.addLast(s1);
        ryanList.addLast(s2);
        ryanList.addLast(s3);
        //Displays the current content
        System.out.println("Adding 4 students to the list.");
        System.out.println("The list Content:");
        System.out.println(ryanList);
        //
        DoublyLinkedList.Node<MyStudent> nodeS2 = ryanList.findNode(s2);
        DoublyLinkedList.Node<MyStudent> nodeS3 = ryanList.findNode(s3);

        //Uses addBetween method in DoublyLinkedList and displays the list
        ryanList.addBetween(s4,nodeS2,nodeS3);
        System.out.printf("Adding %s to the list in between %s and %s.....\n",s4.getFirstName(),s3.getFirstName(),s2.getFirstName());
        System.out.println("The list Content:");
        System.out.println(ryanList);
        myFooter(4,1);
    }
    //Header function
    public static void myHeader(int labE_number, int q_number){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + labE_number + "-Q" + q_number + "\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Understanding Doubly Linked Lists and Nodes!\n" +
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
