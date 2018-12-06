package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.ReservationsDAL;

public class Reservations {

	Connection conn;
	private ReservationsDAL dal;
	private ArrayList<Reservation> items = new ArrayList<Reservation>();

	//CONSTRUCTOR
	private Reservations() {
		initConnection();
		dal = new ReservationsDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {items.add(Reservation.load(item));});
	}
	
	private Reservations(Vehicule vehicule) {
		initConnection();
		dal = new ReservationsDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch();
		map.forEach(item -> {
			int val = ((int)item.get("VEHICULEID"));
			if(val == vehicule.getId())
				items.add(Reservation.load(item));
			});
	}
	
	//FACTORY METHODS
	public static Reservations load() {
		return new Reservations();
	}
	
	public static Reservations load(Vehicule vehicule) {
		return new Reservations(vehicule);
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
		
				conn = ReservationsDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reservation> getItems() {
		return items;
	}

//	private void setItems(ArrayList<Reservation> items) {
//		this.items = items;
//	}

}
