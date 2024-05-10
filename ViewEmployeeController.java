package lab_8_10;

import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewEmployeeController {
	
	//load the fxml injections
	@FXML
    private TableColumn<Employee, Integer> empAge;

    @FXML
    private TableColumn<Employee, String> empDept;

    @FXML
    private TableColumn<Employee, String> empEmail;

    @FXML
    private TableColumn<Employee, Integer> empID;

    @FXML
    private TableColumn<Employee, String> empName;

    @FXML
    private TableView<Employee> empTable;

    EmployeeDB db;
	
	// method that will run as soon as the fxml file is loaded
	public void initialize() throws SQLException {    	
    	try {
    		//get all the employees 
			db = new EmployeeDB();
			List<Employee> employees = db.getEmployees();
			//set the columns of the table accordingly
			empID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("empID"));
			empName.setCellValueFactory(new PropertyValueFactory<Employee, String>("empName"));
			empAge.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("empAge"));
			empEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("empEmail"));
			empDept.setCellValueFactory(new PropertyValueFactory<Employee, String>("empDept"));
			//convert to observable list and set them in the table
		    ObservableList<Employee> observableTasks = FXCollections.observableArrayList(employees);
		    empTable.setItems(observableTasks);
		} 
		
		catch (SQLException e) { // show alert if any issue occurs
			Utility.showAlert("Error", "Sorry, employee data couldn't be updated :(");
		}   	
    }
}
