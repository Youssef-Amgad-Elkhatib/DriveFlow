<h1>Car Dealership Management System</h1>
The Car Dealership Management System is a Java-based application designed to manage a car dealership's inventory, purchases, and rentals. It provides a comprehensive, menu-driven interface for users to interact with the system, allowing them to perform various operations such as adding, updating, removing, and displaying details about cars, purchases, and rentals. This program is ideal for managing a car dealership's day-to-day operations efficiently.

<h2>Key Features</h2>
<ol>
  <li><strong>Car Management</strong>
  <ul>
    <li><strong>Add New Cars:</strong> Add cars to the dealership inventory with details like model, color, make, year, price, rental rate, and insurance information.</li>
    <li><strong>Update Car Details:</strong> Modify existing car details, including model, color, make, year, price, rental rate, status, and insurance.</li>
    <li><strong>Remove Cars:</strong> Remove cars from the inventory.</li>
    <li>Display Car Details: View details of all cars in the inventory.</li>
    <li>Search for a Car: Search for a specific car by its ID.</li>
  </ul>
  </li>
   </br>
  <li>
   <strong>Purchase Management</strong> 
    <ul>
      <li><strong>Add New Purchases:</strong> Record new purchases, including purchase date, payment method, customer details, and the car being purchased.</li>
      <li><strong>Update Purchase Details:</strong> Modify purchase details such as purchase date, payment method, customer details, and car details.</li>
      <li><strong>Remove/Cancel Purchases:</strong> Remove or cancel a purchase.</li>
      <li><strong>Display Purchase Details:</strong> View details of all purchases.</li>
      <li><strong>Search for a Purchase:</strong> Search for a specific purchase by its ID.</li>
    </ul>
  </li>
  </br>
  <li>
  Rental Management
  <ul>
    <li><strong>Add New Rentals: </strong> Record new rentals, including rental start/end dates, customer details, the car being rented, and rental cost.</li>
      <li><strong>Update Rental Details:</strong> Modify rental details such as rental start/end dates, customer details, and car details.</li>
      <li><strong>Remove/Cancel Rentals:</strong> Remove or cancel a rental.</li>
      <li><strong>Display Display Rental Details:</strong>  View details of all rentals.</li>
      <li><strong>Search for a Rental:</strong>  Search for a specific rental by its ID.</li>
  </ul>
  </li>
</ol>






















4. System Operations
Load System Data: Load car, purchase, and rental details from a file.

Save System Data: Save the current state of the system to a file for persistence.

Calculate Total Earnings: Calculate and display total earnings from purchases and rentals.

Display System Summary: View a summary of all system details (cars, purchases, and rentals).

5. Input Validation
Ensures valid input for dates, prices, rental rates, and other numeric values.

Checks for duplicate IDs (e.g., car ID, purchase ID, rental ID).

Validates date ranges for rentals (e.g., rental end date must be after the start date).

6. Insurance Management
Each car has associated insurance details (e.g., provider name, policy number, expiry date, coverage details).

Insurance details can be updated along with car details.

How the Program Works
1. Initialization
The program starts by loading system data from a file (if available) and displaying a welcome message.

2. Menu Interaction
The user is presented with a menu of 19 options for managing cars, purchases, rentals, and system operations.

Based on the user's selection, the program performs the corresponding operation (e.g., adding a car, updating a purchase, calculating earnings).

3. Data Management
All data is stored in ArrayLists (cars, purchases, rentals).

Users can add, update, or remove records, and the changes are reflected in the ArrayLists.

4. File Operations
Users can save the current state of the system to a file for future use.

The program can also load data from a file to restore the system's state.

5. Exit Options
Users can exit the program with or without saving data.

Key Classes and Relationships
1. Car
Represents a car in the dealership inventory.

Attributes: Car ID, model, color, make, year, price, miles driven, rental rate, status, and insurance details.

2. Purchases
Represents a purchase transaction.

Attributes: Purchase ID, purchase date, payment method, customer details, and the car being purchased.

3. Rentals
Represents a rental transaction.

Attributes: Rental ID, rental start/end dates, customer details, the car being rented, and rental cost.

4. Customer
Represents a customer who makes a purchase or rental.

Attributes: Customer ID, name, phone, and email.

5. Insurance
Represents insurance details for a car.

Attributes: Insurance ID, provider name, policy number, expiry date, insurance cost, and coverage details.
