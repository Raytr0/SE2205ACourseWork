package Q1L1;

import java.util.Scanner;

public class TestingExecutionTime {
    public static Scanner input = new Scanner(System.in);//New scanner for input
    public static void main(String[] args){
        myHeader(1);//Header
        //Prompts user to enter an integer and runs a check
        System.out.print("Enter an integer number: ");
        int n = input.nextInt();
        while(n < 0){
            System.out.println("Integer needs to be greater than 0.");
            System.out.println("Enter an integer number: ");
            n = input.nextInt();
        }
        double mainTime = System.nanoTime();//Gets initial time
        //does a factorial calculation in main
        double mainFactorial = 1;
        for (int i = 1; i <= n; i++) {
            mainFactorial *= i;
        }
        //displays the factorial result and runtime
        System.out.printf("Factorial(%d) is %.0e\n", n, mainFactorial);
        System.out.printf("Time taken by Iterative solution inside main: %.2e\n", (System.nanoTime() - mainTime)/100000000);

        //displays the result and runtime of the interative method
        double interTime = System.nanoTime();
        System.out.printf("Factorial(%d) with iterative call is: %.0e\n", n, interativeMethodForFactorial(n));
        System.out.printf("Time taken by Iterative method call: %.2e\n", (System.nanoTime() - interTime)/100000000);

        //displays the result and runtime of the recursive method
        double recurTime = System.nanoTime();
        System.out.printf("Factorial(%d) with recursive call is: %.0e\n", n, recursiveMethodFactorial(n));
        System.out.printf("Time taken by recursive method call: %.2e\n", (System.nanoTime() - recurTime)/100000000);

        myFooter(1);
    }
    //Header method for lab details
    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q1\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Checking the code-execution time!\n" +
                "=======================================================");
    }
    //Footer method closing statement
    public static void myFooter(int lab){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q1 is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
    //interative method for factorial
    public static double interativeMethodForFactorial(int n){
        if(n <= 1){
            return 0;
        }
        double total = 1;
        for(int i = n; i >= 1; i--){
            total *= i;
        }
        return total;
    }
    //recursive method for factorial
    public static double recursiveMethodFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * recursiveMethodFactorial(n - 1);
        }
    }
}
