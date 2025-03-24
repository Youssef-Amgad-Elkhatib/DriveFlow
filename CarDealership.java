import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class CarDealership {
    private static ArrayList<Car> cars=new ArrayList<>();
    private static ArrayList<Purchases> purchases=new ArrayList<>();
    private static ArrayList<Rentals> rentals=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("======================================== Car Dealership System ======================================");
        loadSystemData();
        System.out.println("System Data Loaded Successfully");
        Menu();
    }

    private static void Menu(){
        System.out.println("======================================== Car Dealership Menu ========================================");
        System.out.println("Please select an option from the menu below:\n");

        System.out.printf("%-35s %-35s %-35s\n",
                "1.  Display Cars Details", "2.  Display Purchases Details", "3.  Display Rentals Details");
        System.out.printf("%-35s %-35s %-35s\n",
                "4.  Display System Details", "5.  Write System Details to File", "6.  Add a Car");
        System.out.printf("%-35s %-35s %-35s\n",
                "7.  Add a Purchase", "8.  Add a Rental", "9.  Update Car Details");
        System.out.printf("%-35s %-35s %-35s\n",
                "10. Update a Purchase Details", "11. Update a Rental Details", "12. Remove a Car");
        System.out.printf("%-35s %-35s %-35s\n",
                "13. Remove/Cancel a Purchase", "14. Remove/Cancel a Rental", "15. Calculate Total Earnings");
        System.out.printf("%-35s %-35s %-35s\n",
                "16. Search for a Car", "17. Search for a Purchase", "18. Search for a Rental");

        System.out.printf("\n");
        System.out.println("                                    19. Exit Application              ");
        System.out.println("=====================================================================================================");
        String selection = System.console().readLine();
        MenuSelection(selection);
    }
    private static void MenuSelection(String selection){
        switch (selection){
            case "1":
                displayCarsDetails();
                break;
            case "2":
                displayPurchasesDetails();
                break;
            case "3":
                displayRentalsDetails();
                break;
            case "4":
                displaySystemDetails();
                break;
            case "5":
                System.out.println("Enter System File name:");
                String fileName = System.console().readLine();
                writeToFile(fileName);
                break;
            case "6":
                addCar(getCarDetails());
                break;
            case "7":
                addPurchase(getPurchaseDetails());
                break;
            case "8":
                addRental(getRentalsDetails());
                break;
            case "9":
                updateCarDetails();
                break;
            case "10":
                updatePurchaseDetails();
                break;
            case "11":
                updateRentalsDetails();
                break;
            case "12":
                removeCar();
                break;
            case "13":
                System.out.println("1. Enter Purchase ID:");
                String purchaseRemoveID = System.console().readLine();
                for(Purchases p:purchases){
                    if(Objects.equals(p.getPurchaseID(), purchaseRemoveID)){
                        p.getCar().setStatus("Available");
                        cars.add(p.getCar());
                        purchases.remove(p);
                        System.out.println("Purchase successfully removed.");
                        Menu();
                    }
                }
                System.out.println("Error: Invalid purchase ID.");
                break;
            case "14":
                System.out.println("Enter Rental ID:");
                String rentalRemoveID = System.console().readLine();
                for(Rentals r:rentals){
                    if(Objects.equals(r.getRentalID(), rentalRemoveID)){
                        for(Car c:cars){
                            if(Objects.equals(c.getCarID(), r.getCar().getCarID())){
                                c.setStatus("Available");
                                break;
                            }
                        }
                        rentals.remove(r);
                        System.out.println("Rental successfully removed.");
                        Menu();
                    }
                }
                System.out.println("Error: Invalid rental ID.");
                break;
            case "15":
                double totalEarnings = calculateTotalEarnings();
                System.out.println("Total Earnings: " + totalEarnings);
                break;
            case "16":
                System.out.println("Enter Car ID:");
                String carID = System.console().readLine();
                for(Car c:cars){
                    if(c.getCarID().equals(carID)){
                        c.displayCarDetails();
                        Menu();
                    }
                }
                System.out.println("Error: Invalid car ID.");
                break;
            case "17":
                System.out.println("Enter Purchase ID:");
                String purchaseID = System.console().readLine();
                for(Purchases p:purchases){
                    if(p.getPurchaseID().equals(purchaseID)){
                        p.displayPurchaseDetails();
                        Menu();
                    }
                }
                System.out.println("Error: Invalid purchase ID.");
                break;
            case "18":
                System.out.println("Enter Rental ID:");
                String rentalID = System.console().readLine();
                for(Rentals r:rentals){
                    if(r.getRentalID().equals(rentalID)){
                        r.displayRentalDetails();
                        Menu();
                    }
                }
                System.out.println("Error: Invalid rental ID.");
                break;
            case "19":
                System.out.println("1. Save System Data and Exit");
                System.out.println("2. Exit without saving data");
                String choice = System.console().readLine();
                switch(choice){
                    case "1":
                        System.out.println("Enter System File name:");
                        String FileName = System.console().readLine();
                        writeToFile(FileName);
                        System.out.println("Exiting...");
                        System.exit(0);
                    case "2":
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
            default:
                System.out.println("Invalid Selection");
                break;
        }
        Menu();
    }

    public CarDealership() {
        cars = new ArrayList<>();
        purchases = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public static void addCar(Car car){
        cars.add(car);
    }

    public static void addPurchase(Purchases purchase){
        purchases.add(purchase);
    }

    public static void addRental(Rentals rental){
        rentals.add(rental);
    }

    public static void displaySystemDetails(){
        System.out.println("=====================================================================================================");
        displayCarsDetails();
        displayPurchasesDetails();
        displayRentalsDetails();
    }

    public static void displayCarsDetails(){
        System.out.println("=====================================================================================================");
        for(Car car : cars){
            car.displayCarDetails();
        }
    }

    public static void displayPurchasesDetails(){
        System.out.println("=====================================================================================================");
        for(Purchases purchase : purchases){
            purchase.displayPurchaseDetails();
        }
    }

    public static void displayRentalsDetails(){
        System.out.println("=====================================================================================================");
        for(Rentals rental : rentals){
            rental.displayRentalDetails();
        }
    }

    public static void loadSystemData(){
        System.out.println("Load System Data\n"+"Please enter System File name:");
        String fileName = "";
        fileName = System.console().readLine();
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("No file name provided. Program will exit.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Car ")) {
                    br.readLine();
                    Car car = readCarFromFile(br);
                    cars.add(car);
                }
                if(line.startsWith("Purchase ")){
                    br.readLine();
                    String purchaseID = readValue(br.readLine());
                    String purchaseDate = readValue(br.readLine());
                    String paymentMethod = readValue(br.readLine());
                    br.readLine();
                    String customerID = readValue(br.readLine());
                    String customerName = readValue(br.readLine());
                    String customerPhone = readValue(br.readLine());
                    String customerEmail = readValue(br.readLine());
                    br.readLine();
                    Car car= readCarFromFile(br);
                    Customer customer = new Customer((customerID), customerName, customerPhone, customerEmail);
                    Purchases purchase = new Purchases(purchaseID,purchaseDate, paymentMethod, customer, car);
                    purchases.add(purchase);
                }
                if(line.startsWith("Rental ")){
                    br.readLine();
                    String rentalID = readValue(br.readLine());
                    String rentalStartDate = readValue(br.readLine());
                    String rentalEndDate = readValue(br.readLine());
                    double rentalCost = parseDoubleValue(br.readLine());
                    br.readLine();
                    String customerID = readValue(br.readLine());
                    String customerName = readValue(br.readLine());
                    String customerPhone = readValue(br.readLine());
                    String customerEmail = readValue(br.readLine());
                    br.readLine();
                    Car car= readCarFromFile(br);
                    Customer customer = new Customer((customerID), customerName, customerPhone, customerEmail);
                    Rentals rental = new Rentals(rentalID, rentalStartDate, rentalEndDate, customer, car,rentalCost);
                    rentals.add(rental);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: File '" + fileName + "' not found. Please check the file path and try again.");
            loadSystemData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Car readCarFromFile(BufferedReader br) throws IOException {
        String carID = readValue(br.readLine());
        String model = readValue(br.readLine());
        String color = readValue(br.readLine());
        String make = readValue(br.readLine());
        String year = readValue(br.readLine());
        double price = parseDoubleValue(br.readLine());
        double milesDriven = parseDoubleValue(br.readLine());
        double rentalRatePerDay = parseDoubleValue(br.readLine());
        String status = readValue(br.readLine());

        br.readLine();
        String insuranceID = readValue(br.readLine());
        String providerName = readValue(br.readLine());
        String policyNumber = readValue(br.readLine());
        String expiryDate = readValue(br.readLine());
        double insuranceCost = parseDoubleValue(br.readLine());
        String coverageDetails = readValue(br.readLine());


        Insurance insurance = new Insurance(insuranceID, providerName, policyNumber, expiryDate, insuranceCost, coverageDetails);
        return new Car(model, color, make, year, price, milesDriven, carID, rentalRatePerDay, status, insurance);
    }

    public static void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Cars\n");
            writer.write("===========================================================================================================================================================\n");

            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                writer.write("Car " + (i + 1) + "\n\n");
                writer.write("CarID: " + car.getCarID() + "\n");
                writer.write("Model: " + car.getModel() + "\n");
                writer.write("Color: " + car.getColor() + "\n");
                writer.write("Make: " + car.getMake() + "\n");
                writer.write("Year: " + car.getYear() + "\n");
                writer.write("Price: " + car.getPrice() + "\n");
                writer.write("MilesDriven: " + car.getMilesDriven() + "\n");
                writer.write("RentalRatePerDay: " + car.getRentalRatePerDay() + "\n");
                writer.write("Status: " + car.getStatus() + "\n");

                // Writing Insurance Details
                writer.write("Insurance Details:\n");
                Insurance insurance = car.getInsurance();
                writer.write("\t\tInsuranceID: " + insurance.getInsuranceID() + "\n");
                writer.write("\t\tProviderName: " + insurance.getProviderName() + "\n");
                writer.write("\t\tPolicyNumber: " + insurance.getPolicyNumber() + "\n");
                writer.write("\t\tExpiryDate: " + insurance.getExpiryDate() + "\n");
                writer.write("\t\tInsuranceCost: " + insurance.getInsuranceCost() + "\n");
                writer.write("\t\tCoverageDetails: " + insurance.getCoverageDetails() + "\n");

                writer.write("===========================================================================================================================================================\n");
            }
            writer.write("\n");
            writer.write("Purchases\n");
            writer.write("===========================================================================================================================================================\n");
            for (int i = 0; i < purchases.size(); i++) {
                Purchases purchase = purchases.get(i);
                writer.write("Purchase " + (i + 1) + "\n\n");
                writer.write("PurchaseID: " + purchase.getPurchaseID() + "\n");
                writer.write("PurchaseDate: " + purchase.getPurchaseDate() + "\n");
                writer.write("PaymentMethod: " + purchase.getPaymentMethod() + "\n");
                writer.write("Customer Details:\n");
                writer.write("\t\tCustomerID: " + purchase.getCustomer().getCustomerID() + "\n");
                writer.write("\t\tCustomerName: " + purchase.getCustomer().getName() + "\n");
                writer.write("\t\tCustomerPhone: " + purchase.getCustomer().getPhone() + "\n");
                writer.write("\t\tCustomerEmail: " + purchase.getCustomer().getEmail() + "\n");
                Car car = purchase.getCar();
                writer.write("Car Details:\n");
                writer.write("\t\tCarID: " + car.getCarID() + "\n");
                writer.write("\t\tModel: " + car.getModel() + "\n");
                writer.write("\t\tColor: " + car.getColor() + "\n");
                writer.write("\t\tMake: " + car.getMake() + "\n");
                writer.write("\t\tYear: " + car.getYear() + "\n");
                writer.write("\t\tPrice: " + car.getPrice() + "\n");
                writer.write("\t\tMilesDriven: " + car.getMilesDriven() + "\n");
                writer.write("\t\tRentalRatePerDay: " + car.getRentalRatePerDay() + "\n");
                writer.write("\t\tStatus: " + car.getStatus() + "\n");


                writer.write("\t\tInsurance Details:\n");
                Insurance insurance = car.getInsurance();
                writer.write("\t\t\t\tInsuranceID: " + insurance.getInsuranceID() + "\n");
                writer.write("\t\t\t\tProviderName: " + insurance.getProviderName() + "\n");
                writer.write("\t\t\t\tPolicyNumber: " + insurance.getPolicyNumber() + "\n");
                writer.write("\t\t\t\tExpiryDate: " + insurance.getExpiryDate() + "\n");
                writer.write("\t\t\t\tInsuranceCost: " + insurance.getInsuranceCost() + "\n");
                writer.write("\t\t\t\tCoverageDetails: " + insurance.getCoverageDetails() + "\n");

                writer.write("===========================================================================================================================================================\n");
            }
            writer.write("\n");
            writer.write("Rentals\n");
            writer.write("===========================================================================================================================================================\n");
            for (int i = 0; i < rentals.size(); i++) {
                Rentals rental = rentals.get(i);
                writer.write("Rental " + (i + 1) + "\n\n");
                writer.write("RentalID: " + rental.getRentalID() + "\n");
                writer.write("RentalStartDate: " + rental.getRentalStartDate() + "\n");
                writer.write("RentalEndDate: " + rental.getRentalEndDate() + "\n");
                writer.write("RentalCost: " + rental.getRentalCost() + "\n");
                writer.write("Customer Details:\n");
                writer.write("\t\tCustomerID: " + rental.getCustomer().getCustomerID() + "\n");
                writer.write("\t\tCustomerName: " + rental.getCustomer().getName() + "\n");
                writer.write("\t\tCustomerPhone: " + rental.getCustomer().getPhone() + "\n");
                writer.write("\t\tCustomerEmail: " + rental.getCustomer().getEmail() + "\n");
                Car car = rental.getCar();
                writer.write("Car Details:\n");
                writer.write("\t\tCarID: " + car.getCarID() + "\n");
                writer.write("\t\tModel: " + car.getModel() + "\n");
                writer.write("\t\tColor: " + car.getColor() + "\n");
                writer.write("\t\tMake: " + car.getMake() + "\n");
                writer.write("\t\tYear: " + car.getYear() + "\n");
                writer.write("\t\tPrice: " + car.getPrice() + "\n");
                writer.write("\t\tMilesDriven: " + car.getMilesDriven() + "\n");
                writer.write("\t\tRentalRatePerDay: " + car.getRentalRatePerDay() + "\n");
                writer.write("\t\tStatus: " + car.getStatus() + "\n");
                // Writing Insurance Details
                writer.write("\t\tInsurance Details:\n");
                Insurance insurance = car.getInsurance();
                writer.write("\t\t\t\tInsuranceID: " + insurance.getInsuranceID() + "\n");
                writer.write("\t\t\t\tProviderName: " + insurance.getProviderName() + "\n");
                writer.write("\t\t\t\tPolicyNumber: " + insurance.getPolicyNumber() + "\n");
                writer.write("\t\t\t\tExpiryDate: " + insurance.getExpiryDate() + "\n");
                writer.write("\t\t\t\tInsuranceCost: " + insurance.getInsuranceCost() + "\n");
                writer.write("\t\t\t\tCoverageDetails: " + insurance.getCoverageDetails() + "\n");
                writer.write("===========================================================================================================================================================\n");
            }

            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static String readValue(String line) {
        if (line != null && line.contains(": ")) {
            String[] parts = line.split(": ", 2);
            return parts.length > 1 ? parts[1].trim() : "Unknown";
        }
        return "Unknown";
    }

    private static double parseDoubleValue(String line) {
        try {
            return Double.parseDouble(readValue(line));
        } catch (NumberFormatException e) {
            return 0.0; // Default value if parsing fails
        }
    }

    private static Car getCarDetails(){
        System.out.println("Enter Car ID:");
        String carID = System.console().readLine();
        if(cars.stream().anyMatch(car -> car.getCarID().equals(carID))){
            System.out.println("Error: Car ID already exists. Please enter a different car ID.");
            return getCarDetails();
        }
        System.out.println("Enter Car Model:");
        String model = System.console().readLine();
        System.out.println("Enter Car Color:");
        String color = System.console().readLine();
        System.out.println("Enter Car Make:");
        String make = System.console().readLine();
        System.out.println("Enter Car Year:");
        String year = System.console().readLine();
        double price = getPositiveDouble("Enter Car Price: ");
        double rentalRatePerDay=getPositiveDouble("Enter Rental Rate Per Day: ");
        double milesDriven = getPositiveDouble("Enter Miles Driven: ");
        String status = "Available";
        System.out.println("Enter Insurance ID:");
        String insuranceID = System.console().readLine();
        System.out.println("Enter Provider Name:");
        String providerName = System.console().readLine();
        System.out.println("Enter Policy Number:");
        String policyNumber = System.console().readLine();
        String expiryDate = getValidDate("Enter Expiry Date: ");
        double insuranceCost = getPositiveDouble("Enter Insurance Cost: ");
        System.out.println("Enter Coverage Details:");
        String coverageDetails = System.console().readLine();
        System.out.println("Car successfully added.");
        return new Car(model, color, make, year, price, milesDriven, carID, rentalRatePerDay, status, new Insurance(insuranceID, providerName, policyNumber, expiryDate, insuranceCost, coverageDetails));
    }

    public static double getPositiveDouble(String message) {
        double num;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                if (num >= 0) {
                    return num;
                } else {
                    System.out.println("Error: Please enter a non-negative number.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static Purchases getPurchaseDetails(){
        System.out.println("Enter Purchase ID:");
        String purchaseID = System.console().readLine();
        if(purchases.stream().anyMatch(purchase -> purchase.getPurchaseID().equals(purchaseID))){
            System.out.println("Error: Purchase ID already exists. Please enter a different purchase ID.");
            return getPurchaseDetails();
        }
        String purchaseDate = getValidDate("Enter Purchase Date: ");
        System.out.println("Enter Payment Method:");
        String paymentMethod = System.console().readLine();
        System.out.println("Enter Customer ID:");
        String customerID = System.console().readLine();
        System.out.println("Enter Customer Name:");
        String customerName = System.console().readLine();
        System.out.println("Enter Customer Phone:");
        String customerPhone = System.console().readLine();
        System.out.println("Enter Customer Email:");
        String customerEmail = System.console().readLine();
        System.out.println("Enter Car ID Sold:");
        String carID = System.console().readLine();
        Car car = null;
        for(Car c:cars){
            if(c.getCarID().equals(carID) && c.getStatus().equals("Available")){
                car=c;
                break;
            }
        }
        if (car == null){
            System.out.println("Error: Invalid car ID. Please enter a valid car ID that is available.");
            Menu();
        }
        car.setStatus("Purchased");
        Customer customer = new Customer(customerID, customerName, customerPhone, customerEmail);
        Purchases purchase = new Purchases(purchaseID,purchaseDate, paymentMethod, customer, car);
        cars.remove(car);
        System.out.println("Purchase successfully created.");
        return purchase;
    }

    private static Rentals getRentalsDetails(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter Rental ID:");
        String rentalID = System.console().readLine();
        if(rentals.stream().anyMatch(rental -> rental.getRentalID().equals(rentalID))){
            System.out.println("Error: Rental ID already exists. Please enter a different rental ID.");
            return getRentalsDetails();
        }
        String rentalStartDate = getValidDate("Enter Rental Start Date: ");
        String rentalEndDate = getValidDate("Enter Rental End Date: ");
        double daysRented = 0;
        while(true){
            LocalDate startDate = LocalDate.parse(rentalStartDate, formatter);
            LocalDate endDate = LocalDate.parse(rentalEndDate, formatter);
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            if(daysBetween<=0){
                System.out.println("Error: Invalid date range. Please enter a valid date range.");
                rentalStartDate = getValidDate("Enter Rental Start Date: ");
                rentalEndDate = getValidDate("Enter Rental End Date: ");
            }else{
                daysRented=daysBetween;
                break;
            }
        }
        System.out.println("Enter Customer ID:");
        String customerID = System.console().readLine();
        System.out.println("Enter Customer Name:");
        String customerName = System.console().readLine();
        System.out.println("Enter Customer Phone:");
        String customerPhone = System.console().readLine();
        System.out.println("Enter Customer Email:");
        String customerEmail = System.console().readLine();
        System.out.println("Enter Car ID Rented:");
        String carID = System.console().readLine();
        Car car = null;
        for(Car c:cars){
            if(c.getCarID().equals(carID) && c.getStatus().equals("Available")){
                car=c;
                break;
            }
        }
        if(car == null){
            System.out.println("Error: Invalid car ID. Please enter a valid car ID that is available.");
            Menu();
        }
        double rentalCost=daysRented*car.getRentalRatePerDay();
        car.setStatus("Rented");
        Customer customer = new Customer(customerID, customerName, customerPhone, customerEmail);
        Rentals rental= new Rentals(rentalID,rentalStartDate,rentalEndDate,customer,car,rentalCost);
        System.out.println("Rental successfully created.");
        return rental;
    }

    public static String getValidDate(String message) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                LocalDate.parse(input, formatter);
                return input;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in day/month/year format.");
            }
        }
    }

    private static void updateCarDetails(){
        Car car = null;
        System.out.println("Enter Car ID:");
        String carID = System.console().readLine();
        boolean found=false;
        for(Car c:cars){
            if(c.getCarID().equals(carID)){
                car=c;
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Error: Invalid car ID. Please enter a valid car ID.");
            Menu();
        }
        car=CarDetailsMenu(car);
        for(Car c:cars){
            if(c.getCarID().equals(carID)){
                cars.remove(c);
                break;
            }
        }
        cars.add(car);
        System.out.println("Car details updated successfully.");
    }
    
    private static Car CarDetailsMenu(Car c){
        System.out.println("Select an option: ");
        System.out.println("1.  Update Car Model");
        System.out.println("2.  Update Car Color");
        System.out.println("3.  Update Car Make");
        System.out.println("4.  Update Car Year");
        System.out.println("5.  Update Car Price");
        System.out.println("6.  Update Rental Rate Per Day");
        System.out.println("7.  Update miles driven");
        System.out.println("8.  Update Car Status");
        System.out.println("9.  Update Insurance Details");
        System.out.println("10. Return to Main Menu");
        switch (System.console().readLine()){
            case "1":
                System.out.println("Enter new Car Model:");
                String model = System.console().readLine();
                c.setModel(model);
                break;
            case "2":
                System.out.println("Enter new Car Color:");
                c.setColor(System.console().readLine());
                break;
            case "3":
                System.out.println("Enter new Car Make:");
                String make = System.console().readLine();
                c.setMake(make);
                break;
            case "4":
                System.out.println("Enter new Car Year:");
                String year = System.console().readLine();
                c.setYear(year);
                break;
            case "5":
                double price = getPositiveDouble("Enter new Car Price:");
                c.setPrice(price);
                break;
            case "6":
                double ratePerDay = getPositiveDouble("Enter new Rental Rate Per Day:");
                c.setRentalRatePerDay(ratePerDay);
                break;
            case "7":
                double milesDriven = getPositiveDouble("Enter new miles driven:");
                c.setMilesDriven(milesDriven);
                break;
            case "8":
                System.out.println("Enter new Car Status:");
                c.setStatus(System.console().readLine());
                break;
            case "9":
                System.out.println("Enter Insurance ID:");
                String insuranceID = System.console().readLine();
                System.out.println("Enter Provider Name:");
                String providerName = System.console().readLine();
                System.out.println("Enter Policy Number:");
                String policyNumber = System.console().readLine();
                String expiryDate = getValidDate("Enter Expiry Date: ");
                double insuranceCost = getPositiveDouble("Enter Insurance Cost:");
                System.out.println("Enter Coverage Details:");
                String coverageDetails = System.console().readLine();
                c.getInsurance().setInsuranceID(insuranceID);
                c.getInsurance().setProviderName(providerName);
                c.getInsurance().setPolicyNumber(policyNumber);
                c.getInsurance().setExpiryDate(expiryDate);
                c.getInsurance().setInsuranceCost(insuranceCost);
                c.getInsurance().setCoverageDetails(coverageDetails);
                break;
            case "10":
                System.out.println("Details successfully updated.");
                Menu();
            default:
                System.out.println("Invalid option. Please select a valid option.");
                CarDetailsMenu(c);
        }
        return CarDetailsMenu(c);
    }

    private static void updatePurchaseDetails() {
        Purchases purchase = null;
        System.out.println("Enter Purchase ID:");
        String purchaseID = System.console().readLine();
        boolean found = false;
        for (Purchases p : purchases) {
            if (p.getPurchaseID().equals(purchaseID)) {
                purchase = p;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Invalid purchase ID. Please enter a valid purchase ID.");
            Menu();
        } else {
            purchase=PurchaseDetailsMenu(purchase);
        }
        for(Purchases p:purchases){
            if(p.getPurchaseID().equals(purchaseID)){
                purchases.remove(p);
                break;
            }
        }
        purchases.add(purchase);
        System.out.println("Purchase details successfully updated.");

    }

    private static Purchases PurchaseDetailsMenu(Purchases p) {
        System.out.println("Select an option to update: ");
        System.out.println("1. Update Purchase Date");
        System.out.println("2. Update Payment Method");
        System.out.println("3. Update Customer Details");
        System.out.println("4. Update Car Details");
        System.out.println("5. Return to Main Menu");
        switch (System.console().readLine()) {
            case "1":
                p.setPurchaseDate(getValidDate("Enter new Purchase Date: "));
                break;
            case "2":
                System.out.println("Enter new Payment Method:");
                p.setPaymentMethod(System.console().readLine());
                break;
            case "3":
                System.out.println("Update Customer Details: ");
                System.out.println("Enter Customer ID:");
                p.getCustomer().setCustomerID(System.console().readLine());
                System.out.println("Enter Customer Name:");
                p.getCustomer().setName(System.console().readLine());
                System.out.println("Enter Customer Phone:");
                p.getCustomer().setPhone(System.console().readLine());
                System.out.println("Enter Customer Email:");
                p.getCustomer().setEmail(System.console().readLine());
                break;
            case "4":
                System.out.println("Enter Car ID to replace current car: ");
                String carID = System.console().readLine();
                boolean found = false;
                Car car = null;
                for (Car c : cars) {
                    if (c.getCarID().equals(carID) && c.getStatus().equals("Available")) {
                        c.setStatus("Purchased");
                        p.getCar().setStatus("Available");
                        found = true;
                        car=c;
                        cars.remove(c);
                        cars.add(p.getCar());
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Error: Invalid car ID. Please enter a valid car ID.");
                    Menu();
                }
                p.setCar(car);
                break;
            case "5":
                System.out.println("Details successfully updated.");
                Menu();
            default:
                System.out.println("Invalid option. Please select a valid option.");
                PurchaseDetailsMenu(p);
        }
        return PurchaseDetailsMenu(p);
    }

    private static void updateRentalsDetails() {
        Rentals rental = null;
        System.out.println("Enter Rental ID:");
        String rentalID = System.console().readLine();
        boolean found = false;
        for (Rentals r : rentals) {
            if (r.getRentalID().equals(rentalID)) {
                rental = r;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Invalid rental ID. Please enter a valid rental ID.");
            Menu();
        } else {
            rental = RentalDetailsMenu(rental);
        }
        for (Rentals r : rentals) {
            if (r.getRentalID().equals(rentalID)) {
                rentals.remove(r);
                break;
            }
        }
        rentals.add(rental);
        System.out.println("Rental details successfully updated.");
    }

    private static Rentals RentalDetailsMenu(Rentals r) {
        System.out.println("Select an option to update: ");
        System.out.println("1. Update Rental Start Date");
        System.out.println("2. Update Rental End Date");
        System.out.println("3. Update Customer Details");
        System.out.println("4. Update Car Details");
        System.out.println("5. Return to Main Menu");
        switch (System.console().readLine()) {
            case "1":
                String rentalStartDate = getValidDate("Enter new Rental Start Date: ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate startDate = LocalDate.parse(rentalStartDate, formatter);
                LocalDate endDate = LocalDate.parse(r.getRentalEndDate(), formatter);
                double daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
                if (daysBetween <= 0) {
                    System.out.println("Error: Invalid date range. Please enter a valid date range.");
                    RentalDetailsMenu(r);
                }
                r.setRentalStartDate(rentalStartDate);
                r.setRentalCost(daysBetween);    
                break;
            case "2":
                String rentalEndDate = getValidDate("Enter new Rental End Date: ");
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate Start_date = LocalDate.parse(r.getRentalStartDate(), format);
                LocalDate End_date = LocalDate.parse(rentalEndDate, format);
                double days = ChronoUnit.DAYS.between(Start_date, End_date);
                if (days <= 0) {
                    System.out.println("Error: Invalid date range. Please enter a valid date range.");
                    RentalDetailsMenu(r);
                }
                r.setRentalEndDate(rentalEndDate);
                r.setRentalCost(days);
                break;
            case "3":
                System.out.println("Update Customer Details: ");
                System.out.println("Enter Customer ID:");
                r.getCustomer().setCustomerID(System.console().readLine());
                System.out.println("Enter Customer Name:");
                r.getCustomer().setName(System.console().readLine());
                System.out.println("Enter Customer Phone:");
                r.getCustomer().setPhone(System.console().readLine());
                System.out.println("Enter Customer Email:");
                r.getCustomer().setEmail(System.console().readLine());
                break;
            case "4":
                System.out.println("Enter Car ID to replace the current car: ");
                String carID = System.console().readLine();
                boolean found = false;
                Car car = null;
                for (Car c : cars) {
                    if (c.getCarID().equals(carID) && c.getStatus().equals("Available")) {
                        found = true;
                        c.setStatus("Rented");
                        car = c;
                        for(Car c1:cars){
                            if(c1.getCarID().equals(r.getCar().getCarID())){
                                c1.setStatus("Available");
                                break;
                            }
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Error: Invalid car ID. Please enter a valid car ID.");
                    Menu();
                }
                r.setCar(car);
                break;
            case "5":
                System.out.println("Details successfully updated.");
                Menu();
            default:
                System.out.println("Invalid option. Please select a valid option.");
                RentalDetailsMenu(r);
        }
        return RentalDetailsMenu(r);
    }
        
    private static void removeCar(){
        System.out.println("Enter Car ID:");
        String carID = System.console().readLine();
        boolean found=false;
        for(Car c:cars){
            if(c.getCarID().equals(carID)){
                for(Rentals r:rentals){
                    if(r.getCar().getCarID().equals(carID)){
                        rentals.remove(r);
                        break;
                    }
                }
                cars.remove(c);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Error: Invalid car ID");
            return;
        }
        System.out.println("Car successfully removed.");
    }

    public static double calculateTotalEarnings() {
        double purchaseTotal=0,rentalTotal=0;

        for (Purchases purchase : purchases) {
            purchaseTotal += purchase.getCar().getPrice();
        }
        System.out.println("Total earnings from Purchases: " + purchaseTotal);

        for (Rentals rental : rentals) {
            rentalTotal += rental.getRentalCost();
        }
        System.out.println("Total earnings from Rentals: " + rentalTotal);

        return purchaseTotal+rentalTotal;
    }
}

