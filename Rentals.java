public class Rentals {
    private String rentalID;
    private String rentalStartDate;
    private String rentalEndDate;
    private double rentalCost;
    private Customer customer;
    private Car car;


    public Rentals(String rentalID,String rentalStartDate, String rentalEndDate, Customer customer, Car car, double rentalCost) {
        this.rentalID = rentalID;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.customer = customer;
        this.car = car;
        this.rentalCost = rentalCost;
    }

    public String getRentalID() { return rentalID; }
    public String getRentalStartDate() { return rentalStartDate; }
    public String getRentalEndDate() { return rentalEndDate; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public double getRentalCost() { return rentalCost; }


    public void setRentalStartDate(String rentalStartDate) { this.rentalStartDate = rentalStartDate; }
    public void setRentalEndDate(String rentalEndDate) { this.rentalEndDate = rentalEndDate; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setCar(Car car) { this.car = car; }
    public void setRentalCost(double days) { this.rentalCost = days*car.getRentalRatePerDay(); }

    public void displayRentalDetails(){
        System.out.println("Rental Details: ");
        System.out.println("Rental ID: " + rentalID);
        System.out.println("Rental Start Date: " + rentalStartDate);
        System.out.println("Rental End Date: " + rentalEndDate);
        System.out.println("Rental Cost: " + rentalCost);
        customer.displayCustomerDetails();
        car.displayCarDetails();
    }


}
