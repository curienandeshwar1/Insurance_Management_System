package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Dao.DBConnect;

public class AdminModel extends DBConnect {

	int policy_id, branch_id, bm_id, bm_phone, bm_age, bm_user_id, bm_branch_id;
	String policy_type, policy_duration, policy_amount, policy_desc, policy_name, branch_name, branch_location, bm_name,
			bm_address, bm_email;

	public AdminModel() {
	}

	/*public AdminModel(int policy_id, String policy_type, String policy_duration, String policy_amount,
			String policy_desc, String policy_name, int branch_id, String branch_name, String branch_location,
			int bm_id, String bm_name, int bm_phone, String bm_address, String bm_email, int bm_age, int bm_user_id,
			int bm_branch_id) {
		this.policy_id = policy_id;
		this.policy_type = policy_type;
		this.policy_duration = policy_duration;
		this.policy_amount = policy_amount;
		this.policy_desc = policy_desc;
		this.policy_name = policy_name;
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.branch_location = branch_location;
		this.bm_id = bm_id;
		this.bm_name = bm_name;
		this.bm_phone = bm_phone;
		this.bm_address = bm_address;
		this.bm_email = bm_email;
		this.bm_age = bm_age;
		this.bm_user_id = bm_user_id;
		this.bm_branch_id = bm_branch_id;

	}
*/
	public int getBm_branch_id() {
		return bm_branch_id;
	}

	public void setBm_branch_id(int bm_branch_id) {
		this.bm_branch_id = bm_branch_id;
	}

	public int getBm_id() {
		return bm_id;
	}

	public void setBm_id(int bm_id) {
		this.bm_id = bm_id;
	}

	public int getBm_phone() {
		return bm_phone;
	}

	public void setBm_phone(int bm_phone) {
		this.bm_phone = bm_phone;
	}

	public int getBm_age() {
		return bm_age;
	}

	public void setBm_age(int bm_age) {
		this.bm_age = bm_age;
	}

	public int getBm_user_id() {
		return bm_user_id;
	}

	public void setBm_user_id(int bm_user_id) {
		this.bm_user_id = bm_user_id;
	}

	public String getBm_name() {
		return bm_name;
	}

	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	}

	public String getBm_address() {
		return bm_address;
	}

	public void setBm_address(String bm_address) {
		this.bm_address = bm_address;
	}

	public String getBm_email() {
		return bm_email;
	}

	public void setBm_email(String bm_email) {
		this.bm_email = bm_email;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_location() {
		return branch_location;
	}

	public void setBranch_location(String branch_location) {
		this.branch_location = branch_location;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public String getPolicy_duration() {
		return policy_duration;
	}

	public void setPolicy_duration(String policy_duration) {
		this.policy_duration = policy_duration;
	}

	public String getPolicy_amount() {
		return policy_amount;
	}

	public void setPolicy_amount(String policy_amount) {
		this.policy_amount = policy_amount;
	}

	public String getPolicy_desc() {
		return policy_desc;
	}

	public void setPolicy_desc(String policy_desc) {
		this.policy_desc = policy_desc;
	}

	// View Policy details from DB

	// Statement stmt =null ;
	public List<AdminModel> getAccounts() {
		List<AdminModel> accounts = new ArrayList<>();
		String query = "SELECT * FROM pc_policy2;";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AdminModel adm = new AdminModel();
				adm.setPolicy_id(rs.getInt("policy_id"));
				adm.setPolicy_name(rs.getString("policy_name")); // add account data to arraylist
				adm.setPolicy_type(rs.getString("policy_type"));
				adm.setPolicy_amount(rs.getString("policy_amt"));
				adm.setPolicy_duration(rs.getString("policy_duration"));
				adm.setPolicy_desc(rs.getString("policy_desc"));
				accounts.add(adm);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Error fetching Accounts: " + e1);
		}
		return accounts;

	}

	// Code to view the branch details after fetching result from DB

	public List<AdminModel> getBranch() {
		List<AdminModel> branch = new ArrayList<>();
		String query = "Select * from PC_Branch2;";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AdminModel brAdm = new AdminModel();
				brAdm.setBranch_id(rs.getInt("branch_id"));
				brAdm.setBranch_name(rs.getString("branch_name"));
				brAdm.setBranch_location(rs.getString("branch_location"));
				branch.add(brAdm);
			}
			// connection.close();
			rs.close();
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Error fetching Accounts: " + e1);

		}
		return branch;
	}

	// View Branch manager Details
	public List<AdminModel> getBranchManager() {
		List<AdminModel> branchMgr = new ArrayList<>();
		String query = "Select * from PC_branch_manager2;";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				AdminModel BM = new AdminModel();
				BM.setBm_id(rs.getInt("bm_id"));
				BM.setBm_name(rs.getString("bm_name"));
				BM.setBm_phone(rs.getInt("bm_phone"));
				BM.setBm_address(rs.getString("bm_address"));
				BM.setBm_age(rs.getInt("bm_age"));
				BM.setBm_email(rs.getString("bm_email"));
				BM.setBm_user_id(rs.getInt("user_id"));
				BM.setBm_branch_id(rs.getInt("branch_id"));
				branchMgr.add(BM);
			}
			// connection.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fetching account");
		}
		return branchMgr;
	}

	// prepared stsmt
	/*
	 * public List<AdminModel> getAccounts(int policy_id) { List<AdminModel>
	 * accounts = new ArrayList<>(); String query =
	 * "SELECT * FROM pc_policy1 where policy_id=?;";
	 * 
	 * try(PreparedStatement statement = connection.prepareStatement(query)){
	 * statement.setInt(1, policy_id); ResultSet resultSet =
	 * statement.executeQuery(); while(resultSet.next()) { AdminModel account = new
	 * AdminModel(); //grab record data by table field name into model object
	 * account.setPolicy_id(resultSet.getInt("policy_id"));
	 * System.out.println(resultSet.getInt("policy_id"));
	 * account.setPolicy_name(resultSet.getString("policy_name")); //add account
	 * data to arraylist System.out.println(resultSet.getString("policy_name"));
	 * account.setPolicy_type(resultSet.getString("policy_type"));
	 * account.setPolicy_amount(resultSet.getString("policy_amt"));
	 * account.setPolicy_duration(resultSet.getString("policy_duration"));
	 * account.setPolicy_desc(resultSet.getString("policy_desc"));
	 * accounts.add(account); //add data to the arraylist } } catch(SQLException e){
	 * System.out.println("Error fetching Accounts: " + e); } return accounts;
	 * //return arraylist }
	 */

	// insert policy to DB

	public boolean insertPolicyToDb(int pId, String pName, String pType, String pDuration, String pAmt, String pDesc) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO pc_policy2(policy_id,policy_name,policy_type,policy_duration ,policy_amt, policy_desc) values(?,?,? ,?, ?, ?);";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, pId);
			stmt.setString(2, pName);
			stmt.setString(3, pType);
			stmt.setString(4, pDuration);
			stmt.setString(5, pAmt);
			stmt.setString(6, pDesc);
			stmt.execute();
			System.out.println("Record inserted in policy details table");
			// connection.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error inserting policy : AdminModel Page");
		}
		return false;
	}

	// Delete policy from DB

	public boolean deletePolicyFromDB(int pId) {
		String sql = "Delete from PC_Policy2 where policy_id = ?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, pId);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to delete the policy:Admin Model");
		}
		return false;
	}

	// Insert Branch details to DB

	public boolean insertBranchToDB(int branchID, String branch_name, String branch_location) {
		try {
			String sql = "Insert into pc_branch2(branch_id,branch_name,branch_location)values (?,?,?);";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, branchID);
			stmt.setString(2, branch_name);
			stmt.setString(3, branch_location);
			stmt.execute();
			System.out.println("Record inserted in policy details table");
			// connection.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error inserting branch : AdminModel Page");
		}
		return false;
	}
	// Update Branch Manager Details

	public boolean updateBMDetails(int Bmid, int bm_id, String BmName, int BmPhone, String BmAddress, int BmAge,
			String BmEmail, int BmBranchId) {
		// TODO Auto-generated method stub
		try {
			String query = "Update PC_branch_manager2 SET bm_id =? ,bm_name =? , bm_phone=? ,bm_address=? ,bm_age=?, bm_email=? ,branch_id =? Where bm_id=?;";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, bm_id);
			stmt.setString(2, BmName);
			stmt.setInt(3, BmPhone);
			stmt.setString(4, BmAddress);
			stmt.setInt(5, BmAge);
			stmt.setString(6, BmEmail);
			stmt.setInt(7, BmBranchId);
			stmt.setInt(8, Bmid);
			stmt.execute();
			System.out.println("Record updated in branch table");
			// connection.close();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating Branch : Admin Model");
		}
		return false;

	}

	public List<AdminModel> getBranchManagerInfo(int bmId) {
		// TODO Auto-generated method stub
		List<AdminModel> branchMgr = new ArrayList<>();
		String query = "Select bm_id,bm_name,bm_phone,bm_address,bm_age,bm_email,branch_id from PC_branch_manager2 where bm_id=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, bmId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminModel BM = new AdminModel();
				BM.setBm_id(rs.getInt("bm_id"));
				BM.setBm_name(rs.getString("bm_name"));
				BM.setBm_phone(rs.getInt("bm_phone"));
				BM.setBm_address(rs.getString("bm_address"));
				BM.setBm_age(rs.getInt("bm_age"));
				BM.setBm_email(rs.getString("bm_email"));
				BM.setBm_branch_id(rs.getInt("branch_id"));
				branchMgr.add(BM);
			}
			// connection.close();
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fetching account");
		}
		return branchMgr;

	}

}
