package lab_8_10;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeController {
	
	//object to interact with the database
	EmployeeDB db;

	//fxml injections
    @FXML
    private TextField employeeAge;

    @FXML
    private TextField employeeDepartment;

    @FXML
    private TextField employeeEmail;

    @FXML
    private TextField employeeID;

    @FXML
    private TextField employeeName;

    // method that is executed when the create table button is clicked
    @FXML
    void createEmployeeTableButton(ActionEvent event) {
    	try {
    		db = new EmployeeDB();
    		db.createEmployeeTable();
    	}
    	
    	catch (SQLException e) {
    		Utility.showAlert("Error", "Could not create 'Employee' table.");
    	}    	
    }

    // method that is executed when the register employee button is clicked
    @FXML
    void registerEmployeeButton(ActionEvent event) {
    	// get all the values from the fields
    	String idText = employeeID.getText();
    	String ageText = employeeAge.getText();
    	String name = employeeName.getText();
    	String dept = employeeDepartment.getText();
    	String email = employeeEmail.getText();
    	
    	// check if they are null, give alert if they are
    	if (idText == null || ageText == null || name == null || dept == null || email == null) {
    		Utility.showAlert("Error", "Enter all the fields!");
    		return;
    	}
    	
    	try {
    		int age = Integer.parseInt(ageText);
    		int id = Integer.parseInt(idText);   		
        	
        	try {
        		db = new EmployeeDB(); //add to db
        		db.registerEmployee(id, name, age, email, dept);
        	}
        	
        	catch (SQLException e) {
        		Utility.showAlert("Error", "Could not register employee.");
        		return;
        	}
    	}
    	
    	catch (Exception e) {
    		Utility.showAlert("Error", "Please enter a valid input. ");
    		return;
    	}  	
    	
    	Utility.showAlert("Success", "Employee successfully registered!");
    }
    
    // method that is executed when the update employee button is clicked
    @FXML
    void updateEmployeeButton(ActionEvent event) {
    	// get all the values from the fields
    	String idText = employeeID.getText();
    	String ageText = employeeAge.getText();
    	String name = employeeName.getText();
    	String dept = employeeDepartment.getText();
    	String email = employeeEmail.getText();
    	
    	// check if they are null, give alert if they are
    	if (idText == null || ageText == null || name == null || dept == null || email == null) {
    		Utility.showAlert("Error", "Enter all the fields!");
    		return;
    	}
    	try {
    		int age = Integer.parseInt(ageText);
    		int id = Integer.parseInt(idText);   		
        	
        	try {
        		db = new EmployeeDB();
        		db.updateEmployeeInfo(id, name, age, email, dept); //update the data
        	}
        	
        	catch (SQLException e) {
        		Utility.showAlert("Error", "Could not register employee.");
        	}
    	}
    	
    	catch (Exception e) {
    		Utility.showAlert("Error", "Please enter a valid input. ");
    	}  	
    }

    // method that is executed with the view employee button is clicked
    @FXML
    void viewEmployeeButton(ActionEvent event) {
    	try { 
	    	Parent root = FXMLLoader.load(getClass().getResource("/lab_8_10/viewemployee.fxml")); //open new fxml file
	    	Stage newStage = new Stage(); 
	    	Scene scene = new Scene(root);
	    	newStage.setResizable(false);
	    	newStage.setScene(scene);
	    	newStage.show();
	    }
    	
    	catch (Exception e) {
    		Utility.showAlert("Error", "Couldn't load employees list.");
    	}
    }

}

