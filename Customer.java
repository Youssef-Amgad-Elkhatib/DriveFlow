public class Customer {
    private String customerID;
    private String name;
    private String phone;
    private String email;

    public Customer(String customerID, String name, String phone, String email) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerID() { return customerID; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setCustomerID(String customerID) { this.customerID = customerID; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    public void displayCustomerDetails(){
        System.out.println("Customer Details: ");
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}
