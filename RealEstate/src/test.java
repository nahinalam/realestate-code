

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
//@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		System.out.println("helloooooooooooooooooooooooooooooooooooooooooooooooooooo ");
		Connection c = null;
	      Statement stmt = null;
	      String print = null; 
	      try {
	      Class.forName("org.postgresql.Driver");
	        c = DriverManager
	           .getConnection("jdbc:postgresql://localhost:5432/RealEstate",
	           "postgres", "password");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");

	        stmt = c.createStatement();
	        String query = "SELECT * FROM \"user\" ;";
	        ResultSet rs = stmt.executeQuery( query);
	        //System.out.println( rs);
	        while ( rs.next() ) {
	        	//Reader password = rs.getCharacterStream("password"); 
	           String id = rs.getString("id");
	           
	           System.out.println( "ID = " + id );
	           //System.out.println( "ID = " + password );
	        
	           System.out.println();
	           print = "here is the id " + id; 
	        }
	        rs.close();
	        stmt.close();
	        c.close();
	       
	        response.setContentType("text/html;charset=UTF-8");
	        request.setAttribute("id", print); 
	       // request.setAttribute("error",error );
          //response.sendRedirect(request.getContextPath()+"/Login.jsp");
          request.getRequestDispatcher("/index.jsp").forward(request, response);
	       // request.getRequestDispatcher("./SiteManagerAction.jsp").forward(request, response);
	       	        
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	        System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
