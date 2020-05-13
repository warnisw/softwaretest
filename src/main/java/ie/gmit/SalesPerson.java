package ie.gmit;

public class SalesPerson extends Employee {
    float hourRate;
    int hours;

    public SalesPerson(String title, String name, String pps, String type, String address, String email, long phone, int age, float salary, float hourRate, int hours) {
        super(title, name, pps, type, address, email, phone, age, salary);
        setHourRate(hourRate);
        setHours(hours);
    }

    public void setHours(int hours) {
        if(hours >= 0)
            this.hours = hours;
        else
            throw new IllegalArgumentException("Hours must be a positive float");
    }

    public void setHourRate(float hourRate) {
        if(hourRate >= 0)
            this.hourRate = hourRate;
        else
            throw new IllegalArgumentException("Hour Rate must be a positive float");
    }

    public double getSalary() {
        return hourRate * hours * 50; //50 working weeks per year
    }

    public float getHourRate() { return hourRate; }

    public int getHours() { return hours; }

}
