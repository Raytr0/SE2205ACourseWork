package L7Q1;

import L7Q1.RyanValueEntry;

import java.util.Scanner;

public class RyanDemoHashingWithLinearAddressing {
    public static int items;
    public static Scanner input = new Scanner(System.in);
    public static double lf;
    public static int size;
    public static int tableCapacity;
    public static RyanValueEntry[] hashTable;
    public static RyanValueEntry[] workingHashTable;

    public static void main(String[] args){
        myHeader(7, 1);

        //Gets user input on initial size and load factor
        System.out.print("Let's decide on the initial table capacity based on the load factor and dataset size\n" +
                "How many data items: ");
        items = input.nextInt();

        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();

        //calculates size based on previous inputs
        int maxItems = (int)(items/lf);
        tableCapacity = checkPrime(maxItems);

        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);


        hashTable = new RyanValueEntry[tableCapacity];
        for(int i  = 0; i < tableCapacity; i++){
            hashTable[i] = new RyanValueEntry();
        }

        //adds items to linear probe
        for(int i = 0; i < items; i++){
            System.out.printf("Enter item %d: ", i + 1);
            int newItem = input.nextInt();

            addValueLinearProbe(newItem);
        }
        System.out.print("The Current Hash-Table: ");
        printHashTable();
        System.out.println();
        System.out.println("Let’s remove two values from the table and then add one…….\n");
        //Removes given input from the hashTable if found
        for(int i = 0; i < 2; i++){
            System.out.print("Enter a value you want to remove: ");
            int removedItem = input.nextInt();
            removeValueLinearProbe(removedItem);
            System.out.print("The Current Hash-Table: ");
            printHashTable();
        }

        //Adds given value to hashTable
        System.out.print("Enter a value to add to the table: ");
        int newVal = input.nextInt();
        addValueLinearProbe(newVal);
        System.out.print("The Current Hash-Table: ");
        printHashTable();

        //Rehashes the table
        System.out.println();
        rehashingWithLinearProbe();
        System.out.printf("Rehashing the table...\n" + "The rehashed table capacity is: %d\n", tableCapacity);
        printHashTable();
        myFooter(7,1);
    }
    public static void addValueLinearProbe(Integer key) {
        //get hashcode and a comparison variable
        //Has to do this to include negative values
        int hashCode = ((key % tableCapacity) + tableCapacity) % tableCapacity;
        int i = hashCode;

        //if the key is not null or available then set the hashTable position to the provided key
        //Loops until condition is satisified
        do {
            if (key != -1 && key != -111 && (hashTable[i].getKey() == -1 || hashTable[i].getKey() == -111)) {
                hashTable[i].setKey(key);
                return;
            }
            i = (i + 1) % tableCapacity;
        } while (i != hashCode);
    }
    public static int checkPrime(int n) {
            int m = n / 2;//we just need to check half of the n factors
            for (int i = 3; i <= m; i++) {
                if (n % i == 0) {//if n is not a prime number
                    i = 2; //reset i to 2 so that it is incremented to 3 in the forheader
                    //System.out.printf("i = %d\n",i);
                    n++;//next n value
                    m = n / 2;//we just need to check half of the n factors
                }
            }
            return n;
    }//end of checkPrime()
    public static void rehashingWithLinearProbe(){
        //increase table size, set hashtable reference, creating new hashtable
        tableCapacity = checkPrime(2*tableCapacity);
        workingHashTable = hashTable;
        hashTable = new RyanValueEntry[tableCapacity];
        for(int i = 0; i < hashTable.length; i++){
            hashTable[i] = new RyanValueEntry();
        }

        for(int i = 0; i < workingHashTable.length; i++){
            if(workingHashTable[i].getKey() != -1 && workingHashTable[i].getKey() != -111) {
                addValueLinearProbe(workingHashTable[i].getKey());
            }
        }
    }
    public static void removeValueLinearProbe(Integer key) {
        // Gets modulus as opposed to remainder to hash key
        int hashCode = ((key % tableCapacity) + tableCapacity) % tableCapacity;
        int i = hashCode;

        // Search until key is found or until loops to initial hash index
        do {
            if (hashTable[i].getKey().equals(key)) {
                hashTable[i].setKey(-111);
                System.out.print(key + " is found and removed! ");
                return;
            }
            i = (i + 1) % tableCapacity;
        } while (i != hashCode);
        System.out.print(key + "  is not found! ");
    }
    public static void printHashTable(){
        //Prints out table
        String str = "[";
        for(RyanValueEntry current : hashTable){
            str += current + ", ";
        }
        //deletes 2 last to complete string with ]
        str = str.substring(0,str.length()-2);
        str += "]";
        System.out.println(str);
    }

    //defining header method
    public static void myHeader(int lab, int question){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q"+question+"\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: understanding on all the open addressing techniques!\n" +
                "=======================================================");
    }
    //Footer function
    public static void myFooter(int lab, int question){
        System.out.println("=======================================================\n" +
                "Completion of Lab Exercise " + lab +   "-Q" + question + " is successful!\n" +
                "Signing off - Ryan\n" +
                "=======================================================");
    }
}