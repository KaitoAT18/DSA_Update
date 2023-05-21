package LinkedList.Exercise14;

import java.util.Comparator;

public class SortByAccountNumber implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getAccountNumber().compareTo(o2.getAccountNumber());
    }
}
