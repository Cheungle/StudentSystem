package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import beans.course;

public class CourseDao extends TemDao{
	private Statement stmt;
	public CourseDao() {
		stmt=super.getStatement();
	}
	public List<course> queryAll() throws SQLException {
		  String sql="select* from course";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<course> courses = new ArrayList<>();
		  while(rs.next()) {
			  course s = new course(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
			  courses.add(s);
		  }
		  rs.close();
		  return courses;
	}
	public String count() throws SQLException {
    	String sql = "select count(*) from course";
    	ResultSet rs = stmt.executeQuery(sql);
    	String count = "0";
    	while(rs.next())count = rs.getString(1);
    	rs.close();
    	return count; 
    }
	public void add(String id,String name, String classroom,String credit,String teacher,String date,
	   String starttime,String sumclass) throws SQLException {
	    String sql  = "insert into course values('"+id+"','"+name+"','"+classroom+"','"+credit+"','','"+teacher+"','"+date+"','"+starttime+"','"+sumclass+"')";
	    stmt.execute(sql);
	}
	public void delete(String id) throws SQLException {
		String sql = "delete from course where idcourse=" + id;
		stmt.execute(sql);
	}
	public void update(String id,String name, String classroom,String credit,String teacher,String date,
			   String starttime,String sumclass) throws SQLException {
		String sql = "update course set namestudent='" + name + "'classroom='" + classroom + "', credit=" + credit + ", teacher='" + teacher + "', date='" + date + "', starttime='" + starttime + "', sumclass='" + sumclass + "' where idcourse=" + id;
		stmt.execute(sql);
	}
    
}
