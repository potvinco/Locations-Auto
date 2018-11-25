package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.VehiculeDto;
import alv.data.msAccess.VehiculeDAL;

public class Vehicule {

	private VehiculeDto _dto = new VehiculeDto();
//	private Adresse _adresse;
	Connection conn;
	private VehiculeDAL dal;

	//PROPERTIES
	public VehiculeDto getDto() {return _dto;}
	private void setDto(VehiculeDto dto) {_dto = dto;}

//	public Adresse getAdresse() {return _adresse;}
//	private void setAdresse(Adresse adresse) {_adresse = adresse;}
	
	// CONSTRUCTOR
	private Vehicule() {
		initConnection();
		dal = new VehiculeDAL(conn);
		
//		_adresse = Adresse.create();
	}

	private Vehicule(int id) {
		initConnection();
		dal = new VehiculeDAL(conn);
		_dto = dal.fetch(id);
		
//		setAdresse(Adresse.load(_dto.getAdresseId()));
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
		res.getDto().loadProperties(data);
		
		return res;
	}
		
	protected static Vehicule load(VehiculeDto dto) {
		Vehicule res = new Vehicule();
		res.setDto(dto);

		return res;
	}

	public static Vehicule load(int id) {
		return new Vehicule(id);
	}

	public static Vehicule create() {
		return new Vehicule();
	}

	public void save() {

//		if(getAdresse()!=null) {
//			getAdresse().save();
//			_dto.setAdresseId(getAdresse().getDto().getId());
//		}
		if(_dto.getId()==0) {
			int id = dal.insert(_dto);
			_dto.setId(id);
		}
		else
			dal.update(_dto);
	}

	public void delete() {
		int id = _dto.getId();

		if (id != 0) {

			if (dal.delete(id)) {
				_dto.setId(0);
//				getAdresse().delete();
			}
		}
	}
}
