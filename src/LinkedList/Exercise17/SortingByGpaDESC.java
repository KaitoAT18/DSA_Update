package LinkedList.Exercise17;

import java.util.Comparator;

public class SortingByGpaDESC implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int gpaCompared = Float.compare(o2.getGpa(), o1.getGpa());
        if (gpaCompared == 0) {
            int nameCompared = o1.getFirstName().toLowerCase().compareTo(o2.getFirstName().toLowerCase());
            if (nameCompared == 0) {
                return o1.getLastName().toLowerCase().compareTo(o2.getLastName().toLowerCase());
            }
        }
        return gpaCompared;
    }
}
