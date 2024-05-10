package lab_8_10;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDB extends DB {
	public EmployeeDB() throws SQLException { //parent class constructor
		super();
	}
	
	//method to create the employee table
	public void createEmployeeTable() {
	    String sql = "CREATE TABLE IF NOT EXISTS employees (" +
	            "id INT PRIMARY KEY," +
	            "name VARCHAR(100) NOT NULL," +
	            "age INT NOT NULL," +
	            "email VARCHAR(100) NOT NULL," +
	            "department VARCHAR(100) NOT NULL" +
	            ")"; 
	    
	    try {
	        Statement statement = con.createStatement(); 
	        statement.executeUpdate(sql);
	        System.out.println("Employee table created!");
	        
	    } 
	    
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//method to register new employee
	public void registerEmployee(int id, String name, int age, String email, String department) {
        if (!isTableExists()) {
        	Utility.showAlert("Error", "Employee table does not exist.");
            return;
        }
        
        String sql = "INSERT INTO employees (id, name, age, email, department) VALUES (?, ?, ?, ?, ?)";
        try {
        	PreparedStatement statement = con.prepareStatement(sql);
	
	        if (employeeExists(id)) {
	        	Utility.showAlert("Error", "Employee already exists.");
	            return;
	        }
	        
	        statement.setInt(1, id);
	        statement.setString(2, name);
	        statement.setInt(3, age);
	        statement.setString(4, email);
	        statement.setString(5, department);
	
	        statement.executeUpdate();
        }
        
        catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	// method to update the details of the existing employee
	public void updateEmployeeInfo(int id, String name, int age, String email, String department) {
        if (!isTableExists()) {
        	Utility.showAlert("Error", "Employee table does not exist.");
            return;
        }

        try {
            PreparedStatement statement = con.prepareStatement( "UPDATE employees SET name = ?, age = ?, email = ?, department = ? WHERE id = ?");

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, email);
            statement.setString(4, department);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                Utility.showAlert("Success", "Employee information updated succesfully!");
            } 
            
            else {
            	Utility.showAlert("Uh Oh!", "No employee found with ID: " + id);
            }

        } 
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// method to fetch employees from the database
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employees";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);		
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	        	int empID = resultSet.getInt("id");
	        	String empName = resultSet.getString("name");
	        	int empAge = resultSet.getInt("age");
	        	String empEmail = resultSet.getString("email");
	            String empDept = resultSet.getString("department");
	        	Employee employee = new Employee(empID, empName, empAge, empEmail, empDept);
	        	employees.add(employee);
	        }
	        
	        return employees;
		}
	    
	    catch(Exception e) {
	    	//e.printStackTrace();
	    	return employees;
	    }
	}
	
	//method to check where a particular employee exist using id
	private static boolean employeeExists(int id) {
    	try {
	        PreparedStatement statement = con.prepareStatement("SELECT id FROM employees WHERE id = ?");
	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();
	        return resultSet.next(); // returns true if ID exists, false otherwise
    	}
    	
    	catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    	
    }

	//method to check if table exists
    private static boolean isTableExists() {
        try {
            DatabaseMetaData metaData = con.getMetaData();
            try (ResultSet resultSet = metaData.getTables(null, null, "employees", null)) {
                return resultSet.next();
            }
        } 
        
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
