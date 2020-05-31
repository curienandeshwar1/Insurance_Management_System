package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class policyRegIdController implements  Initializable{
	
	@FXML
	private Label lblPolicyId;
	
	public void getId(String id) {
		boolean bval =false;
         //this.lblPolicyId.setText(id);
		if(id !="") { 
			bval=true;			
		} 
		if(bval) {
			this.lblPolicyId.setText(id);
			return;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}
