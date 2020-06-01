package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import beans.teacher;

public class TeacherDao extends TemDao{
	private Statement stmt;
	public TeacherDao() {
		stmt=super.getStatement();
	}
	public List<teacher> queryAll() throws SQLException {
		  String sql="select* from teacher";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<teacher> teachers = new ArrayList<>();
		  while(rs.next()) {
			  teacher tc = new teacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			  teachers.add(tc);
		  }
		  rs.close();
		  return teachers;
	}
	public List<teacher> findTeacherOfAcademy(String academy) throws SQLException {
		  String sql="select* from teacher where academy='"+academy+"'";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<teacher> teachers = new ArrayList<>();
		  while(rs.next()) {
			  teacher tc = new teacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			  teachers.add(tc);
		  }
		  rs.close();
		  return teachers;
	}
	public teacher select(String id) throws SQLException {
		String sql = "select* from teacher where idteacher=" + id;
    	ResultSet rs = stmt.executeQuery(sql);
    	 if(rs.next()) {
    		 teacher s = new teacher(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
    		 rs.close();
			  return s;
    	 }
    	 else { rs.close();return null;}
	}
    public String count() throws SQLException {
    	String sql = "select count(*) from teacher";
    	ResultSet rs = stmt.executeQuery(sql);
    	String count = "0";
    	while(rs.next()) {count = rs.getString(1);}
    	rs.close();
    	return count; 
    }
   
	public void add(String id,String name, String office, String academy) throws SQLException {
	    String sql  = "insert into teacher values('"+id+"','"+name+"','"+office+"','"+academy+"')";
	    stmt.execute(sql);
	}
	
	public void delete(String id) throws SQLException {
		String sql = "delete from teacher where idteacher=" + id;
		stmt.execute(sql);
	}
	public void update(String id,String name, String office,String academy) throws SQLException {
		String sql = "update teacher set nameteacher='" + name + "', office='" + office + "', academy='" + academy + "' where idteacher=" + id;
		stmt.execute(sql);
	}
	public void update(String id,String name, String office) throws SQLException {
		String sql = "update teacher set nameteacher='" + name + "', office='" + office + "' where idteacher=" + id;
		stmt.execute(sql);
	}

}