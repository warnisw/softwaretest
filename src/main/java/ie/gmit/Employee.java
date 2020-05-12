package ie.gmit;

public class Employee extends Person {
    float salary;

    public Employee(String title, String name, String pps, String type, String address, long phone, int age, float salary) {
        super(title, name, pps, type, address, phone, age);
        setSalary(salary);
    }

    public void setSalary(float salary) {
        if(salary >= 0)
            this.salary = salary;
        else
            throw new IllegalArgumentException("Salary must be a positive float");
    }

    public float getSalary() { return salary; }
}
