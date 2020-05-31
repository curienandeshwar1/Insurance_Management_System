package controller;

import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.Observable;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.loginModel;

public class loginController implements Initializable {
	
	@FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private TextField txtUsername;
    
    @FXML 
    private ComboBox<String> combouserType;
     
    private loginModel model;
    
    public loginController() {
    	model= new loginModel();    	
    } 
    
    public ActionEvent event;
	
	public void Login(ActionEvent event) throws IOException {
		Parent login_v = FXMLLoader.load(getClass().getResource("/views/adminView.fxml"));
		Scene logintest = new Scene(login_v);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(logintest);
		window.show();
		
	}
	
	ObservableList<String> userTypeList = FXCollections.observableArrayList("Admin","Branch Manager","Customer");
	
	@FXML
    private ImageView imgLogo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		Image img = new Image("/logo-iit.jpg");
		this.imgLogo.setImage(img);
		
		combouserType.setItems(userTypeList);

	}	
	
	//---------------------------------------------------------------------
	
	public void loginButtonCheck() {
		String comboBox = this.combouserType.getValue();
		System.out.println("combobox value is" + comboBox);
	}
	
	public void login() throws IOException {
		String username = this.txtUsername.getText();
		String password = this.txtPassword.getText();
		String userType = this.combouserType.getValue();

		// Validations
		
		if (username == null || username.trim().equals("") && 
				   (password == null || password.trim().equals("")) && (userType == null || userType.trim().equals(""))) {
					lblError.setText("User name / password Cannot be empty or spaces");
					return;
				}
		
		if (username == null || username.trim().equals("")) {
			lblError.setText("Username cannot be empty or spaces");
			return;

		}
		if (password == null || password.trim().equals("")) {
			lblError.setText("Password cannot be empty or spaces");
			return;
		}
		if (userType == null || userType.trim().equals("")) {
			lblError.setText("User Type cannot be empty or spaces");
			return;
		}
		
		// authentication check
		checkCredentials(username, password,userType);
		
	}
	
	public void checkCredentials(String username, String password ,String userType) {
		System.out.println("userType is :"+ userType);
		Boolean isValid = model.getCredentials(username, password,userType);
		if (!isValid) {
			lblError.setText("User does not exist!");
			return;
		}
		try {
			AnchorPane root;
			if (userType=="Admin" && isValid) {
				// If user is admin, inflate admin view

				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/adminView.fxml"));
				Main.stage.setTitle("Admin View");
  
			} else if(userType=="Branch Manager" && isValid) {
				// If user is customer, inflate customer view
				
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/branchManagerView.fxml"));
				// User ID acquired from db
				int user_id = 1;
 				//customerController.setUser(user_id);
				Main.stage.setTitle("Branch Manager View");

			} else if(userType=="Customer" && isValid){
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/customerView.fxml"));
				Main.stage.setTitle("Customer View");
				
			}else {
				root=null;
				System.out.println("Not a valid user!!");
			}

			Scene scene = new Scene(root);
			Main.stage.setScene(scene);

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}

	}

	
	/*public void checkCredentials(String username, String password ,String userType) {
		Boolean isValid = model.getCredentials(username, password, userType);
		if (!isValid) {
			lblError.setText("User does not exist!");
			return;
		}
		try {
			AnchorPane root;
			if (model.isAdmin() && isValid) {
				// If user is admin, inflate admin view

				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/adminView.fxml"));

				Main.stage.setTitle("Admin View");
  
			} else {
				// If user is customer, inflate customer view
				
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/CustomerView.fxml"));
				// User ID acquired from db
				int user_id = 1;
 				//customerController.setUser(user_id);
				Main.stage.setTitle("Customer View");

			}

			Scene scene = new Scene(root);
			Main.stage.setScene(scene);

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}

	}
*/
	

	

}