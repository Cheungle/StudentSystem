package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TemDao {
	  private String URL = "jdbc:mysql://localhost:3306/studentsystem?serverTimezone=GMT&characterEncoding=utf8&useSSL=false";
	  //DB USER NAME
	  private String USER = "root";
	  //DB PASSWORD
	  private String PASSWORD = "AAAAAmi//";
	  private Connection conn;
	  private Statement stmt;
	  public TemDao() {
			try {
		          //1.������������
		    	  Class.forName("com.mysql.jdbc.Driver");
			      //2. ������ݿ�����
			      conn = DriverManager.getConnection(URL, USER, PASSWORD);
			      //3.�������ݿ⣬ʵ����ɾ�Ĳ�
			      stmt = conn.createStatement();
			      
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	  public Statement getStatement() {
	     return stmt;
	  }
	  public String getURL() {
		     return URL;
		  }
	  public String getUSER() {
		     return USER;
		  }
	  public String getPASSWORD() {
		     return PASSWORD;
		  }
}
