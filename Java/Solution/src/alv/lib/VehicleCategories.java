package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.VehicleCategoriesDAL;

public class VehicleCategories {

	Connection conn;
	private VehicleCategoriesDAL dal;
	private ArrayList<VehicleCategory> items = new ArrayList<VehicleCategory>();

	//CONSTRUCTOR
	private VehicleCategories() {
		initConnection();
		dal = new VehicleCategoriesDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(VehicleCategory.load(item));});
	}
	
	//FACTORY METHODS
	public static VehicleCategories load() {
		return new VehicleCategories();
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
		
				conn = VehicleCategoriesDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<VehicleCategory> getItems() {
		return items;
	}

	public void setItems(ArrayList<VehicleCategory> items) {
		this.items = items;
	}

}
