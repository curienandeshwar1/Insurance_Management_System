package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.DBConnect;

public class loginModel extends DBConnect {
	
	private Boolean admin;
	
	public Boolean isAdmin() { 
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	
	public Boolean getCredentials(String username, String password ,String userType){
           
        	String query = "SELECT * FROM PC_user4 WHERE username = ? and password = ? and userType = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, username);
               stmt.setString(2, password);
               stmt.setString(3, userType);
               ResultSet rs = stmt.executeQuery();
               if(rs.next()) { 
            	setAdmin(rs.getBoolean("admin"));
               	return true;
               }
               stmt.close();
               
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
			return false;
    }
	
}
