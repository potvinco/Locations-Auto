package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.VehicleDescriptionDto;
import alv.data.msAccess.VehicleDescriptionDAL;

public class VehicleDescription extends VehicleDescriptionDto {

	Connection conn;
	private VehicleDescriptionDAL dal;

	//PROPERTIES
	
	// CONSTRUCTOR
	private VehicleDescription() {
		initConnection();
		dal = new VehicleDescriptionDAL(conn);

	}

	private VehicleDescription(int id) {
		initConnection();
		dal = new VehicleDescriptionDAL(conn);
		loadProperties(dal.fetch(id));
	}

	// METHODS
	private void initConnection() {
		try {
			if (conn == null) {
				String dbSettingsPropertyFile = "./properties/AppSettings.properties";
				Properties props = new Properties();

				FileReader fReader;
				fReader = new FileReader(dbSettingsPropertyFile);
				props.load(fReader);

				String driver = props.getProperty("db.driver.class");
				String msAccDB = props.getProperty("db.path");
				String dbURL = props.getProperty("db.conn.url") + msAccDB;

				conn = VehicleDescriptionDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of VehicleDescriptions
	protected static VehicleDescription load(Map<String, Object> data) {
		VehicleDescription res = new VehicleDescription();
		res.loadProperties(data);
		
		return res;
	}
		
	protected static VehicleDescription load(VehicleDescriptionDto dto) {
		VehicleDescription res = new VehicleDescription();
		res.loadProperties(dto);

		return res;
	}

	public static VehicleDescription load(int id) {
		return new VehicleDescription(id);
	}

	public static VehicleDescription create() {
		return new VehicleDescription();
	}

	public void save() {

		if(getId()==0) {
			int id = dal.insert(this);
			setId(id);
		}
		else
			dal.update(this);
	}

	public void delete() {
		int id = getId();

		if (id != 0) {

			if (dal.delete(id)) {
				setId(0);
			}
		}
	}
}
