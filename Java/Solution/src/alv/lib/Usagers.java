package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.UsagersDAL;

public class Usagers {

	Connection conn;
	private UsagersDAL dal;
	private ArrayList<Usager> items = new ArrayList<Usager>();

	//CONSTRUCTOR
	private Usagers() {
		initConnection();
		dal = new UsagersDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Usager.load(item));});
	}
	
	//FACTORY METHODS
	public static Usagers load() {
		return new Usagers();
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
		
				conn = UsagersDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usager> getItems() {
		return items;
	}

//	public void setItems(ArrayList<Usager> items) {
//		this.items = items;
//	}

}
