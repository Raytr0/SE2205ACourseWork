package LA3Q1;
import java.util.StringJoiner;

public class RyanArray {
    private Pair<?,?>[] testArray;
    //Initializes the array with size 0
    public RyanArray(){
        this.testArray = new Pair<?,?>[0];
    }
    //Gets array size
    public int getSize(){
        return testArray.length;
    }
    //Removes last element and returns the array
    public Pair<?,?> removeFromLastIndex(){
        if (testArray.length == 0) {
            throw new IllegalStateException("You have an empty stack: []");
        }
        Pair<?,?> delete = testArray[testArray.length - 1];
        Pair<?,?>[] newArray = new Pair<?,?>[testArray.length - 1];
        System.arraycopy(testArray, 0, newArray, 0, newArray.length);
        testArray = newArray;
        newArray = null;
        return delete;
    }
    //Removes first element and returns the array
    public Pair<?,?> removeFromFirstIndex(){
        if (testArray.length == 0) {
            throw new IllegalStateException("You have an empty queue: []");
        }
        Pair<?,?> delete = testArray[0];
        Pair<?,?>[] newArray = new Pair[testArray.length-1];
        System.arraycopy(testArray, 1, newArray, 0, newArray.length);
        testArray = newArray;
        newArray = null;
        return delete;
    }
    //Overrides toString method to display array in text
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("", "[", "]");
        for (Pair<?,?> item: testArray) {
            joiner.add(item.toString());
        }
        return joiner.toString();
    }
    //Adds element to the last position
    public void addAtLastIndex(Pair<?,?> push){
        Pair<?,?>[] newArray = new Pair<?,?>[testArray.length+1];
        System.arraycopy(testArray, 0, newArray, 0, testArray.length);
        newArray[testArray.length] = push;
        testArray = newArray;
        newArray = null;
    }
}
