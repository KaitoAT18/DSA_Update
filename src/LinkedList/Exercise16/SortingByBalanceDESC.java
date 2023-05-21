package LinkedList.Exercise16;

import java.util.Comparator;


public class SortingByBalanceDESC implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount o1, BankAccount o2) {
        int diffBalance = Long.compare(o2.getBalance(), o1.getBalance());
        if (diffBalance != 0) {
            return diffBalance;
        } else {
            String owner1Name = getName(o1.getOwner());
            String owner2Name = getName(o2.getOwner());
            return owner1Name.compareTo(owner2Name);
        }
    }

    private String getName(String owner) {
        String name;
        int startNameIndex = owner.lastIndexOf(" ");
        if (startNameIndex == -1) {
            name = owner;
        } else {
            name = owner.substring(startNameIndex + 1);
        }
        return name;
    }
}
