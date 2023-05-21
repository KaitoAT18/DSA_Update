package LinkedList.Exercise15;

import java.util.Comparator;

public class SortingByGpa implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getGpa(), o2.getGpa());
    }
}
