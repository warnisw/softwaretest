
package ie.gmit;
public class Person {
    private String title = "";
    private String name = "";
    private String pps = "";
    private String type = "";
    private String address = "";
    private long phone = 0;
    private int age = 0;


    public Person(String title, String name, String pps, String type, String address, long phone, int age) {
        setTitle(title);
        setName(name);
        setType(type);
        setAddress(address);
        setPps(pps);
        setPhone(phone);
        setAge(age);
    }


    public void setTitle(String title) {
        if (title.equals("Mr")  || title.equals("Mrs") || title.equals("Ms"))
            this.title = title;
        else
            throw new IllegalArgumentException("Invalid title provided");
    }

    public void setName(String name) {
        if((name.length() < 3) || (name.length() >25)  )
            throw new IllegalArgumentException("Name must contain 3 - 25 characters");
        else
            this.name = name;
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

    public void setAddress(String address) {
        if(address.length() < 0)
            throw new IllegalArgumentException("Invalid Address Entry");
        else
        this.address = address;
    }

    public void setPhone(long phone) {
        if(String.valueOf(phone).length() != 9)
            throw new IllegalArgumentException("Phone number must be 9 digits");
        else
            this.phone = phone;
    }

    public void setAge(int age) {
        if(age >= 16)
            this.age = age;
        else
            throw new IllegalArgumentException("Employee age must be over 16 to work in the company");

    }

    public String getTitle() { return title; }

    public String getName() { return name; }

    public String getType() { return type; }

    public String getAddress() { return address; }

    public String getPps() { return pps; }

    public long getPhone() { return phone; }

    public int getAge() { return age; }

    public static void main(String[] args){
        System.out.println("Test main class for report");
    }

}