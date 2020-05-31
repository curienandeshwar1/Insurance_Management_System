package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class healthViewController extends homepageController implements Initializable {
	@FXML
    private ImageView imgLogo3;
	
	   @FXML
	    private ImageView imgHealth;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Image img4 = new Image("/healthlogo.jpg");
		this.imgHealth.setImage(img4);
		
		Image img5 = new Image("/logo-iit.jpg");
		this.imgLogo3.setImage(img5);
	}

	@FXML 
	private AnchorPane rootpane; 
	
	public void goToHealthPolicyPage(ActionEvent event) throws IOException {
		AnchorPane content = FXMLLoader.load(getClass().getResource("/views/healthPolicyView.fxml"));
		 rootpane.getChildren().setAll(content);
		
	}
	
}
