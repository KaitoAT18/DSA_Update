package LinkedList.Exercise14;

import java.util.Comparator;

public class SortByReleaseDate implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        return Long.compare(o1.getReleaseDate().getTime(), o2.getReleaseDate().getTime());
    }
}
