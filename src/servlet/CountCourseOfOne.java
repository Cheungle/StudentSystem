package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScDao;

/**
 * Servlet implementation class CountCourseOfOne
 */
@WebServlet(name="/CountCourseOfOne",urlPatterns= {"/CountCourseOfOne"})
public class CountCourseOfOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScDao scd = new ScDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountCourseOfOne() {
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
		String term = request.getParameter("term");
		try {
			int count = scd.countAllCourseOfOne(id, term);
			PrintWriter out = response.getWriter();
			out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
