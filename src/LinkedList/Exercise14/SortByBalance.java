package LinkedList.Exercise14;

import java.util.Comparator;

public class SortByBalance implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        int comparedBalance = Double.compare(o1.getBalance(), o2.getBalance());
        if (comparedBalance != 0) {
            return comparedBalance;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
