package LinkedList;

import java.util.Objects;

public class Bank implements Comparable<Bank> {
    private String fullName;
    private String bankCardNumber;
    private String accountNumber;
    private String bankName;
    private double balance;

    public Bank() {
    }

    public Bank(String fullName, String bankCardNumber, String accountNumber, String bankName, double balance) {
        this.fullName = fullName;
        this.bankCardNumber = bankCardNumber;
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }

    public Bank(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(accountNumber, bank.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "fullName='" + fullName + '\'' +
                ", bankCardNumber='" + bankCardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(Bank o) {
        return 0;
    }
}
