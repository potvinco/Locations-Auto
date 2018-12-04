package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.VehicleDescriptionsDAL;

public class VehicleDescriptions {

	Connection conn;
	private VehicleDescriptionsDAL dal;
	private ArrayList<VehicleDescription> items = new ArrayList<VehicleDescription>();

	//CONSTRUCTOR
	private VehicleDescriptions() {
		initConnection();
		dal = new VehicleDescriptionsDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(VehicleDescription.load(item));});
	}
	
	//FACTORY METHODS
	public static VehicleDescriptions load() {
		return new VehicleDescriptions();
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
		
				conn = VehicleDescriptionsDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<VehicleDescription> getItems() {
		return items;
	}

	public void setItems(ArrayList<VehicleDescription> items) {
		this.items = items;
	}

}
