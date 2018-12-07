package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.VehicleReservationsDAL;

public class VehicleReservations {

	Connection conn;
	private VehicleReservationsDAL dal;
	private ArrayList<Reservation> items = new ArrayList<Reservation>();

	//CONSTRUCTOR
	private VehicleReservations(int id) {
		initConnection();
		dal = new VehicleReservationsDAL(conn);
		ArrayList<Map<String, Object>> map = (ArrayList<Map<String, Object>>) dal.fetch(id);
		map.forEach(item -> {items.add(Reservation.load(item));});
	}
	
	//FACTORY METHODS
	public static VehicleReservations load(int id) {
		return new VehicleReservations(id);
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
		
				conn = VehicleReservationsDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reservation> getItems() {
		return items;
	}
}
