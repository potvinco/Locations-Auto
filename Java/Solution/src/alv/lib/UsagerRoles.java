package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.UsagerRolesDAL;

public class UsagerRoles {

	Connection conn;
	private UsagerRolesDAL dal;
	private ArrayList<UsagerRole> items = new ArrayList<UsagerRole>();

	//CONSTRUCTOR
	private UsagerRoles(int id) {
		initConnection();
		dal = new UsagerRolesDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch(id);
		map.forEach(item -> {items.add(UsagerRole.load(item));});
	}
	
	//FACTORY METHODS
	public static UsagerRoles load(int usagerId) {
		return new UsagerRoles(usagerId);
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
		
				conn = UsagerRolesDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<UsagerRole> getItems() {
		return items;
	}
}
