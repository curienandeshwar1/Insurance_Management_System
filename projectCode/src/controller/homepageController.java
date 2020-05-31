package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class homepageController implements Initializable {	
	
	@FXML
    private MenuBar menuBar;
	
	@FXML 
	private AnchorPane rootpane; 
	
	@FXML
    private ImageView imgLogo;
	
	@FXML
    private ImageView imgLogo1; 
	
	@FXML
    private ImageView imgLogo2;
	
	@FXML
    private ImageView imgInsurance;
	
    @FXML
    private ImageView imgHomePol;
    

    @FXML
    private ImageView imgHealth;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
		Image img = new Image("/logo-iit.jpg");
		this.imgLogo.setImage(img);
		
		Image img2 = new Image("/INSURANCE-home.png");
		this.imgInsurance.setImage(img2);
		
		
		
		/*Image img4 = new Image("/healthlogo.jpg");
		this.imgHealth.setImage(img4);*/
		
		/*Image img5 = new Image("/logo-iit.jpg");
		this.imgLogo1.setImage(img5);
		
		Image img6 = new Image("/logo-iit.jpg");
		this.imgLogo2.setImage(img6);*/
	}
	
	
	public void goToLoginPage(ActionEvent event) throws IOException {
		Parent login_pg = FXMLLoader.load(getClass().getResource("/views/loginViewTest.fxml"));
		Scene login_view = new Scene(login_pg,600,500);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(login_view);
		window.show();
		
	} 
	
	
	public void goToHealthPolicyPage(ActionEvent event) throws IOException {
		AnchorPane content = FXMLLoader.load(getClass().getResource("/views/healthPolicyView.fxml"));
		 rootpane.getChildren().setAll(content);
		
	}
	
	public void closeApp(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	 public void goToHomePolicyPage(ActionEvent event) throws IOException {
		 AnchorPane content = FXMLLoader.load(getClass().getResource("/views/homePolicyView.fxml"));
		 rootpane.getChildren().setAll(content);
	 }


	


}
