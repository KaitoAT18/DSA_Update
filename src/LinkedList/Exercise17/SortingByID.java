package LinkedList.Exercise17;

import java.util.Comparator;

public class SortingByID implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId().toLowerCase().compareTo(o2.getId().toLowerCase());
    }
}
