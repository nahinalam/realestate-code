import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
	        
	        
	       // request.getRequestDispatcher("./SiteManagerAction.jsp").forward(request, response);
	        
	        
	        
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	        System.exit(0);
	      }
	      System.out.println("Operation done successfully");

	}

}
