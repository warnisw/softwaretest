package ie.gmit;

public class Manager extends Employee {
    double annualSalary;

    public Manager(String title, String name, String pps, String type, String address, long phone, int age, double salary, double annualSalary) {
        super(title, name, pps, type, address, phone, age, salary);
        setAnnualSalary(annualSalary);
    }


    public void setAnnualSalary(double annualSalary) {
        Double foo = annualSalary * 100;
        foo = foo - foo.intValue();
        if (foo.compareTo(0D) == 0) {
            this.annualSalary = annualSalary;
        }
        else
            throw new IllegalArgumentException("Annual Salary must be in decimal(0.00) format");
    }

    public double getAnnualSalary() { return annualSalary; }
}
