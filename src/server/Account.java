package server;

import java.util.List;

public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private double debit;
    private int lock;
    private String cradeNumber;

    public Account(int id, String firstName, String lastName, double debit, int lock, String cradeNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.debit = debit;
        this.lock = lock;
        this.cradeNumber = cradeNumber;
    }

    public Account(){}

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }

    public String getCradeNumber() {
        return cradeNumber;
    }

    public void setCradeNumber(String cradeNumber) {
        this.cradeNumber = cradeNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", debit=" + debit +
                ", lock=" + lock +
                ", cradeNumber='" + cradeNumber + '\'' +
                '}';
    }
}