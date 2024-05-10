# Employee Registration
## Introduction
The Employee Registration Application is a JavaFX-based system designed to manage employee information efficiently. It provides functionalities for creating an employee table in a MariaDB database, registering new employees, updating employee details, and viewing the list of employees. The application follows a Model-View-Controller (MVC) architecture to ensure clear separation of concerns and maintainability.

### DB.java
- This class establishes a connection to the MariaDB database using JDBC.
- It contains database credentials and a constructor to initialize the connection.
- DB(): Constructor method that initializes a connection to the MariaDB database using JDBC.

### Employee.java
- Represents the Employee entity with attributes such as ID, name, age, email, and department.
- Provides constructors, getters, and setters for accessing and manipulating employee data.
- Employee(int empID, String empName, int empAge, String empEmail, String empDept): Constructor method for creating an Employee object with specified attributes.
- Getter and setter methods for accessing and modifying employee attributes: getEmpID(), setEmpID(), getEmpName(), setEmpName(), getEmpAge(), setEmpAge(), getEmpEmail(), setEmpEmail(), getEmpDept(), setEmpDept().

### EmployeeDB.java
- Extends DB class and serves as the data access layer for employee-related operations.
- Contains methods to create the employee table, register new employees, update employee information, fetch employees from the database, and check the existence of the employee table.
- Utilizes JDBC PreparedStatement for database queries to prevent SQL injection.
- Implements error handling for SQLExceptions and provides utility methods for managing alerts.
- EmployeeDB(): Constructor method that initializes the connection to the database inherited from the DB class.
- createEmployeeTable(): Method to create the employee table in the database if it doesn't exist.
- registerEmployee(int id, String name, int age, String email, String department): Method to register a new employee in the database.
- updateEmployeeInfo(int id, String name, int age, String email, String department): Method to update the details of an existing employee in the database.
- getEmployees(): Method to fetch the list of employees from the database.
- employeeExists(int id): Private method to check if an employee with a given ID exists in the database.
- isTableExists(): Private method to check if the employee table exists in the database.

### EmployeeController.java
- Controller class responsible for handling user interactions in the employee registration view.
- Initializes database operations from EmployeeDB.
- Implements event handlers for buttons like creating employee table, registering employees, updating employee details, and viewing employees.
- Performs input validation and displays alerts for errors or successful operations.
- createEmployeeTableButton(ActionEvent event): Method executed when the create table button is clicked, which creates the employee table in the database.
- registerEmployeeButton(ActionEvent event): Method executed when the register employee button is clicked, which registers a new employee in the database.
- updateEmployeeButton(ActionEvent event): Method executed when the update employee button is clicked, which updates the details of an existing employee in the database.
- viewEmployeeButton(ActionEvent event): Method executed when the view employee button is clicked, which opens a new window to display the list of employees.

### ViewEmployeeController.java
- Controller class for the view employee list interface.
- Retrieves employee data from the database using EmployeeDB.
- Initializes TableView and TableColumn to display employee information.
- Handles initialization of the view and displays an alert in case of errors.
- initialize(): Method that runs when the FXML file is loaded, which fetches and displays the list of employees in a TableView.

### Utility.java
- Utility class providing a static method to display alert dialogs with customizable titles and content.
- showAlert(String title, String content): Static method to display an alert dialog with custom title and content.

### Main.java
- Entry point of the application.
- Loads the initial FXML file for the employee registration interface.
- Sets up the primary stage with the necessary scene.
- Handles exceptions during application startup and displays appropriate alerts.
- start(Stage primaryStage): Method that sets up the primary stage of the application, loads the initial FXML file, and handles exceptions during application startup.
- main(String[] args): Entry point of the application.
