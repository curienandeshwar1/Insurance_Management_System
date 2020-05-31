package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BrManagerModel;
import model.customerModel;

public class customerHomeController extends UserActions implements UserFunctions, Initializable {
	@FXML
	private AnchorPane custRootPane;

	@FXML
	private Pane paneHomePolicy;

	@FXML
	private Pane paneRented;
 
	@FXML
	private Pane paneOwned;

	@FXML
	private Pane paneHealthPolicy;

	@FXML
	private Pane paneHealthIndividual;

	@FXML
	private Pane paneProHealthPlus;

	// -----------------------navigating through tabs---------------
	@FXML
	private TabPane tabPane;

	@FXML
	private Tab tabRegisterHomePolicy;

	@FXML
	private Tab tabRegisterHealthPolicy;
	// ------------------confirmation reg---------------------
	
	@FXML
	private Pane paneRegConfirmation;

	// -------------------------------home Policy------------------

	@FXML
	private TextField txtRegName;

	@FXML
	private TextField txtRegAge;

	@FXML
	private TextField txtRegPhone;

	@FXML
	private TextField txtcusID;

	@FXML
	private ComboBox<String> comboHouseType;

	@FXML
	private ComboBox<String> comboPolicyDuration;

	@FXML
	private TextField txtValueAssets;

	@FXML
	private TextField txtHomeAmtPaid;

	@FXML
	private TextField txtValueHome;

	@FXML
	private TextField txtNomName;

	@FXML
	private TextField txtNomRelation;
	
	@FXML
	private Label customerid,customername,customerage,customerphone,valueassets,valuehome,nomRelationError,nomNameError;

	// -------------------------health pol registration---------------------
	

    @FXML
    private Pane paneRegHealthPolicy;
    
	  @FXML
	    private TextField txtCustName;

	    @FXML
	    private TextField txtCustAge;

	    @FXML
	    private TextField txtCustPhone;

	    @FXML
	    private TextField txtCustId;

	    @FXML
	    private ComboBox<String> comboHealthPlanType;

	    @FXML
	    private ComboBox<String> comboHealthPolDuration;
	    
	    @FXML
	    private ComboBox<String> comboMedIssue;

	    @FXML
	    private TextField txtHealthAmtToPay;

	    @FXML
	    private TextField txtOtherIssue;

	    @FXML
	    private TextField txtHealthNomineeName;

	    @FXML
	    private TextField txtHealthNomineeRelation;
	    
	//------------------------------Registered POlicy details-----------------
	    
	    @FXML
	    private TextField txtSubmitPid;
	    
	    @FXML
	    private Label lblCustId;

	    @FXML
	    private Label lblPolName;
	    
	    @FXML
	    private Label lblPolAge;

	    @FXML
	    private Label lblPolPhone;

	    @FXML
	    private Label lblPolType;

	    @FXML
	    private Label lblPolDuration;

	    @FXML
	    private Label lblAmtPay;

	    @FXML
	    private Label lblNomName;

	    @FXML
	    private Label lblNomRelation;
	    
	    @FXML
	    private Label lblPolDetError;

   //--------------------------------Customer own details------------------------------
	    
	    @FXML
	    private TextField txtSubmitCustIDOwn;

	    @FXML
	    private Label lblCusDetailsError;

	    @FXML
	    private Label lblCustIdOwn;

	    @FXML
	    private Label lblCusNameOwn;

	    @FXML
	    private Label lblCusPhoneOwn;

	    @FXML
	    private Label lblCusAddressOwn;

	    @FXML
	    private Label lblCustAgeOwn;

	    @FXML
	    private Label lblCustGenderOwn;

	    @FXML
	    private Label lblCustEmailOwn;

	 
	//----------------------------------------------------------------------------------------
    
	    //drop down for combo boxes
	ObservableList<String> HomeTypeList = FXCollections.observableArrayList("Rented", "Owned");
	ObservableList<String> PolicyDurationList = FXCollections.observableArrayList("1 year", "2 year");
	ObservableList<String> HealthPlanType = FXCollections.observableArrayList("Health Individual", "Pro-Health Plus");
	ObservableList<String> HealthDuration = FXCollections.observableArrayList("1 year", "2 year");
	ObservableList<String> HealthMedIssue = FXCollections.observableArrayList("Diabetes", "Plague" ,"Cancer");
    
	@Override
	public void logoutFromView(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		super.logoutFromView(event);
	}
	/*public void logoutFromCustomerView(ActionEvent event) throws IOException {
		Parent login_v = FXMLLoader.load(getClass().getResource("/views/homePageView.fxml"));
		Scene lohintest = new Scene(login_v);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(lohintest);
		window.show();
	}*/

	public void viewHomePolicy() {
		paneHealthPolicy.setVisible(false);
		paneHomePolicy.setVisible(true);
	}

	public void viewHealthPolicy() {
		paneHomePolicy.setVisible(false);
		paneHealthPolicy.setVisible(true);
	}

	public void viewRentedHome() {
		paneOwned.setVisible(false);
		paneRented.setVisible(true);
	}

	public void viewOwnedHome() {
		paneRented.setVisible(false);
		paneOwned.setVisible(true);
	}

	public void viewHealthIndividual() {
		paneProHealthPlus.setVisible(false);
		paneHealthIndividual.setVisible(true);
	}

	public void viewProHealthPlus() {
		paneHealthIndividual.setVisible(false);
		paneProHealthPlus.setVisible(true);
	}

	public void clickToRegisterHome() {
		tabPane.getSelectionModel().select(tabRegisterHomePolicy);
	}

	public void clickToRegisterHealth() {
		tabPane.getSelectionModel().select(tabRegisterHealthPolicy);
	}

	public void goToConfirmationPane() throws SQLException {
		paneRegConfirmation.setVisible(true);

	}

	// navigates to policy id confirmation box
	public void goToPolicyRegIdPage(ActionEvent event) throws Exception {
		try {
			String id = registerHomeCustomerPolicy();
			if (!id.isEmpty()) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/views/policyRegIdView.fxml"));
				loader.load();
				policyRegIdController pol = loader.getController();
				pol.getId(id);
				Parent p = loader.getRoot();
				Stage stg = new Stage();
				stg.setScene(new Scene(p));
				stg.showAndWait();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}
	
	@FXML
    private ImageView imgLogo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Image img = new Image("/logo-iit.jpg");
		this.imgLogo.setImage(img);
		// home combo boxes
		comboHouseType.setItems(HomeTypeList);
		comboPolicyDuration.setItems(PolicyDurationList);

		// health combo boxes
		comboHealthPlanType.setItems(HealthPlanType);
		comboHealthPolDuration.setItems(HealthDuration);
		comboMedIssue.setItems(HealthMedIssue);
	}

	@Override
	public String registerHomeCustomerPolicy() throws Exception {
		// TODO Auto-generated method stub
		String policy_id = null;
		try {
			customerModel cm = new customerModel();
			String txtCusId = this.txtcusID.getText();
			String regName = this.txtRegName.getText();
			String regAge = this.txtRegAge.getText();
			String regPhone = this.txtRegPhone.getText();
			String comboHomeType = this.comboHouseType.getValue();
			String comboPolicyDuration = this.comboPolicyDuration.getValue();
			// to set the amt paid depending upon the selection
			String amttoPay = cm.getAmountPaid(comboHomeType, comboPolicyDuration);
			this.txtHomeAmtPaid.setText(amttoPay);
			String valueOfAssets = this.txtValueAssets.getText();
			String valueOfHome = this.txtValueHome.getText();
			String nomName = this.txtNomName.getText();
			String nomRelation = this.txtNomRelation.getText();
			checkCommonValidation();
			if (this.txtcusID.getText().isEmpty()) {
				System.out.println("eroor");
			}

			int cusId = Integer.parseInt(txtCusId);
			int regAge1 = Integer.parseInt(regAge);
			int regphone1 = Integer.parseInt(regPhone);
			int assetvalue1 = Integer.parseInt(valueOfAssets);
			int homevalue1 = Integer.parseInt(valueOfHome);

			policy_id = cm.insertPolicyRegForHome(cusId, regName, regAge1, regphone1, comboHomeType,
					comboPolicyDuration, amttoPay, assetvalue1, homevalue1, nomName, nomRelation);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error while home policy registration: customer Home Controller");
		}
		return policy_id;

	}

	@FXML
	public void checkCommonValidation() {
		// Validations

		// Id Validation
		// boolean custid = false ;
		if (this.txtcusID.getText().isEmpty()) {
			// custid = true;
			this.customerid.setText("Please enter id!!!");
		} 

		// boolean custidcheck = false;
		if (this.txtcusID.getText().matches("^[a-zA-z]*$")) {
			// custidcheck = true;
			this.customerid.setText("No characters allowed!!!");
		} else {
			// custidcheck = false;
			this.customerid.setText("");
		}

		// Name Validations
		// boolean custname = false;
		if (this.txtRegName.getText().isEmpty()) {
			// custname = true;
			this.customername.setText("Please enter name!!!");
		} 

		// boolean custnamecheck = false;
		if (this.txtRegName.getText().matches("^[0-9]*$")) {
			// custnamecheck = true;
			this.customername.setText("Numbers are not allowed!!!");
		} 

		// Age Validations
		boolean custage = false;
		if (this.txtRegAge.getText().isEmpty()) {
			custage = true;
			this.customerage.setText("Please enter age!!!");
		} 

		boolean custagecheck = false;
		if ((this.txtRegAge.getText().matches("^[a-zA-z]*$"))) {
			custagecheck = true;
			this.customerage.setText("No characters allowed!!!");
		} 

		// Phone Validations
		//boolean custphone = false;
		if (this.txtRegAge.getText().isEmpty()) {
		
			this.customerphone.setText("Please enter phone!!!");
		} 
		//boolean valueofassets = false;
		if (this.txtValueAssets.getText().isEmpty()) {

			this.valueassets.setText("Please enter Value of Assets!!!");
		} 
	
		if (this.txtValueHome.getText().isEmpty()) {
			
			this.valuehome.setText("Please enter Value of Home!!!");
		} 
		
		if(this.txtNomName.getText().isEmpty()|| this.txtNomName.getText().matches("^\\d+"))
		{this.nomNameError.setText("Please enter proper Name!");
		}
		if(this.txtNomRelation.getText().isEmpty()|| this.txtNomRelation.getText().matches("^\\d+"))
		{this.nomRelationError.setText("Please enter proper relation!");
		}
	}

	public void clearHomeFields() {
		this.txtcusID.setText(null);
		this.txtRegName.setText(null);
		this.txtRegAge.setText(null);
		this.txtRegPhone.setText(null);
		this.txtValueAssets.setText(null);
		this.txtValueHome.setText(null);
		this.txtHomeAmtPaid.setText(null);
		this.txtNomName.setText(null);
		this.txtNomRelation.setText(null);
		this.comboHouseType.setValue(null);
		this.comboPolicyDuration.setValue(null);
	}

	// -------------------------------------------Health
	// Page------------------------------

	public void acceptToRegisterPolicy() {
		paneRegHealthPolicy.setVisible(true);
	}

	public void goToHealthPolicyRegIdPage() throws IOException { // method to go to policy id pop-up
		try {
			String id = registerHealthCustomerPolicy();
			if (!id.isEmpty()) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/views/policyRegIdView.fxml"));
				loader.load();
				policyRegIdController pol = loader.getController();
				pol.getId(id);
				Parent p = loader.getRoot();
				Stage stg = new Stage();
				stg.setScene(new Scene(p));
				stg.showAndWait();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("");
		}

	}

	public void clearHealthField() {
		this.txtCustId.setText(null);
		this.txtCustName.setText(null);
		this.txtCustAge.setText(null);
		this.txtCustPhone.setText(null);
		this.comboHealthPlanType.setValue(null);
		this.comboHealthPolDuration.setValue(null);
		this.txtHealthAmtToPay.setText(null);
		this.comboMedIssue.setValue(null);
		this.txtOtherIssue.setText(null);
		this.txtHealthNomineeName.setText(null);
		this.txtHealthNomineeRelation.setText(null);
	}

	@Override
	public String registerHealthCustomerPolicy() {
		// TODO Auto-generated method stub
		String policy_id = null;
		try {
			customerModel cm = new customerModel();
			String txtCustId = this.txtCustId.getText();
			String regName = this.txtCustName.getText();
			String regAge = this.txtCustAge.getText();
			String regPhone = this.txtCustPhone.getText();
			String comboHealthType = this.comboHealthPlanType.getValue();
			String comboHealPolDuration = this.comboHealthPolDuration.getValue();
			// to set the amt paid depending upon the selection
			String amttoPay = cm.getAmountPaid(comboHealthType, comboHealPolDuration);
			this.txtHealthAmtToPay.setText(amttoPay);
			String medIssues = this.comboMedIssue.getValue();
			String otherIssues = this.txtOtherIssue.getText();
			String nomName = this.txtHealthNomineeName.getText();
			String nomRelation = this.txtHealthNomineeRelation.getText();

			int custId = Integer.parseInt(txtCustId);
			int healAge1 = Integer.parseInt(regAge);
			int healphone1 = Integer.parseInt(regPhone);

			policy_id = cm.insertPolicyRegForHealth(custId, regName, healAge1, healphone1, comboHealthType,
					comboHealPolDuration, amttoPay, medIssues, otherIssues, nomName, nomRelation);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error while home policy registration: customer Home Controller");
		}
		return policy_id;
	}

	// -------------------------------------Get policy details---------------
	@Override
	public void GetDetailsFromDB() { // method to get policy details as per policy id
		// TODO Auto-generated method stub
		String pol_id = this.txtSubmitPid.getText();
		int pid = Integer.parseInt(pol_id);

		customerModel cm = new customerModel();
		List<customerModel> list = new ArrayList<>(); // list for collecting the result set from db

		String REGEX1 = "^8\\d+";
		String regex2 = "^6\\d+";
		Pattern p = Pattern.compile(REGEX1);
		Pattern p1 = Pattern.compile(regex2);
		Matcher m = p.matcher(pol_id);
		Matcher m2 = p1.matcher(pol_id);

		boolean matchFound_hea = m.matches(); // matches string with the regex pattern
		boolean matchFound_hom = m2.matches();

		if (matchFound_hea) {
			list.addAll(cm.getHealthPolicyDetailsFromDb(pid));
		}
		if (matchFound_hom) {
			list.addAll(cm.getHomePolicyDetailsFromDb(pid));
		}
		/*if (!matchFound_hea || !matchFound_hom) {
			this.lblPolDetError.setText("Enter Valid Policy ID!!");
		}*/

		for (customerModel model : list) {
			this.lblCustId.setText(Integer.toString(model.getCust_id()));
			this.lblPolName.setText(model.getRegName());
			this.lblPolAge.setText(Integer.toString(model.getAge()));
			this.lblPolPhone.setText(Integer.toString(model.getPhone()));
			this.lblPolType.setText(model.getPolicyType());
			this.lblPolDuration.setText(model.getPolicyDuration());
			this.lblAmtPay.setText(model.getPolicyAmt());
			this.lblNomName.setText(model.getNomiName());
			this.lblNomRelation.setText(model.getNomiRelation());
		}

	}

	// -------------------------------------Customer Own details-----------------

	public void getCustomerInfo() {
		try {
			String cust_id = this.txtSubmitCustIDOwn.getText();
			int cid = Integer.parseInt(cust_id);

			BrManagerModel bm = new BrManagerModel();
			List<BrManagerModel> list = new ArrayList<>();

			String REGEX1 = "^3\\d+";
			Pattern p = Pattern.compile(REGEX1);
			Matcher m = p.matcher(cust_id);

			boolean matchFound_cust = m.matches();

			if (matchFound_cust) {
				list.addAll(bm.getCustomerInfo(cid));
			} else {
				this.lblCusDetailsError.setText("Enter Valid Customer ID!");
			}

			for (BrManagerModel model : list) {
				this.lblCustIdOwn.setText(Integer.toString(model.getCust_id()));
				this.lblCusNameOwn.setText(model.getCust_name());
				this.lblCusPhoneOwn.setText(model.getCust_phone());
				this.lblCusAddressOwn.setText(model.getCust_address());
				this.lblCustAgeOwn.setText(Integer.toString(model.getCust_age()));
				this.lblCustGenderOwn.setText(model.getCust_gender());
				this.lblCustEmailOwn.setText(model.getCust_email());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in fetching customer info : customer controller" + e);
		}
	}

}
