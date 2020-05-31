package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.DBConnect;

public class BrManagerModel extends DBConnect{
	
	int cust_id ,cust_age;
	String cust_name,cust_phone,cust_address,cust_gender,cust_email;
   
	public BrManagerModel() {} 
	
	/*public BrManagerModel(int cust_id,String cust_name,String cust_phone, String cust_address, int cust_age, String cust_gender, String cust_email) {
		this.cust_id =cust_id;
	    this.cust_name = cust_name;
	    this.cust_phone =cust_phone;
	    this.cust_address =cust_address;
	    this.cust_age=cust_age;
	    this.cust_gender=cust_gender;
	    this.cust_email= cust_email;		
	}*/

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_address() {
		return cust_address;
	}
	

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public int getCust_age() {
		return cust_age;
	}

	public void setCust_age(int cust_age) {
		this.cust_age = cust_age;
	}

	public String getCust_gender() {
		return cust_gender;
	}

	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	
	
	public List<BrManagerModel> getCustomers(){
		List<BrManagerModel> cust_list  = new ArrayList<>();
		String query = "SELECT * FROM pc_customer;";
		
		try {
			Statement stmt_br=connection.createStatement();
			ResultSet rs = stmt_br.executeQuery(query);			
			while(rs.next()) {
				BrManagerModel brm = new BrManagerModel();
				brm.setCust_id(rs.getInt("cust_id"));
				brm.setCust_name(rs.getString("cust_name"));
				brm.setCust_phone(rs.getString("cust_phone"));
				brm.setCust_address(rs.getString("cust_address"));
				brm.setCust_age(rs.getInt("cust_age"));
				brm.setCust_gender(rs.getString("cust_gender"));
				brm.setCust_email(rs.getString("cust_email"));
				
	             cust_list.add(brm);
			}
			//connection.close();
			rs.close();
			stmt_br.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error fetching Customers: " + e);
		}
		return cust_list;
		
	}
	
	public List<BrManagerModel> getCustomerInfo(int custId) {
		List<BrManagerModel> cust_info = new ArrayList<>();
		String query = "SELECT * FROM pc_customer where cust_id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, custId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				BrManagerModel brm = new BrManagerModel();
				// grab record data by table field name into model object
				brm.setCust_id(rs.getInt("cust_id"));
				brm.setCust_name(rs.getString("cust_name"));
				brm.setCust_phone(rs.getString("cust_phone"));
				brm.setCust_address(rs.getString("cust_address"));
				brm.setCust_age(rs.getInt("cust_age"));
				brm.setCust_gender(rs.getString("cust_gender"));
				brm.setCust_email(rs.getString("cust_email"));
				cust_info.add(brm);
			}
          //connection.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error fetching single Customer: " + e);
		}
		return cust_info;

	}

	public boolean deleteCust(int delCust) {
		String sql = "Delete from pc_customer where cust_id = ?;";
		try
		{
			PreparedStatement stmt =  connection.prepareStatement(sql);
			 stmt.setInt(1, delCust);
			 stmt.execute();
			 stmt.close();
			 return true;
			 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean updateCustDetails(int cust_id2, int cusId, String cusName, String cusPhone, String cusAddress,
			int cusAge, String cusGender, String cusEmail) {
		// TODO Auto-generated method stub
		try {
			String query =  "Update pc_customer SET cust_id =? ,cust_name =? , cust_phone=? ,cust_address=? ,cust_age=?, cust_gender=? ,cust_email=? Where cust_id=?;";
			PreparedStatement stmt =  connection.prepareStatement(query);
			stmt.setInt(1, cusId);
			stmt.setString(2, cusName);
			stmt.setString(3, cusPhone);
			stmt.setString(4, cusAddress);
			stmt.setInt(5, cusAge);
			stmt.setString(6, cusGender);
			stmt.setString(7, cusEmail);
			stmt.setInt(8, cust_id2);
			stmt.execute();
			System.out.println("Record updated in customer table");
			stmt.close();
			//connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error updating customer : Branch Manager Model");
		}
		return false;		
		
	}
	
}
