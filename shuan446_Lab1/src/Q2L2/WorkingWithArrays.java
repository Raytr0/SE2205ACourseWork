package Q2L2;

import java.util.Scanner;

public class WorkingWithArrays {
    public static Scanner input = new Scanner(System.in);//new scanner input
    public static void main(String[] args){
        myHeader(1);
        //prompts user to enter array size
        System.out.print("Enter array size: ");
        int arraySize = input.nextInt();
        double[] minMax = new double[arraySize];
        int arrayPos = 0;
        //prompts user to fill in the array
        while(arraySize > arrayPos){
            System.out.print("Enter value "+ (arrayPos+1) +" : ");
            minMax[arrayPos++] = input.nextDouble();
        }
        //calls the method to calculate
        mma5MethodRyan(minMax);
        //calls footer method
        myFooter(1);
    }

    //Header method
    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q2\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Working with arrays and conditional statements!\n" +
                "=======================================================");
    }
    //Footer method
    public static void myFooter(int lab){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q2 is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
    //Calculates which numbers in the array are divisible by 5 and sorts the min, max and avg of those numbers
    public static double[] mma5MethodRyan(double[] div5){
        int div5Times = 0;
        double div5Total = 0;
        double[] summary = new double[4];
        summary[3] = 251282167;
        //checks for min and max divisible by 5 numbers and counts how many there are
        for(int i = 0; i < div5.length; i++) {
            if (div5[i] % 5 == 0) {
                div5Times++;
                div5Total = div5Total + div5[i];
                summary[0] = Math.max(div5[i],summary[0]);
                if((summary[1] == 0)){
                    summary[1] = div5[i];
                }
                else{
                    summary[1] = Math.min(div5[i],summary[1]);
                }
            }
        }
        summary[2] = div5Total/div5Times;
        //checks if there are numbers divisible by 5 in the array
        if(div5Total == 0){
            System.out.println("Here is the result......");
            System.out.println("");
            System.out.println("In the array, there was no number ‘divisible by 5’ and hence the average remains 0.00.");
        }
        else{
            System.out.println("Here is the result......");
            System.out.println("Found "+div5Times+" numbers that are divisible by 5");
            System.out.printf("The max is %.2f.\n", summary[0]);
            System.out.printf("The min is %.2f.\n", summary[1]);
            System.out.printf("The average of the ‘divisible by 5 numbers’ is %.2f.\n", summary[2]);
            System.out.printf("My student number is: %1.0f\n", summary[3]);
        }
        return summary;
    }
}
