package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.FicheInspectionDto;
import alv.data.msAccess.FicheInspectionDAL;

public class FicheInspection extends FicheInspectionDto {

	//private FicheInspectionDto _dto = new FicheInspectionDto();
	Connection conn;
	private FicheInspectionDAL dal;

	//PROPERTIES
//	public FicheInspectionDto getDto() {return _dto;}
//	private void setDto(FicheInspectionDto dto) {_dto = dto;}
	
	@Override
	public void setVehiculeId(int id) {
		//if id is different, the inspection should become invalid --> new?
	}
	
	// CONSTRUCTOR
	private FicheInspection() {
		initConnection();
		dal = new FicheInspectionDAL(conn);
	}

	private FicheInspection(int id) {
		initConnection();
		dal = new FicheInspectionDAL(conn);
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

				conn = FicheInspectionDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of FicheInspections
	protected static FicheInspection load(Map<String, Object> data) {
		FicheInspection res = new FicheInspection();
		res.loadProperties(data);
		
		return res;
	}
		
	protected static FicheInspection load(FicheInspectionDto dto) {
		FicheInspection res = new FicheInspection();
		res.loadProperties(dto);

		return res;
	}

	public static FicheInspection load(int id) {
		return new FicheInspection(id);
	}

	public static FicheInspection create() {
		return new FicheInspection();
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
