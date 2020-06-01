package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import beans.course;
import beans.courseinfor;
import beans.gradewithmore;
import beans.sc;
import beans.testinfor;

public class ScDao extends TemDao{
	private Statement stmt;
	public ScDao() {
		stmt=super.getStatement();
	}
	public List<sc> queryAll() throws SQLException {
		  String sql="select* from choosesc";
		  ResultSet rs = stmt.executeQuery(sql);
		  List<sc> scs = new ArrayList<>();
		  while(rs.next()) {
			  sc s = new sc(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getString(8));
			  scs.add(s);
		  }
		  rs.close();
		  return scs;
	}
	public double getAverageGPA(String id,String term) throws SQLException {
		String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		double average = 0.0;
		int credit=0;
		while(rs.next()) {
			average = rs.getInt("credit")*rs.getDouble("GPA")+average;
			credit = rs.getInt("credit")+credit;
		}
		rs.close();
		if(credit != 0)average = average/credit;
		else average = 0.0 ;
		return average;
	}
	public double getKindAverageGradeOfYear(String id,String year,String kind) throws SQLException {
		String sql="select* from choosesc,course where idstudent=" + id +" and term in ('" + year +" 1','" + year +" 2') and choosesc.idcourse=course.idcourse and kindcourse='" + kind +"'";
		ResultSet rs = stmt.executeQuery(sql);
		double average = 0.0;
		int credit=0;
		while(rs.next()) {
			average = rs.getInt("grade")*rs.getDouble("credit")+average;
			credit = rs.getInt("credit")+credit;
		}
		rs.close();
		if(credit != 0)average = average/credit;
		else average = 0.0 ;
		return average;
	}
    public List<course> getAllCourseOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		 List<course> cs = new ArrayList<>();
		  while(rs.next()) {
			  course c = new course(rs.getInt("idcourse"),rs.getString("namecourse"),rs.getString("classroom"),rs.getInt("credit"),rs.getInt("idteacher"),rs.getString("date"),rs.getString("starttime"),rs.getString("sumclass"));
			  cs.add(c);
		  }
		rs.close();
		return cs;
    }
    public List<course> getAllCourseOfOne(String id,String term,String day) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"'and date='" + day +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		 List<course> cs = new ArrayList<>();
		  while(rs.next()) {
			  course c = new course(rs.getInt("idcourse"),rs.getString("namecourse"),rs.getString("classroom"),rs.getInt("credit"),rs.getInt("idteacher"),rs.getString("date"),rs.getString("starttime"),rs.getString("sumclass"));
			  cs.add(c);
		  }
		rs.close();
		return cs;
    }
    public List<courseinfor> getAllCourseInforOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course,teacher where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse and course.idteacher=teacher.idteacher";
		ResultSet rs = stmt.executeQuery(sql);
		 List<courseinfor> cis = new ArrayList<>();
		  while(rs.next()) {
			  courseinfor ci = new courseinfor(rs.getString("nameteacher"),rs.getString("namecourse"),rs.getInt("credit"),rs.getString("classroom"),rs.getString("starttime"),rs.getString("sumclass"),rs.getString("date"));
			  cis.add(ci);
		  }
		rs.close();
		return cis;
    }
    public List<testinfor> getAllCourseTestOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		 List<testinfor> tis = new ArrayList<>();
		  while(rs.next()) {
			  testinfor ti = new testinfor(rs.getString("namecourse"),rs.getString("testtime"),rs.getString("testplace"));
			  tis.add(ti);
		  }
		rs.close();
		return tis;
    }
    public List<gradewithmore> getAllCourseGradeOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		 List<gradewithmore> gwms = new ArrayList<>();
		  while(rs.next()) {
			  gradewithmore gwm = new gradewithmore(rs.getString("namecourse"),rs.getInt("grade"),rs.getDouble("GPA"),rs.getInt("credit"));
			  gwms.add(gwm);
		  }
		rs.close();
		return gwms;
    }
    public int countAllCourseOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		  while(rs.next()) {
			  count++;
		  }
		rs.close();
		return count;
    }
    public int getAllCreditOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		int credit=0;
		while(rs.next()) {credit=credit+rs.getInt("credit");}
		rs.close();
		return credit;
    }
    public int getAllTermsCredit(String id) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		int credit=0;
		while(rs.next()) {credit=credit+rs.getInt("credit");}
		rs.close();
		return credit;
    }
    public int getBeforeCreditOfOne(String id,String term) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and term!='" + term +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		int credit=0;
		while(rs.next()) {credit=credit+rs.getInt("credit");}
		rs.close();
		return credit;
    }
    public int getCreditOfKind(String id,String kind) throws SQLException {
    	String sql="select* from choosesc,course where idstudent=" + id +" and kindcourse='" + kind +"' and choosesc.idcourse=course.idcourse";
		ResultSet rs = stmt.executeQuery(sql);
		int credit=0;
		while(rs.next()) {credit=credit+rs.getInt("credit");}
		rs.close();
		return credit;
    }
	public void add(String idstudent, String idcourse,String kindcourse,
			String grade, String GPA, String term) throws SQLException {
	    String sql  = "insert into choosesc values('"+idstudent+"','"+idcourse+"','"+kindcourse+"','"+grade+"','"+GPA+"','"+term+"')";
	    stmt.execute(sql);
	}
	public void delete(String idstudent,String idcourse) throws SQLException {
		String sql = "delete from choosesc where idstudent=" + idstudent +"and idcourse=" +idcourse;
		stmt.execute(sql);
	}
	public void update(String idstudent, String idcourse,String kindcourse,
			String grade, String GPA ,String term) throws SQLException {
		String sql = "update choosesc set idcourse='" + idcourse + "',kindcourse='" + kindcourse + "', grade='" + grade + "', GPA='" + GPA + "', term='" + term + "' where idstudent=" + idstudent;
		stmt.execute(sql);
	}
    
}
