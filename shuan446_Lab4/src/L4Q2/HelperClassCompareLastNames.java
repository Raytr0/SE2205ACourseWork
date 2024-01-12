package L4Q2;

import java.util.Comparator;

public class HelperClassCompareLastNames implements Comparator<Student> {
    //Overrides the compare methods and compares the last names
    @Override
    public int compare(Student last1, Student last2) {
        return last1.getLastName().compareTo(last2.getLastName());
    }
}
