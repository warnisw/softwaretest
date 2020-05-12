package ie.gmit;

public class Manager extends Employee {
    float annualSalary;

    public Manager(String title, String name, String pps, String type, String address, long phone, int age, float salary, float annualSalary) {
        super(title, name, pps, type, address, phone, age, salary);
        setAnnualSalary(annualSalary);
    }


    public void setAnnualSalary(float annualSalary) {
        if(annualSalary >= 0)
            this.annualSalary = annualSalary;
        else
            throw new IllegalArgumentException("Annual Salary must be a positive float");
    }

    public float getAnnualSalary() { return annualSalary; }
}
