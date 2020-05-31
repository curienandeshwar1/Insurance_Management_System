package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AdminModel;

public class Main extends Application {
	
	public static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub--curie
	
		try {  
			stage = primaryStage;
			//AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/loginViewTest.fxml"));
			//AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/customerView.fxml"));
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/homePageView.fxml"));
			//AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/branchManagerView.fxml"));
			Scene scene = new Scene(root,710,530); 
			stage.setTitle("Login");
			stage.setScene(scene); 
			stage.show();  

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
		
	}
	
	public static void main(String args[]) {
		launch(args);
	}

}
