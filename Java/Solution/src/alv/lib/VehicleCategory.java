package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.VehicleCategoryDto;
import alv.data.msAccess.VehicleCategoryDAL;

public class VehicleCategory extends VehicleCategoryDto {

	Connection conn;
	private VehicleCategoryDAL dal;

	// PROPERTIES

	// CONSTRUCTOR
	private VehicleCategory() {
		initConnection();
		dal = new VehicleCategoryDAL(conn);
	}

	private VehicleCategory(int id) {
		initConnection();
		dal = new VehicleCategoryDAL(conn);
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

				conn = VehicleCategoryDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of Personnes
	protected static VehicleCategory load(Map<String, Object> data) {
		VehicleCategory res = new VehicleCategory();
		res.loadProperties(data);
		
		return res;
	}
		
	protected static VehicleCategory load(VehicleCategoryDto dto) {
		VehicleCategory res = new VehicleCategory();
		res.loadProperties(dto);

		return res;
	}

	public static VehicleCategory load(int id) {
		return new VehicleCategory(id);
	}

	public static VehicleCategory create() {
		return new VehicleCategory();
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
