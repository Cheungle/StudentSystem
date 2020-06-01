package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;

/**
 * Servlet implementation class update
 */
@WebServlet(name = "Update", urlPatterns= {"/Update"})
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao sd = new StudentDao() ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id = request.getParameter("id");
	     String name = request.getParameter("name");
	      String classstudent = request.getParameter("classstudent");
	      String major = request.getParameter("major");
	      String academy = request.getParameter("academy");
	      String photo = request.getParameter("photo");
	      try {
	    	if(photo != "")sd.update(id,name,classstudent,major,academy,photo);
	    	else sd.update(id,name,classstudent,major,academy);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	  }
	}

