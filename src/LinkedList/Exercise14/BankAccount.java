package LinkedList.Exercise14;

import java.util.Date;

public class BankAccount {
    private String name;
    private String cardNumber;
    private String accountNumber;
    private String cardType;
    private String issuingBank;
    private Date releaseDate;
    private Date expirationDate;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String name, String cardNumber, String accountNumber, String cardType, String issuingBank, Date releaseDate, Date expirationDate, double balance) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.cardType = cardType;
        this.issuingBank = issuingBank;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", issuingBank='" + issuingBank + '\'' +
                ", releaseDate=" + releaseDate +
                ", expirationDate=" + expirationDate +
                ", balance=" + balance +
                '}';
    }
}
