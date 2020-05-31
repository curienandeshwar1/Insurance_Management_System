package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class UserActions  {
	
	//public abstract void login();
	
	public void logoutFromView(ActionEvent event) throws IOException {
		Parent login_v = FXMLLoader.load(getClass().getResource("/views/homePageView.fxml"));
		Scene lohintest = new Scene(login_v);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(lohintest);
		window.show();
	}
	
	public abstract void GetDetailsFromDB();
 
}
 