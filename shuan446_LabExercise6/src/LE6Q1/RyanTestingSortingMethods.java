package LE6Q1;

import java.util.*;

public class RyanTestingSortingMethods {
    public static void main(String[] args){
        myHeader(6);

        int sz = 50000;
        Integer[] testArray = new Integer[sz];
        Integer[] backupArray = new Integer[testArray.length];

        //Populates array ranging from 13-93
        for(int i = 0; i<testArray.length; i++){
            testArray[i] = (int)(13+81*Math.random());
        }

        System.arraycopy(testArray,0,backupArray,0,testArray.length);
        List<Integer> listArray= Arrays.asList(testArray);
        List<Integer> listBackup= Arrays.asList(backupArray);

        long startCol= System.nanoTime();
        Collections.sort(listArray);
        long endCol = System.nanoTime();
        System.out.println("Testing execution time of different sorting methods for sorting " + sz + " random numbers: ");
        //System.out.println("The unsorted list: " + listBackup);
        System.out.printf("Collections' Sorting Time: %.2f milliseconds\n", (endCol-startCol)*1e-6);
        //System.out.println("The sorted list using Collections' sort method: " + listArray);
        //System.out.println();

        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Selection-Sort",listBackup,listArray,selectionSort(testArray)*1e-6);

        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Bubble-Sort",listBackup,listArray,bubbleSort(testArray)*1e-6);

        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Insertion-Sort",listBackup,listArray,insertionSort(testArray)*1e-6);

        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Merge-Sort",listBackup,listArray,mergeSort(testArray)*1e-6);

        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Quick-Sort",listBackup,listArray,quickSort(testArray,0,testArray.length-1)*1e-6);

        System.arraycopy(backupArray,0,testArray,0,testArray.length);
        printInfo("Bucket-Sort",listBackup,listArray,bucketSort(testArray,0,testArray.length-1,2)*1e-6);//max digit is set to two because max number is 93

        myFooter(6);
    }
    public static void printInfo(String methodName, List<Integer> unsorted, List<Integer> sorted, double time) {
        //System.out.println("The unsorted list: " + unsorted.toString());
        System.out.printf("My %s Time: %.2f milliseconds\n", methodName, time);
        //System.out.printf("The sorted list using %s method: " + sorted+"\n",methodName.toLowerCase());
        //System.out.println();
    }

    public static <T extends Comparable <? super T>>long selectionSort (T [] a){
        long startTime = System.nanoTime();
        for(int i=0; i<a.length;i++){
            int k = i; //storing index of value
            for(int j = i+1;j<a.length;j++){ //going through the rest of the array after initial value
                if (a[j].compareTo(a[k])==-1){ //checking if there's a smaller value in array
                    k = j; //store index of smaller value
                }
            }
            T temp = a[i];
            a[i] = a[k];
            a[k] = temp;//assigning correct value to sort list before moving to next value in outer index
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static < T extends Comparable <? super T >> long bubbleSort(T[] a){
        long startTime = System.nanoTime();
        //outer index to go through individual elements
        for (int i = 1; i < a.length ; i++) {
            //inner index to compare element before outer index
            for (int j = 0; j < a.length - i; j++) {
                //if smaller let switch position
                if (a[j].compareTo(a[j + 1])>0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] a){
        long startTime = System.nanoTime();
        for(int i = 1; i<a.length; i++){
            T key = a[i];
            int j = i-1; //setting value for inner index to compare value to rest of array
            while(j>=0 && a[j].compareTo(key)==1){
                a[j+1]=a[j];
                j--;
            }//repeat comparison until the value is at the beginning of the list or in correct location
            a[j+1]=key;
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long startTime = System.nanoTime();
        int n = S.length;
        if (n < 2){
            long endTime = System.nanoTime();
            return endTime-startTime; // array is trivially sorted
        }
        // divide
        int mid = n/2;
        T[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        T[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1); // sort copy of first half
        mergeSort(S2); // sort copy of second half

        // merge sorted halves back into original
        int i = 0, j = 0, k = 0;
        while (i < S1.length && j < S2.length) {
            if (S1[i].compareTo(S2[j]) <= 0) {
                S[k++] = S1[i++];
            } else {
                S[k++] = S2[j++];
            }
        }

        // Copy the remaining elements of S1 and S2, if any
        while (i < S1.length) {
            S[k++] = S1[i++];
        }

        while (j < S2.length) {
            S[k++] = S2[j++];
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] S, int a, int b){
        long startTime = System.nanoTime();
        if(a>=b){
            long endTime = System.nanoTime();
            return endTime-startTime;
        }
        T pivot = S[b]; //pivot moved to the last element
        int l = a; //left most counter will scan rightwards from first element
        int r = b-1; //right most counter which will count from the 2nd last element
        while(l<=r){
            while(l<=r && S[l].compareTo(pivot)<=0){
                l++;
            }
            while(l<=r && S[r].compareTo(pivot)>=0){
                r--;
            }
            if (l < r){
                T temp = S[l];
                S[l] = S[r];
                S[r] = temp;
                l++;
                r--;
            }
        }

        T temp = S[l];
        S[l] = S[b];
        S[b] = temp;

        quickSort(S,a,l-1);
        quickSort(S,l+1,b);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long startTime = System.nanoTime();
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            for (int index = first; index <= last; index++) {
                int number = a[index];
                int digit = 0;
                for (int k = 0; k <= i; k++) {
                    digit = number % 10;
                    number = number / 10;
                }
                bucket[digit].add(a[index]);
            }
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    public static void myHeader(int lab){
        System.out.println("=======================================================\n" +
                "Lab Exercise " + lab + "-Q1\n" +
                "Prepared By: Ryan Huang\n" +
                "Student Number: 251282167\n" +
                "Goal of this Exercise: Understanding Sorting Algos!\n" +
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
