package charley;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class CharleyServlet
 */
@WebServlet("/CharleyServlet")
public class CharleyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharleyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state = request.getParameter("state");
		
		if (state != null) {
			QueryBuilder query = new QueryBuilder();
			String sqlString = query.cityOrStateQuery("state", request.getParameter("state"));
			QueryHandler sentQuery = new QueryHandler();
			ResultSet results = sentQuery.processQuery(sqlString);
			List<List> resultList = sentQuery.convertResultsToList(results);
			
			request.setAttribute("results", resultList);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
