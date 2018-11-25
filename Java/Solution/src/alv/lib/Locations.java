package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.LocationsDAL;

public class Locations {

	Connection conn;
	private LocationsDAL dal;
	private ArrayList<Location> items = new ArrayList<Location>();

	//CONSTRUCTOR
	private Locations() {
		initConnection();
		dal = new LocationsDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Location.load(item));});
	}
	
	//FACTORY METHODS
	public static Locations load() {
		return new Locations();
	}

	//METHODS
	private void initConnection() {
		try {
			if(conn == null) {
				String dbSettingsPropertyFile = "./properties/AppSettings.properties";
				Properties props = new Properties();
		
				FileReader fReader;
				fReader = new FileReader(dbSettingsPropertyFile);
				props.load(fReader);
		
				String driver = props.getProperty("db.driver.class");
				String msAccDB = props.getProperty("db.path");
				String dbURL = props.getProperty("db.conn.url") + msAccDB;
		
				conn = LocationsDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Location> getItems() {
		return items;
	}

	public void setItems(ArrayList<Location> items) {
		this.items = items;
	}

}
