package ie.gmit;

import java.math.BigDecimal;

public class Customer extends Person {
    private double balance;
    private double order;
    private double credit;


    public Customer(String title, String name, String address, String email, long phone, double balance, double order, double credit) {
        super(title, name, address, email, phone);
        setBalance(balance);
        setCredit(credit);
        setOrder(order);
        processOrder(credit, balance,order);

    }
    public double getBalance() { return balance;}
    public double getOrder() {return order;}
    public double getCredit() {return credit; }




    public void setBalance(double balance) {
        Double foo = balance * 100;
        foo = foo - foo.intValue();
        if (foo.compareTo(0D) == 0) {
            this.balance = balance;
        }
        else
                throw new IllegalArgumentException("Balance must be in decimal(0.00) format");

    }
    public void setOrder(double order) {
        Double foo = order * 100;
        foo = foo - foo.intValue();
        if (foo.compareTo(0D) == 0) {
            this.order = order;
        }
        else
            throw new IllegalArgumentException("Order value must be in decimal(0.00) format");

    }
    public void setCredit(double credit) {
        Double foo = credit * 100;
        foo = foo - foo.intValue();
        if (foo.compareTo(0D) == 0) {
            this.credit = credit;
        }
        else
            throw new IllegalArgumentException("Credit value must be in decimal(0.00) format");

    }
    public void processOrder(double credit, double balance, double order) {
        if (credit < order+balance ) {
            throw new IllegalArgumentException("Insuficient funds");
        }
        else
            this.balance  = balance+order;

    }

}
