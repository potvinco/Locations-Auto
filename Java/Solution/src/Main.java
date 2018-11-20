import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import alv.data.msAccess.ReservationDAL;
import alv.data.msAccess.ReservationsDAL;

public class Main {

	public static void main(String[] args) {	   
	    Connection conn;
	    
	    
		try {

	    	File directory = new File("./");
	    	   System.out.println(directory.getAbsolutePath());
			
			
			String dbSettingsPropertyFile = "./properties/AppSettings.properties";
			// Create Properties object.
			Properties props = new Properties();
			
			FileReader fReader;
			fReader = new FileReader(dbSettingsPropertyFile);
			
			
			// Load jdbc related properties in above file. 
			props.load(fReader);

			String driver = props.getProperty("db.driver.class");
			// Get each property value.
			String msAccDB = props.getProperty("db.path");
			String dbURL = props.getProperty("db.conn.url") + msAccDB; 

			
			
			
			
			conn = ReservationsDAL.createConnection(driver, dbURL, null, null);
			ReservationsDAL res = new ReservationsDAL(conn);
			res.fetch();
			
			ReservationDAL singleRes = new ReservationDAL(conn);
			singleRes.fetch(1);
		
		
		
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}

}
