package ie.gmit;

import java.math.BigDecimal;

public class Customer extends Person {
    private double balance;


    public Customer(String title, String name, String address, long phone, double balance) {
        super(title, name, address, phone);
        setBalance(balance);

    }
    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        Double foo = balance * 100;
        foo = foo - foo.intValue();
        if (foo.compareTo(0D) == 0) {
            this.balance = balance;
        }
        else
                throw new IllegalArgumentException("Balance must be in decimal(0.00) format");

    }
}
