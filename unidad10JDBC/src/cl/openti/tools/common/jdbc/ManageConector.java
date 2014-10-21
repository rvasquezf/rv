package cl.openti.tools.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageConector {


	public ManageConector() {
	
		try{
			// Driver 
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ManageConector conector = new ManageConector();  // Va a cargar Driver
		Connection con = null;
		Statement st;
		ResultSet rs;
		
		try{
		
		   con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","admin");
		   
		   st = con.createStatement();
		   
		   rs = st.executeQuery("SELECT nombre,apellido,direccion FROM EMPLOYEE");
		   
		   while(rs.next())
		   {
			   System.out.printf("%s %s %s", rs.getString(1),rs.getString(2),rs.getString(3));
		   }
		      
		   
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
			try {
				
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
