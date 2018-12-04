package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.ProvincesDAL;

public class Provinces {

	Connection conn;
	private ProvincesDAL dal;
	private ArrayList<Province> items = new ArrayList<Province>();

	//CONSTRUCTOR
	private Provinces() {
		initConnection();
		dal = new ProvincesDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Province.load(item));});
	}
	
	//FACTORY METHODS
	public static Provinces load() {
		return new Provinces();
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
		
				conn = ProvincesDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Province> getItems() {
		return items;
	}

	public void setItems(ArrayList<Province> items) {
		this.items = items;
	}

}
