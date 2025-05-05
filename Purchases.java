public class Purchases {
    private String purchaseID;
    private String purchaseDate;
    private String paymentMethod;
    private Customer customer;
    private Car car;

    public Purchases(String purchaseID, String purchaseDate, String paymentMethod, Customer customer, Car car) {
        this.purchaseID = purchaseID;
        this.purchaseDate = purchaseDate;
        this.paymentMethod = paymentMethod;
        this.customer = customer;
        this.car = car;
    }

    public String getPurchaseID() { return purchaseID; }
    public String getPurchaseDate() { return purchaseDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setCar(Car car) { this.car = car; }

    public void displayPurchaseDetails(){
        System.out.println("Purchase Details: ");
        System.out.println("Purchase ID: " + purchaseID);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Payment Method: " + paymentMethod);
        customer.displayCustomerDetails();
        car.displayCarDetails();
    }

}
