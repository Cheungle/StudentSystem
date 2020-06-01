package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import beans.student;

public class StudentDao extends TemDao{
	private Statement stmt;
	public StudentDao() {
		stmt=super.getStatement();
	}
	public List<student> queryAll() throws SQLException {
		  String sql="select* from student";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<student> students = new ArrayList<>();
		  while(rs.next()) {
			  student s = new student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			  students.add(s);
		  }
		  rs.close();
		  return students;
	}
	public List<student> findStudentOfMajor(String major) throws SQLException {
		  String sql="select* from student where major='" + major +"'";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<student> students = new ArrayList<>();
		  while(rs.next()) {
			  student s = new student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			  students.add(s);
		  }
		  rs.close();
		  return students;
	}
	public List<student> OrderStudentOfAcademy(String academy) throws SQLException {
		  String sql="select* from student where academy='"+ academy +"' order by major";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<student> students = new ArrayList<>();
		  while(rs.next()) {
			  student s = new student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			  students.add(s);
		  }
		  rs.close();
		  return students;
	}
	public List<Integer> CountStudentOfMajor(String academy) throws SQLException {
		  String sql="select major,count(idstudent) from student where academy='"+ academy +"' group by major";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<Integer> mps = new ArrayList<>();
		  while(rs.next()) {
			  Integer mp = new Integer(rs.getInt(2));
			  mps.add(mp);
		  }
		  rs.close();
		  return mps;
	}
	public student select(String id) throws SQLException {
		String sql = "select* from student where idstudent=" + id;
    	ResultSet rs = stmt.executeQuery(sql);
    	 if(rs.next()) {
			  student s = new student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			  rs.close();
			  return s;
    	 }
    	 
    	 else {rs.close();return null;}
	}
    public String count() throws SQLException {
    	String sql = "select count(*) from student";
    	ResultSet rs = stmt.executeQuery(sql);
    	String count = "0";
    	while(rs.next()) {count = rs.getString(1);}
    	rs.close();
    	return count; 
    }
    public boolean login(String id ,String password) throws SQLException {
    	if(password.equals(id)) {
    	String sql = "select count(*) from student where idstudent=" + id ;
    	ResultSet rs = stmt.executeQuery(sql);
    	if(rs.next()) {
    	if(rs.getInt(1) == 0) {rs.close();return false; }
    	 else {rs.close();return true;}
    	}
    	else {rs.close();return false;}
    }
    	else return false;
    	}
	public void add(String id,String name, String classstudent, String major,String academy,String photo) throws SQLException {
	    String sql  = "insert into student values('"+id+"','"+name+"','"+classstudent+"','"+major+"','"+academy+"','"+photo+"')";
	    stmt.execute(sql);
	}
	public void add(String id,String name, String classstudent, String major,String academy) throws SQLException {
	    String sql  = "insert into student values('"+id+"','"+name+"','"+classstudent+"','"+major+"','"+academy+"',null)";
	    stmt.execute(sql);
	}
	public void delete(String id) throws SQLException {
		String sql = "delete from student where idstudent=" + id;
		stmt.execute(sql);
	}
	public void update(String id,String name, String classstudent, String major,String academy,String photo) throws SQLException {
		String sql = "update student set namestudent='" + name + "',class='" + classstudent + "', major='" + major + "', academy='" + academy + "', photo='" + photo + "' where idstudent=" + id;
		stmt.execute(sql);
	}
	public void update(String id,String name, String classstudent, String major,String academy) throws SQLException {
		String sql = "update student set namestudent='" + name + "',class='" + classstudent + "', major='" + major + "', academy='" + academy + "' where idstudent=" + id;
		stmt.execute(sql);
	}
    
}
