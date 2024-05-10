package lab_8_10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/lab_8_10/employee.fxml"));			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/lab_8_10/application.css").toExternalForm());
			primaryStage.setTitle("Employee Registration Application");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			Utility.showAlert("Error!", "Employee table does not exist.");
		} 
		
		catch(Exception e) {
			Utility.showAlert("Error!", "Can't load Wisteria :(");
		}
	}
	
	public static void main(String[] args) {
		launch(args);	
	}
}
