package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.VehiculesDAL;

public class Vehicules {

	Connection conn;
	private VehiculesDAL dal;
	private ArrayList<Vehicule> items = new ArrayList<Vehicule>();

	//CONSTRUCTOR
	private Vehicules() {
		initConnection();
		dal = new VehiculesDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Vehicule.load(item));});
	}
	
	//FACTORY METHODS
	public static Vehicules load() {
		return new Vehicules();
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
		
				conn = VehiculesDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vehicule> getItems() {
		return items;
	}

	public void setItems(ArrayList<Vehicule> items) {
		this.items = items;
	}

}
