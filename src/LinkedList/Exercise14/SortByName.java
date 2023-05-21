package LinkedList.Exercise14;

import java.util.Comparator;

public class SortByName implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
