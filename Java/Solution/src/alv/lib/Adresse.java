package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import alv.data.AdresseDto;
import alv.data.PersonneDto;
import alv.data.msAccess.AdresseDAL;
import alv.data.msAccess.PersonneDAL;

public class Adresse {

	private AdresseDto _dto = new AdresseDto();
	Connection conn;
	private AdresseDAL dal;

	//PROPERTIES
	public AdresseDto getDto() {
		return _dto;
	}
	private void setDto(AdresseDto dto) { _dto = dto; }
	
	// CONSTRUCTOR
	private Adresse() {
		initConnection();
		dal = new AdresseDAL(conn);
	}
	
	private Adresse(int id) {

		initConnection();
		dal = new AdresseDAL(conn);
		_dto = dal.fetch(id);	
	}

	// METHODS	
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
		
				conn = PersonneDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Adresse load(AdresseDto dto) {
		Adresse res = new Adresse();
		res.setDto(dto);
		return res;
	}
	
	public static Adresse load(int id)
	{
		return new Adresse(id);
	}
	
	public static Adresse create() {
		return new Adresse();
	}
	
	public void save() {
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
			}
		}
	}
}
