public class Car {
    private String model;
    private String color;
    private String make;
    private String year;
    private double price;
    private double milesDriven;
    private String Car_ID;
    private double rentalRatePerDay;
    private Insurance insurance;
    private String Status;

    public Car(String model, String color, String make, String year, double price, double milesDriven, String Car_ID, double rentalRatePerDay, String Status, Insurance insurance) {
        this.model = model;
        this.color = color;
        this.make = make;
        this.year = year;
        this.price = price;
        this.milesDriven = milesDriven;
        this.Car_ID = Car_ID;
        this.rentalRatePerDay = rentalRatePerDay;
        this.Status = Status;
        this.insurance=insurance;
    }

    public String getModel() { return model; }
    public String getColor() { return color; }
    public String getMake() { return make; }
    public String getYear() { return year; }
    public double getPrice() { return price; }
    public double getMilesDriven() { return milesDriven; }
    public String getCarID() { return Car_ID; }
    public double getRentalRatePerDay() { return rentalRatePerDay; }
    public String getStatus() { return Status; }
    public Insurance getInsurance() { return insurance; }

    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setMake(String make) { this.make = make; }
    public void setYear(String year) { this.year = year; }
    public void setPrice(double price) { this.price = price; }
    public void setMilesDriven(double milesDriven) { this.milesDriven = milesDriven; }
    public void setRentalRatePerDay(double rentalRatePerDay) { this.rentalRatePerDay = rentalRatePerDay; }
    public void setStatus(String status) { this.Status = status; }

    public void displayCarDetails() {
        System.out.println("Car Details: ");
        System.out.println("Car ID: " + Car_ID);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Make: " + make);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
        System.out.println("Miles Driven: " + milesDriven);
        System.out.println("Rental Rate Per Day: " + rentalRatePerDay);
        System.out.println("Status: " + Status);
        displayInsuranceDetails();
        System.out.println("=====================================================================================================");
    }

    public void displayInsuranceDetails() {
        insurance.displayInsuranceDetails();
    }

}
