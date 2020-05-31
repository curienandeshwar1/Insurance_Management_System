package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Dao.DBConnect;

public class customerModel extends DBConnect {
	
	int cust_id, age, phone;
	String regName, policyType, policyDuration, policyAmt, nomiName, nomiRelation;
	
	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyDuration() {
		return policyDuration;
	}

	public void setPolicyDuration(String policyDuration) {
		this.policyDuration = policyDuration;
	}

	public String getPolicyAmt() {
		return policyAmt;
	}

	public void setPolicyAmt(String policyAmt) {
		this.policyAmt = policyAmt;
	}

	public String getNomiName() {
		return nomiName;
	}

	public void setNomiName(String nomiName) {
		this.nomiName = nomiName;
	}

	public String getNomiRelation() {
		return nomiRelation;
	}

	public void setNomiRelation(String nomiRelation) {
		this.nomiRelation = nomiRelation;
	}

	
	// Inserting into home policy registration table
	public String insertPolicyRegForHome(int cusId, String regName2, int regAge1, int regphone1,
			String comboHomeType, String comboPolicyDuration, String amountToPay, int assetvalue1, int homevalue1, String nomName, String nomRelation) {
		// TODO Auto-generated method stub
		String id= null;
		try {			
			String query =  "insert into pc_homePolicyReg4(cust_id, reg_name, reg_age, reg_phone,reg_house_type, reg_policy_duration , reg_policy_amt, reg_asset_value , reg_value_home , reg_nomi_name , reg_nomi_relation)" + 
					"values(?,? ,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt=null;
			stmt =  connection.prepareStatement(query, stmt.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cusId);
			stmt.setString(2, regName2);
			stmt.setInt(3, regAge1);
			stmt.setInt(4, regphone1);
			stmt.setString(5, comboHomeType);
			stmt.setString(6, comboPolicyDuration);
			stmt.setString(7, amountToPay);
			stmt.setInt(8, assetvalue1);
			stmt.setInt(9, homevalue1);
			stmt.setString(10, nomName);
			stmt.setString(11, nomRelation);
			stmt.execute();
			
            ResultSet rs=stmt.getGeneratedKeys(); // to get policy id           
            if(rs.next()){
                int policy_id=rs.getInt(1);
                 id =  Integer.toString(policy_id);
                System.out.println("Policy is is : " + id);
            }
			System.out.println("Record inserted in home policy table");
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error inserting policy : AdminModel Page");
		}
		return id;
	}
 
	//to get amount paid for policy
	public String getAmountPaid(String policy_type, String policy_duration) {
		String amt = null;
		try {
			String sql = "Select policy_amt from pc_policycombination where policy_type = ? and policy_duration = ?;" ;
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, policy_type);
			ps.setString(2, policy_duration);			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				amt = rs.getString(1);
				System.out.println("Amount to be paid is: " +amt);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return amt;
	}

	
	//insert method for health policy
	public String insertPolicyRegForHealth(int cusId, String healName, int healAge1, int healphone1,
			String comboHealthType, String comboHealPolDuration, String amttoPay, String medIssues, String otherIssues,
			String nomName, String nomRelation) throws SQLException{
		// TODO Auto-generated method stub
		String id= null;
		try {			
			String query =  "insert into pc_healthPolicyReg4(cust_id, reg_name_health, reg_age_health, reg_phone_health,health_plan_type, health_policy_duration , health_policy_amt, medical_issue , other_medical_issue , health_nomi_name , health_nomi_relation)" + 
					" values(?,? ,?,?,?,?,?,?,?,?,?);";
			PreparedStatement stmt=null;
			stmt =  connection.prepareStatement(query, stmt.RETURN_GENERATED_KEYS);
			stmt.setInt(1, cusId);
			stmt.setString(2, healName);
			stmt.setInt(3, healAge1);
			stmt.setInt(4, healphone1);
			stmt.setString(5, comboHealthType);
			stmt.setString(6, comboHealPolDuration);
			stmt.setString(7, amttoPay);
			stmt.setString(8, medIssues);
			stmt.setString(9, otherIssues);
			stmt.setString(10, nomName);
			stmt.setString(11, nomRelation);
			stmt.execute();
			
            ResultSet rs=stmt.getGeneratedKeys(); // to get policy id           
            if(rs.next()){
                int policy_id=rs.getInt(1);
                 id =  Integer.toString(policy_id);
                System.out.println("Policy is is : " + id);
            }
			System.out.println("Record inserted in home policy table");
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error inserting policy : customerController Page");
		}
		return id;
	}
  
	//to get health policy details
	public List<customerModel> getHealthPolicyDetailsFromDb(int polId) {
		List<customerModel> pol_info = new ArrayList<>();
		String query = "SELECT cust_id, reg_name_health , reg_age_health,reg_phone_health, health_plan_type,health_policy_duration,health_policy_amt,health_nomi_name , health_nomi_relation FROM pc_healthPolicyReg4 where health_policy_reg_id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, polId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				customerModel cm = new customerModel();
				cm.setCust_id(rs.getInt("cust_id"));
				cm.setRegName(rs.getString("reg_name_health"));
				cm.setAge(rs.getInt("reg_age_health"));
				cm.setPhone(rs.getInt("reg_phone_health"));
				cm.setPolicyType(rs.getString("health_plan_type"));
				cm.setPolicyDuration(rs.getString("health_policy_duration"));
				cm.setPolicyAmt(rs.getString("health_policy_amt"));
				cm.setNomiName(rs.getString("health_nomi_name"));
				cm.setNomiRelation(rs.getString("health_nomi_relation"));
				pol_info.add(cm);
			}
          //connection.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error fetching policy details : customer model " + e);
		}
		return pol_info;

	}
	
	//to get home policy details according to policy id
	public List<customerModel> getHomePolicyDetailsFromDb(int polId) {
		List<customerModel> pol_info = new ArrayList<>();
		String query = "SELECT cust_id, reg_name , reg_age, reg_phone, reg_house_type,reg_policy_duration,reg_policy_amt,reg_nomi_name , reg_nomi_relation FROM pc_homePolicyReg4 where home_policy_reg_id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, polId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				customerModel cm = new customerModel();
				cm.setCust_id(rs.getInt("cust_id"));
				cm.setRegName(rs.getString("reg_name"));
				cm.setAge(rs.getInt("reg_age"));
				cm.setPhone(rs.getInt("reg_phone"));
				cm.setPolicyType(rs.getString("reg_house_type"));
				cm.setPolicyDuration(rs.getString("reg_policy_duration"));
				cm.setPolicyAmt(rs.getString("reg_policy_amt"));
				cm.setNomiName(rs.getString("reg_nomi_name"));
				cm.setNomiRelation(rs.getString("reg_nomi_relation"));
				pol_info.add(cm);
			}
          //connection.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error fetching policy details : customer model " + e);
		}
		return pol_info;

	}

		

} 
