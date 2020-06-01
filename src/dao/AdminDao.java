package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.admin;


public class AdminDao extends TemDao{
	private Statement stmt;
	public AdminDao() {
		stmt=super.getStatement();
	}
	public String count() throws SQLException {
    	String sql = "select count(*) from admin";
    	ResultSet rs = stmt.executeQuery(sql);
    	String c = "0";
    	while(rs.next()) {c=rs.getString(1);}
    	rs.close();
    	return c; 
    }
    public boolean login(String id ,String password) throws SQLException {
    	String sql = "select count(*) from admin where idadmin='" + id + "' and password='" + password +"'";
    	ResultSet rs = stmt.executeQuery(sql);
    	if(rs.next()) {
    	  if(rs.getInt(1) == 0) {rs.close();return false; }
    	  else {rs.close();return true;}
    	  }
    	else {rs.close();return false;}
    	
    }
}
