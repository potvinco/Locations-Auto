package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.CountriesDAL;

public class Countries {

	Connection conn;
	private CountriesDAL dal;
	private ArrayList<Country> items = new ArrayList<Country>();

	//CONSTRUCTOR
	private Countries() {
		initConnection();
		dal = new CountriesDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Country.load(item));});
	}
	
	//FACTORY METHODS
	public static Countries load() {
		return new Countries();
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
		
				conn = CountriesDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Country> getItems() {
		return items;
	}

	public void setItems(ArrayList<Country> items) {
		this.items = items;
	}

}
