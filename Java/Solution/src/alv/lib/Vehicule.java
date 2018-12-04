package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.VehiculeDto;
import alv.data.msAccess.VehiculeDAL;

public class Vehicule extends VehiculeDto {

	Connection conn;
	private VehiculeDAL dal;
	private VehicleDescription _vehicleDescription;

	//PROPERTIES
	
	@Override
	public void setDescriptionId(int id) {
		_descriptionId = id;
		setVehicleDescription(VehicleDescription.load(id));
	}
	
	// CONSTRUCTOR
	private Vehicule() {
		initConnection();
		dal = new VehiculeDAL(conn);
	}

	private Vehicule(int id) {
		initConnection();
		dal = new VehiculeDAL(conn);
		loadProperties(dal.fetch(id));
	}

	public VehicleDescription getVehicleDescription() {
		return _vehicleDescription;
	}

	private void setVehicleDescription(VehicleDescription _vehicleDescription) {
		this._vehicleDescription = _vehicleDescription;
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

				conn = VehiculeDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of Vehicules
	public static Vehicule load(Map<String, Object> data) {
		Vehicule res = new Vehicule();
		res.loadProperties(data);
		
		return res;
	}
		
	protected static Vehicule load(VehiculeDto dto) {
		Vehicule res = new Vehicule();
		res.loadProperties(dto);

		return res;
	}

	public static Vehicule load(int id) {
		return new Vehicule(id);
	}

	public static Vehicule create() {
		return new Vehicule();
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
