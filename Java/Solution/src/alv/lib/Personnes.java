package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.PersonnesDAL;

public class Personnes {

	Connection conn;
	private PersonnesDAL dal;
	private ArrayList<Personne> items = new ArrayList<Personne>();

	//CONSTRUCTOR
	private Personnes() {
		initConnection();
		dal = new PersonnesDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Personne.load(item));});
	}
	
	//FACTORY METHODS
	public static Personnes load() {
		return new Personnes();
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
		
				conn = PersonnesDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Personne> getItems() {
		return items;
	}

	public void setItems(ArrayList<Personne> items) {
		this.items = items;
	}

}
