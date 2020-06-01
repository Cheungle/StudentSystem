package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.course;
import beans.notice;

public class NoticeDao extends TemDao{
	private Statement stmt;
	public NoticeDao() {
		stmt=super.getStatement();
	}
	public List<notice> queryAll() throws SQLException {
		  String sql="select* from notice order by pubdate DESC";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<notice> notices = new ArrayList<>();
		  while(rs.next()) {
			  notice n = new notice(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			  notices.add(n);
		  }
		  rs.close();
		  return notices;
	}
	public notice select(String id) throws SQLException {
		String sql = "select* from notice where idnotice=" + id;
		ResultSet rs = stmt.executeQuery(sql);
		notice nt = new notice();
		  while(rs.next()) {
			  nt = new notice(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)); 
		  }
		  rs.close();
		  return nt;
	}
	public String count() throws SQLException {
    	String sql = "select count(*) from notice";
    	ResultSet rs = stmt.executeQuery(sql);
    	String count = "0";
    	while(rs.next())count = rs.getString(1);
    	rs.close();
    	return count; 
    }
	public void add(String id,String name, String classroom,String credit,String teacher,String date,
	   String starttime,String sumclass) throws SQLException {
	    String sql  = "insert into notice values('"+id+"','"+name+"','"+classroom+"','"+credit+"','','"+teacher+"','"+date+"','"+starttime+"','"+sumclass+"')";
	    stmt.execute(sql);
	}
	public void delete(String id) throws SQLException {
		String sql = "delete from notice where idnotice=" + id;
		stmt.execute(sql);
	}
	public void update(String id,String name, String classroom,String credit,String teacher,String date,
			   String starttime,String sumclass) throws SQLException {
		String sql = "update notice set namestudent='" + name + "'classroom='" + classroom + "', credit=" + credit + ", teacher='" + teacher + "', date='" + date + "', starttime='" + starttime + "', sumclass='" + sumclass + "' where idnotice=" + id;
		stmt.execute(sql);
	}
}
