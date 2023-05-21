package LinkedList.Exercise14;

import java.util.Comparator;

public class SortByCardNumber implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getCardNumber().compareTo(o2.getCardNumber());
    }
}
