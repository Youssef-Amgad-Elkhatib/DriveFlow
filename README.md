<h1>Car Dealership Management System</h1>
<p>The Car Dealership Management System is a Java-based application designed to manage a car dealership's inventory, purchases, and rentals. It provides a comprehensive, menu-driven interface for users to interact with the system, allowing them to perform various operations such as adding, updating, removing, and displaying details about cars, purchases, and rentals. This program is ideal for managing a car dealership's day-to-day operations efficiently.</p>

<h2>Key Features</h2>
<ol>
    <li><strong>Car Management</strong>
        <ul>
            <li><strong>Add New Cars:</strong> Add cars to the dealership inventory with details like model, color, make, year, price, rental rate, and insurance information.</li>
            <li><strong>Update Car Details:</strong> Modify existing car details, including model, color, make, year, price, rental rate, status, and insurance.</li>
            <li><strong>Remove Cars:</strong> Remove cars from the inventory.</li>
            <li><strong>Display Car Details:</strong> View details of all cars in the inventory.</li>
            <li><strong>Search for a Car:</strong> Search for a specific car by its ID.</li>
        </ul>
    </li>
    <li><strong>Purchase Management</strong>
        <ul>
            <li><strong>Add New Purchases:</strong> Record new purchases, including purchase date, payment method, customer details, and the car being purchased.</li>
            <li><strong>Update Purchase Details:</strong> Modify purchase details such as purchase date, payment method, customer details, and car details.</li>
            <li><strong>Remove/Cancel Purchases:</strong> Remove or cancel a purchase.</li>
            <li><strong>Display Purchase Details:</strong> View details of all purchases.</li>
            <li><strong>Search for a Purchase:</strong> Search for a specific purchase by its ID.</li>
        </ul>
    </li>
    <li><strong>Rental Management</strong>
        <ul>
            <li><strong>Add New Rentals:</strong> Record new rentals, including rental start/end dates, customer details, the car being rented, and rental cost.</li>
            <li><strong>Update Rental Details:</strong> Modify rental details such as rental start/end dates, customer details, and car details.</li>
            <li><strong>Remove/Cancel Rentals:</strong> Remove or cancel a rental.</li>
            <li><strong>Display Rental Details:</strong> View details of all rentals.</li>
            <li><strong>Search for a Rental:</strong> Search for a specific rental by its ID.</li>
        </ul>
    </li>
</ol>

<h2>System Operations</h2>
<ul>
    <li><strong>Load System Data:</strong> Load car, purchase, and rental details from a file.</li>
    <li><strong>Save System Data:</strong> Save the current state of the system to a file for persistence.</li>
    <li><strong>Calculate Total Earnings:</strong> Calculate and display total earnings from purchases and rentals.</li>
    <li><strong>Display System Summary:</strong> View a summary of all system details (cars, purchases, and rentals).</li>
</ul>

<h2>Input Validation</h2>
<ul>
    <li>Ensures valid input for dates, prices, rental rates, and other numeric values.</li>
    <li>Checks for duplicate IDs (e.g., car ID, purchase ID, rental ID).</li>
    <li>Validates date ranges for rentals (e.g., rental end date must be after the start date).</li>
</ul>

<h2>Insurance Management</h2>
<ul>
    <li>Each car has associated insurance details (e.g., provider name, policy number, expiry date, coverage details).</li>
    <li>Insurance details can be updated along with car details.</li>
</ul>

<h2>How the Program Works</h2>
<h3>Initialization</h3>
<p>The program starts by loading system data from a file (if available) and displaying a welcome message.</p>

<h3>Menu Interaction</h3>
<p>The user is presented with a menu of 19 options for managing cars, purchases, rentals, and system operations. Based on the user's selection, the program performs the corresponding operation (e.g., adding a car, updating a purchase, calculating earnings).</p>

<h3>Data Management</h3>
<p>All data is stored in ArrayLists (cars, purchases, rentals). Users can add, update, or remove records, and the changes are reflected in the ArrayLists.</p>

<h3>File Operations</h3>
<p>Users can save the current state of the system to a file for future use. The program can also load data from a file to restore the system's state.</p>

<h3>Exit Options</h3>
<p>Users can exit the program with or without saving data.</p>

<h2>Key Classes and Relationships</h2>
<h3>Car</h3>
<p>Represents a car in the dealership inventory.</p>
<p><strong>Attributes:</strong> Car ID, model, color, make, year, price, miles driven, rental rate, status, and insurance details.</p>

<h3>Purchases</h3>
<p>Represents a purchase transaction.</p>
<p><strong>Attributes:</strong> Purchase ID, purchase date, payment method, customer details, and the car being purchased.</p>

<h3>Rentals</h3>
<p>Represents a rental transaction.</p>
<p><strong>Attributes:</strong> Rental ID, rental start/end dates, customer details, the car being rented, and rental cost.</p>

<h3>Customer</h3>
<p>Represents a customer who makes a purchase or rental.</p>
<p><strong>Attributes:</strong> Customer ID, name, phone, and email.</p>

<h3>Insurance</h3>
<p>Represents insurance details for a car.</p>
<p><strong>Attributes:</strong> Insurance ID, provider name, policy number, expiry date, insurance cost, and coverage details.</p>
