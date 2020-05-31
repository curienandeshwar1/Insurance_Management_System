package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

import Dao.DBConnect;
import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BrManagerModel;


public class branchManagerController extends customerHomeController implements Initializable{
	
	@FXML
    private Pane paneViewCustomers;

    @FXML
    private Pane paneViewCustDetails;  

    @FXML
    private Pane paneEditCustomerDetails;

    @FXML
    private Pane paneDeleteCustDetails;
    
    
    //---------------------view customer------------------
    @FXML
    private TableView<BrManagerModel> tableCustomers;
    
    @FXML
    private TableColumn<BrManagerModel, String> custId1;

    @FXML
    private TableColumn<BrManagerModel, String> custName1;

    @FXML
    private TableColumn<BrManagerModel, String> custPhone1;

    @FXML
    private TableColumn<BrManagerModel, String> custAddress1;

    @FXML
    private TableColumn<BrManagerModel, String> custAge1;

    @FXML
    private TableColumn<BrManagerModel, String> custGender1;

    @FXML
    private TableColumn<BrManagerModel, String> custEmail1;


       //-----------------view single customer details------------
    @FXML
    private TextField txtCustIdView;
    
    @FXML
    private TableView<BrManagerModel> tableSingleCust;
    
    @FXML
    private TableColumn<BrManagerModel, String> custId;

    @FXML
    private TableColumn<BrManagerModel, String> custName;

    @FXML
    private TableColumn<BrManagerModel, String> custPhone;

    @FXML
    private TableColumn<BrManagerModel, String> custAddress;

    @FXML
    private TableColumn<BrManagerModel, String> custAge;

    @FXML
    private TableColumn<BrManagerModel, String> custGender;

    @FXML
    private TableColumn<BrManagerModel, String> custEmail;  

    
    @FXML
    private TableColumn<BrManagerModel, String> custPolicyId;

    @FXML
    private TableColumn<BrManagerModel, String> custPolicyName;
    
    @FXML
    private Label lblError;
    
    //------------------------delete customer----------------------
    @FXML
    private TextField txtDeleteCust;
    
    @FXML
    private Label lblDelete;
	
    //---------------------------edit customer---------------
    
    @FXML
    private TextField txtEditCustDetails;
    
    @FXML
    private TextField txtEditCustId;

    @FXML
    private TextField txtEditName;

    @FXML
    private TextField txtEditPhone;

    @FXML
    private TextField txtEditAddress;

    @FXML
    private TextField txtEditAge;

    @FXML
    private TextField txtEditGender;

    @FXML
    private TextField txtEditEmail;


    
    BrManagerModel brm = new BrManagerModel();
    
    @Override
    public void logoutFromView(ActionEvent event) throws IOException {
    	// TODO Auto-generated method stub
    	super.logoutFromView(event);
    }
    //logout from branch manager
	/*public void logoutFromBmView(ActionEvent event) throws IOException {
		Parent login_v = FXMLLoader.load(getClass().getResource("/views/loginViewTest.fxml"));
		Scene lohintest = new Scene(login_v);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(lohintest);
		window.show();
	}*/
	
	public void viewCustomer() {
		paneViewCustDetails.setVisible(false);
		paneEditCustomerDetails.setVisible(false);
		paneDeleteCustDetails.setVisible(false);
		paneViewCustomers.setVisible(true);
	}
	
	public void viewCustomerDetails() {
		paneViewCustomers.setVisible(false);
		paneEditCustomerDetails.setVisible(false);
		paneDeleteCustDetails.setVisible(false);
		paneViewCustDetails.setVisible(true);		
	}
	
	public void editCustomerDetails(){
		paneViewCustomers.setVisible(false);
		paneViewCustDetails.setVisible(false);
		paneDeleteCustDetails.setVisible(false);
		paneEditCustomerDetails.setVisible(true);
	}
	
	public void deleteCustomerDetails() {
		paneViewCustomers.setVisible(false);
		paneViewCustDetails.setVisible(false);
		paneEditCustomerDetails.setVisible(false);
		paneDeleteCustDetails.setVisible(true);
	}
     
	@FXML
    private ImageView imgLogo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Image img = new Image("/logo-iit.jpg");
		this.imgLogo.setImage(img);
		
		custId1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_id"));
		custName1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_name"));
		custPhone1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_phone"));
		custAddress1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_address"));
		custAge1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_age"));
		custGender1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_gender"));
		custEmail1.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_email"));
		
		custId.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_id"));
		custName.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_name"));
		custPhone.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_phone"));
		custAddress.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_address"));
		custAge.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_age"));
		custGender.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_gender"));
		custEmail.setCellValueFactory(new PropertyValueFactory<BrManagerModel, String>("cust_email"));
		
		//auto resize the column width
		tableCustomers.setColumnResizePolicy((param) -> true );
        Platform.runLater(() -> customResize(tableCustomers));
        
        //to call customer method
        BrManagerModel brm1= new BrManagerModel();
        tableCustomers.refresh();
        tableCustomers.getItems().setAll(brm1 .getCustomers());
        paneViewCustomers.setVisible(false);
	}
	
	//auto resize the column width
	public void customResize(TableView<?> view) {
        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth()+((tableWidth-
                width.get())/view.getColumns().size()));
            });
        }
}
	
	//view customer details from view customer
	public void viewCustomerTable() {
		tableCustomers.setVisible(true);
	}
	
	//method for viewing details for one customer
	public void viewSingleCustomerDetails() {
		String regex = "[a-zA-Z]";
		Pattern pattern = Pattern.compile(regex);
		String custId1= this.txtCustIdView.getText();
		if (custId1 == null || custId1.trim().equals("")) {
			lblError.setText("Please Enter Valid Customer Id!");
			return;
		}
		if(pattern.matcher(custId1).matches()) {
			lblError.setText("Please Enter Valid Customer Id!");
			return;
		}
		int custId= Integer.parseInt(custId1);
		//BrManagerModel brm = new BrManagerModel();
        tableSingleCust.setVisible(true);
        tableSingleCust.refresh();
		tableSingleCust.getItems().setAll(brm.getCustomerInfo(custId));
        		
	}
	
	//delete customer from database
	public void deleteCustFromDb(ActionEvent event) throws Exception {
		try {
			
			String delCust= this.txtDeleteCust.getText();
			if (this.txtDeleteCust.getText().isEmpty() || this.txtDeleteCust.getText().matches("^[a-zA-z]*$")) {
				this.lblDelete.setText("Please Enter Valid Customer Id!");
				return;
			}
			int delCustId = Integer.parseInt(delCust);
			//BrManagerModel brm = new BrManagerModel();		
			Boolean isDelete = brm.deleteCust(delCustId);
			if(isDelete) {
				lblDelete.setText("Customer successfully deleted!");
				return;
			}else {
				lblDelete.setText("Error deleting customer!");
				return;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error deleting customer : BM controller");
		}
		
		
	}
	
	
	//enter customer id and show in the edit text fields
	    int cust_Id=0;
		public void editViewShowCustDetails() {
			String custId1= this.txtEditCustDetails.getText();
			/*if (custId1 == null || custId1.trim().equals("")) {
				lblError.setText("Please Enter Valid Customer Id!");
				return;
			}
			*/
			cust_Id= Integer.parseInt(custId1);
			List<BrManagerModel> list= new ArrayList<>();
			list.addAll(brm.getCustomerInfo(cust_Id));
			for(BrManagerModel model : list) {
				this.txtEditCustId.setText(Integer.toString(model.getCust_id()));
				this.txtEditName.setText(model.getCust_name());
				this.txtEditPhone.setText(model.getCust_phone());
				this.txtEditAddress.setText(model.getCust_address());
				this.txtEditAge.setText(Integer.toString(model.getCust_age()));
				this.txtEditGender.setText(model.getCust_gender());
				this.txtEditEmail.setText(model.getCust_email());
			}
	        		
		}
		
		// pick up the  edited elements and push to update the db
		public void editCustAndPushToDb() {
			try {
				int cust_id= this.cust_Id;
				String cusId1 = this.txtEditCustId.getText();
				String cusName =this.txtEditName.getText();
				String cusPhone =this.txtEditPhone.getText();
				String cusAddress= this.txtEditAddress.getText();
				String cusAge1= this.txtEditAge.getText();
				String cusGender =this.txtEditGender.getText();
				String cusEmail= this.txtEditEmail.getText();
				
				int cusId= Integer.parseInt(cusId1);
				int cusAge= Integer.parseInt(cusAge1);
				
				Boolean isUpdate= brm.updateCustDetails(cust_id,cusId,cusName,cusPhone,cusAddress,cusAge,cusGender,cusEmail);
				
				if(isUpdate) {
					System.out.println("customer updated succesfully");
				}else {
					System.out.println("error updating customer");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Error editing cust details : BM controller");
			}
					}

}
