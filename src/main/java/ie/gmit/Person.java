
package ie.gmit;
public class Person {
    private String title = "";
    private String name = "";
    private String address = "";
    private String email = "";
    private long phone = 0;

    public Person(String title, String name, String address, String email, long phone) {
        setTitle(title);
        setName(name);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
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

    public void setEmail(String email) {
        if(email.contains("@") && email.length() > 3 )
            this.email = email;
        else
            throw new IllegalArgumentException("Invalid Email Entry, make sure to include the @ symbol");

    }

    public String getEmail() { return email; }

    public String getTitle() { return title; }

    public String getName() { return name; }

    public String getAddress() { return address; }

    public long getPhone() { return phone; }

    public static void main(String[] args){
        System.out.println("Test main class for report");
    }

}