package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AdminModel;

public class adminController extends UserActions implements Initializable {

	@FXML
	private Pane paneViewPolicy;

	@FXML
	private TableView<AdminModel> tablePolicy;

	@FXML
	private TableColumn<AdminModel, String> policy_id;

	@FXML
	private TableColumn<AdminModel, String> policy_name;

	@FXML
	private TableColumn<AdminModel, String> policy_type;

	@FXML
	private TableColumn<AdminModel, String> policy_duration;

	@FXML
	private TableColumn<AdminModel, String> policy_amount;

	@FXML
	private TableColumn<AdminModel, String> policy_desc;

	// --------------------------------------------Add
	// policy-----------------------------------

	@FXML
	private Pane paneAddPolicy;

	@FXML
	private TextField txtPolicyId;

	@FXML
	private TextField txtPolicyName;

	@FXML
	private TextField txtPolicyType;

	@FXML
	private TextField txtPolicyDuration;

	@FXML
	private TextField txtPolicyAmount;

	@FXML
	private TextField txtPolicyDescription;

	@FXML
	private Label lblAddPolicy;

	// --------------------------------------Delete
	// POlicy---------------------------------------
	@FXML
	private Pane paneDeletePolicy;

	@FXML
	private TextField txtDeletePolicyId;

	@FXML
	private Label lblDeletePolicy;

	// -------------------------------------View
	// Branch---------------------------------------------------
	@FXML
	private Pane paneViewBranch;

	@FXML
	private TableView<AdminModel> tableBranch;

	@FXML
	private TableColumn<AdminModel, String> Branch_ID;

	@FXML
	private TableColumn<AdminModel, String> Branch_name;

	@FXML
	private TableColumn<AdminModel, String> Branch_location;

	@FXML
	private Pane paneAddBranch;

	// -----------------------------------------Add
	// Branch-------------------------------------------------------

	@FXML
	private TextField txtBranchId;

	@FXML
	private TextField txtBranchName;

	@FXML
	private TextField txtBranchLocation;

	@FXML
	private Label lblAddBranch;

	@FXML
	private GridPane gridAddBranch;

	// -----------------------------------------View Branch manager
	// Details--------------------------------------------

	@FXML
	private Pane paneViewBranchManager;

	@FXML
	private TableView<AdminModel> tableBranchManager;

	@FXML
	private TableColumn<AdminModel, String> bm_id;

	@FXML
	private TableColumn<AdminModel, String> bm_name;

	@FXML
	private TableColumn<AdminModel, String> bm_phone;

	@FXML
	private TableColumn<AdminModel, String> bm_address;

	@FXML
	private TableColumn<AdminModel, String> bm_email;

	@FXML
	private TableColumn<AdminModel, String> bm_age;

	@FXML
	private TableColumn<AdminModel, String> bm_userId;

	@FXML
	private TableColumn<AdminModel, String> bm_branchID;

	@FXML
	private Pane paneEditBranchManager;

	// -----------------------------------------------Update Branch
	// Manager-----------------------------------

	@FXML
	private TextField txtUpdateManager;

	@FXML
	private TextField txtEditId;

	@FXML
	private TextField txtEditName;

	@FXML
	private TextField txtEditPhone;

	@FXML
	private TextField txtEditAddress;

	@FXML
	private TextField txtEditAge;

	@FXML
	private TextField txtEditEmail;

	@FXML
	private TextField txtEditBranchId;
	
	 @FXML
	    private Label lblEditMgrSubmit;

	    @FXML
	    private Label lblEditMgrSave;

	// --------------------------------------------------------------------------------------------------

	AdminModel adm = new AdminModel();
	
	@FXML
    private ImageView imgLogo;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Image img = new Image("/logo-iit.jpg");
		this.imgLogo.setImage(img);
		
		// TODO Auto-generated method stub
		policy_id.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("policy_id"));
		policy_name.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("policy_name"));
		policy_type.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("policy_type"));
		policy_duration.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("policy_duration"));
		policy_amount.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("policy_amount"));
		policy_desc.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("policy_desc"));
		
		Branch_ID.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("branch_id"));
		Branch_name.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("Branch_name"));
		Branch_location.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("Branch_location"));
		
		bm_id.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_id"));
		bm_name.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_name"));
		bm_phone.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_phone"));
		bm_address.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_address"));
		bm_email.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_email"));
		bm_age.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_age"));
		bm_branchID.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_branch_id"));
		bm_userId.setCellValueFactory(new PropertyValueFactory<AdminModel, String>("bm_user_id"));

		// auto adjust width of columns depending on their content
		tablePolicy.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tablePolicy));
		tableBranch.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tableBranch));
		tableBranchManager.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tableBranchManager));

		AdminModel adm = new AdminModel();
		tablePolicy.getItems().setAll(adm.getAccounts()); // load table data from CustomerModel list
		paneViewPolicy.setVisible(false);

		// AdminModel adm2 = new AdminModel();
		tableBranch.getItems().setAll(adm.getBranch());
		paneViewBranch.setVisible(false);

		// AdminModel adm3 = new AdminModel();
		/*tableBranchManager.getItems().setAll(adm.getBranchManager());
		paneViewBranchManager.setVisible(false);*/

	}

	public void customResize(TableView<?> view) {

		AtomicLong width = new AtomicLong();
		view.getColumns().forEach(col -> {
			width.addAndGet((long) col.getWidth());
		});
		double tableWidth = view.getWidth();

		if (tableWidth > width.get()) {
			view.getColumns().forEach(col -> {
				col.setPrefWidth(col.getWidth() + ((tableWidth - width.get()) / view.getColumns().size()));
			});
		}
	}

	// click view Policy button
	public void clickviewPolicyButton() {
		paneAddPolicy.setVisible(false);
		paneDeletePolicy.setVisible(false);
		paneViewPolicy.setVisible(true);
	}

	// click admin Add policy button
	public void clickAddPolicyButton() {
		paneViewPolicy.setVisible(false);
		paneDeletePolicy.setVisible(false);
		paneAddPolicy.setVisible(true);
	}

	// click admin delete policy button
	public void clickDeletePolicyButton() {
		paneViewPolicy.setVisible(false);
		paneAddPolicy.setVisible(false);
		paneDeletePolicy.setVisible(true);
	}

	// click admin view branch button

	public void clickViewBranchButton() {
		paneAddBranch.setVisible(false);
		paneViewBranch.setVisible(true); 
	}
	// click admin add branch button

	public void clickAddBranchButton() {
		paneViewBranch.setVisible(false);
		paneAddBranch.setVisible(true);
	}

	// click admin view branch button

	public void clickViewBranchMgrButton() {
		paneEditBranchManager.setVisible(false);
		paneViewBranchManager.setVisible(true);
		GetDetailsFromDB();
	}

	// click admin update branch button

	public void clickEditBranchMgrButton() {
		paneViewBranchManager.setVisible(false);
		paneEditBranchManager.setVisible(true);
	}

	// assigning values and passing to db method
	public void enterAddPolicyDetails() {
		String policyId = this.txtPolicyId.getText();
		int pId = Integer.parseInt(policyId);
		String pName = this.txtPolicyName.getText();
		String pType = this.txtPolicyType.getText();
		String pDuration = this.txtPolicyDuration.getText();
		String pAmt = this.txtPolicyAmount.getText();
		String pDesc = this.txtPolicyDescription.getText();

		// validations
		addPolicyToDb(pId, pName, pType, pDuration, pAmt, pDesc);

	}

	public void addPolicyToDb(int pId, String pName, String pType, String pDuration, String pAmt, String pDesc) {
		try {
			// AdminModel adm_ins = new AdminModel();
			Boolean isSuccess = adm.insertPolicyToDb(pId, pName, pType, pDuration, pAmt, pDesc);
			if (isSuccess) {
				this.lblAddPolicy.setText("Policy Added Successfully!");
				//return;
			} else {
				this.lblAddPolicy.setText("Policy Not Added!");		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in add policy form :Admin Controller");
		}

	}

	// Delete policy
	public void EnterDeletePolicy() {
		// AdminModel amDel = new AdminModel();
		String policyId = this.txtDeletePolicyId.getText();
		System.out.println("get policy id");
		int pId = Integer.parseInt(policyId);
		boolean IsDeleted = adm.deletePolicyFromDB(pId);
		if (IsDeleted) {
			this.lblDeletePolicy.setText("Policy Deleted Successfully!");
		} else {
			this.lblDeletePolicy.setText("Policy not found!");
		}
	}

	// Add Branch Details to DB
	public void enterAddBranchDetails() {
		String branchId = this.txtBranchId.getText();
		int bId = Integer.parseInt(branchId);
		String bName = this.txtBranchName.getText();
		String bLocation = this.txtBranchLocation.getText();
		addBranchToDB(bId, bName, bLocation);
	}
	
	

	public void addBranchToDB(int bId, String bName, String bLocation) {
		try {
			// AdminModel admBrnch = new AdminModel();
			Boolean isSuccess = adm.insertBranchToDB(bId, bName, bLocation);
			if (isSuccess) {
				System.out.println("Branch is true");
				this.lblAddBranch.setText("Branch Added Successfully!");
			} else {
				this.lblAddBranch.setText("Unsuccessful Attempt!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in add branch form :Admin Controller");
		}

	}

	// Edit Branch Manager Details

	// enter customer id and show in the edit text fields
	int bm_Id = 0;

	public void clickToSubmit() {
		String bmId = this.txtUpdateManager.getText();
		
		  if (bmId == null || bmId.trim().equals("")) {
		  this.lblEditMgrSubmit.setText("Please Enter Valid Customer Id!"); 
		 }		 
		// AdminModel admUpdate = new AdminModel();
		bm_Id = Integer.parseInt(bmId);
		List<AdminModel> list = new ArrayList<>();
		list.addAll(adm.getBranchManagerInfo(bm_Id));
		for (AdminModel model : list) {
			this.txtEditId.setText(Integer.toString(model.getBm_id()));
			this.txtEditName.setText(model.getBm_name());
			this.txtEditPhone.setText(Integer.toString(model.getBm_phone()));
			this.txtEditAddress.setText(model.getBm_address());
			this.txtEditAge.setText(Integer.toString(model.getBm_age()));
			this.txtEditEmail.setText(model.getBm_email());
			this.txtEditBranchId.setText(Integer.toString(model.getBm_branch_id()));
		}

	}

	// pick up the edited elments and push to update the db
	public void clickToUpdateBM() {
		int bm_id = this.bm_Id;
		String bmId = this.txtEditId.getText();
		String bmName = this.txtEditName.getText();
		String bmPhone = this.txtEditPhone.getText();
		String bmAddress = this.txtEditAddress.getText();
		String bmAge = this.txtEditAge.getText();
		String bmEmail = this.txtEditEmail.getText();
		String bmBranchId = this.txtEditBranchId.getText();

		int bm_id1 = Integer.parseInt(bmId);
		int bmPhone1 = Integer.parseInt(bmPhone);
		int bmAge1 = Integer.parseInt(bmAge);
		int bmBranchId1 = Integer.parseInt(bmBranchId);

		// AdminModel admUpdate = new AdminModel();
		Boolean isUpdate = adm.updateBMDetails(bm_id, bm_id1, bmName, bmPhone1, bmAddress, bmAge1, bmEmail,
				bmBranchId1);

		if (isUpdate) {
			this.lblEditMgrSave.setText("Manager details updated Succesfully!");
		} else {
			this.lblEditMgrSave.setText("Error updating details!");
		}
	}

	// logout from admin manager
	/*public void logoutFromAdminView(ActionEvent event) throws IOException {
		Parent login_v = FXMLLoader.load(getClass().getResource("/views/loginViewTest.fxml"));
		Scene lohintest = new Scene(login_v);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(lohintest);
		window.show();
	}*/
    
	//logout from admin
	@Override
	public void logoutFromView(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		super.logoutFromView(event);
	}
	
	@Override
	public void GetDetailsFromDB() { //to get branch Manager details
		// TODO Auto-generated method stub
		
		tableBranchManager.getItems().setAll(adm.getBranchManager());
		//paneViewBranchManager.setVisible(false);
		
	}

}
