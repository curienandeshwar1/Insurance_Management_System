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

public class homeViewController extends homepageController implements Initializable {
	@FXML
    private ImageView imgLogo2;
	
	@FXML
    private ImageView imgHomePol;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Image img4 = new Image("/homepolicyinsurance.jpg");
		this.imgHomePol.setImage(img4);
		
		Image img5 = new Image("/logo-iit.jpg");
		this.imgLogo2.setImage(img5);
	}
	@FXML 
	private AnchorPane rootpane; 
	 public void goToHomePolicyPage(ActionEvent event) throws IOException {
		 AnchorPane content = FXMLLoader.load(getClass().getResource("/views/homePolicyView.fxml"));
		 rootpane.getChildren().setAll(content);
	 }

}
