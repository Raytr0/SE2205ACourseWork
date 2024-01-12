package L7Q2;
import L7Q1.RyanValueEntry;

import java.util.Arrays;

import static L7Q1.RyanDemoHashingWithLinearAddressing.*;
public class RyanDemoHashingWithAllOpenAddressingTechniques {
    public static void main(String[] args){
        myHeader(7, 2);

        //Takes user input on load and how many items
        System.out.print("Let's demonstrate our understanding on all the open addressing techniques...\n" +
                "How many data items: ");
        items = input.nextInt();

        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble();

        //Calculates the size of the array
        int maxItems = (int)(items/lf);
        tableCapacity = checkPrime(maxItems);

        System.out.printf("The minimum required table capacity would be: %d\n", tableCapacity);

        //creating array and instatiating it
        hashTable = new RyanValueEntry[tableCapacity];
        for(int i  = 0; i < tableCapacity; i++){
            hashTable[i] = new RyanValueEntry();
        }
        System.out.printf("\nAdding data - linear probing resolves collision\n" +
                "The Current Hash-Table: ");
        Integer[] numList = {7,14,-21, -28, 35};

        printArray(numList);
        //linear probing
        for(int i = 0; i < numList.length; i++){
            addValueLinearProbe(numList[i]);
        }
        printHashTable();

        emptyHashTable();
        //quadratic probing
        System.out.printf("\nAdding data - quadratic probing resolves collision\n");
        for(int i = 0; i < numList.length; i++){
            addValueQuadraticProbe(numList[i]);
        }
        //Checks if lf is over 0.5, still runs but will show a half working probe
        if (lf > 0.5) System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
        System.out.println( "The Current Hash-Table:");

        printHashTable();
        //double hashing
        emptyHashTable();
        int nextPrime = thePrimeNumberForSecondHashFunction(tableCapacity);
        System.out.printf("\nAdding data - double-hashing resolves collision\n" +
                "The q value for double hashing is: %d\n", nextPrime);
        for(int i = 0; i < numList.length; i++){
            addValueDoubleHashing(numList[i]);
        }

        printHashTable();
        System.out.println();
       myFooter(7,2);

    }

    //creating methods for adding quadratic
    public static void addValueQuadraticProbe(Integer key) {
        //So this works for negatives
        int hash = ((key % tableCapacity) + tableCapacity) % tableCapacity;
        int k;
        //Cuz quadratic is k + i^2
        for (int i = 0; i < tableCapacity; i++) {
            k = (hash + i * i) % tableCapacity;

            //Saves it if location is not null or Available
            if (key != -1 && key != -111 && (hashTable[k].getKey() == -1 || hashTable[k].getKey() == -111)) {
                hashTable[k].setKey(key);
                return;
            }
        }
    }

    static void addValueDoubleHashing(Integer key){

        //Gets 2 primes
        int hashIndex = key % hashTable.length;
        if (hashIndex < 0) {
            hashIndex += hashTable.length;
        }

        if (hashTable[hashIndex].getKey() == -1) {
            hashTable[hashIndex].setKey(key);

            size++;
            return;

        }
        //second prime
        int nextPrime = thePrimeNumberForSecondHashFunction(tableCapacity);
        int secondHash = nextPrime - (key % nextPrime);

        int count = 0;
        boolean isFirst = true;
        int firstAvailible = -1;

        //resolving collisions here
        //Checks for available and null positions
        while(true){
            int hashCheck = (hashIndex + (count * secondHash)) % tableCapacity;
            if(hashCheck < 0){
                hashCheck += tableCapacity;
            }
            if (hashTable[hashCheck].getKey() == -111 && isFirst) {
                firstAvailible = hashCheck;
                count++;
                isFirst = false;

            }else if (hashTable[hashCheck].getKey() == -1) {
                if(!isFirst) {
                    hashTable[firstAvailible].setKey(key);
                    size++;
                    return;
                }else{
                    hashTable[hashCheck].setKey(key);
                    size++;
                    return;
                }
            }else {
                count++;
            }
        }
    }

    //finding smaller prime
    //Basically the same as the previous find prime but reverse since we need to find the one before the first one
    public static int thePrimeNumberForSecondHashFunction(int n) {

        // All prime numbers are odd except two
        if (n % 2 != 0)
            n -= 2;
        else
            n--;

        int i, j;
        for (i = n; i >= 2; i -= 2) {
            if (i % 2 == 0)
                continue;
            for (j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0)
                    break;
            }
            if (j > Math.sqrt(i))
                return i;
        }

        // It will only be executed when n is 3
        return 2;
    }

    //Resets the hash table
    public static void emptyHashTable(){
        for(int i = 0; i < hashTable.length; i++){
            size = 0;
            hashTable[i].setKey(-1);
        }
    }
    //print array method
    public static void printArray(Integer[] array){
        String str = "[";
        for(Integer current  : array){
            str += current + ", ";

        }
        str = str.substring(0,str.length()-2);
        str += "]";
        System.out.println(str);
    }
}
