package ie.gmit;

public class Employee extends Person {
    double salary;

    public Employee(String title, String name, String pps, String type, String address, long phone, int age, double salary) {
        super(title, name, pps, type, address, phone, age);
        setSalary(salary);
    }

    public void setSalary(double salary) {
        Double foo = salary * 100;
        foo = foo - foo.intValue();
        if (foo.compareTo(0D) == 0) {
            this.salary = salary;
        }
        else
            throw new IllegalArgumentException("Salary must be in decimal(0.00) format");
    }

    public double getSalary() { return salary; }
}
