package ie.gmit;

public class Employee extends Person {
    double salary;
    private String pps = "";
    private String type = "";
    private int age = 0;

    public Employee(String title, String name, String pps, String type, String address, String email, long phone, int age, double salary) {
        super(title, name, address, email, phone);
        setSalary(salary);
        setAddress(address);
        setType(type);
        setPps(pps);
        setAge(age);
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

    public void setPps (String pps) {
        if(pps.length() != 8)
            throw new IllegalArgumentException("PPS must contain 8 characters");
        else
            this.pps = pps;
    }

    public void setType(String type) {
        if(type.equals("Full-time") || type.equals("Part-time") || type.equals("Contract"))
            this.type = type;
        else
            throw new IllegalArgumentException("Must contain employment type");
    }

    public void setAge(int age) {
        if(age >= 16)
            this.age = age;
        else
            throw new IllegalArgumentException("Employee age must be over 16 to work in the company");

    }

    public double getSalary() { return salary; }

    public int getAge() { return age; }

    public String getPps() { return pps; }

    public String getType() { return type; }
}
