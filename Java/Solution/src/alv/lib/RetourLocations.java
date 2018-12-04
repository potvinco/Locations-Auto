package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.RetourLocationsDAL;

public class RetourLocations {

	Connection conn;
	private RetourLocationsDAL dal;
	private ArrayList<RetourLocation> items = new ArrayList<RetourLocation>();

	//CONSTRUCTOR
	private RetourLocations() {
		initConnection();
		dal = new RetourLocationsDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(RetourLocation.load(item));});
	}
	
	//FACTORY METHODS
	public static RetourLocations load() {
		return new RetourLocations();
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
		
				conn = RetourLocationsDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<RetourLocation> getItems() {
		return items;
	}

	public void setItems(ArrayList<RetourLocation> items) {
		this.items = items;
	}

}
