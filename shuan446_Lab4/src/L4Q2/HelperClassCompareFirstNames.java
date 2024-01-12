package L4Q2;

import java.util.Comparator;

public class HelperClassCompareFirstNames implements Comparator<Student> {
    //Overrides the compare method and compares the first names
    @Override
    public int compare(Student first1, Student first2){
        return first1.getFirstName().compareTo(first2.getFirstName());
    }
}
