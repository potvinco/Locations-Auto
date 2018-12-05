package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.CountryDto;
import alv.data.msAccess.CountryDAL;

public class Country extends CountryDto {
	Connection conn;
	private CountryDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private Country() {
		initConnection();
		dal = new CountryDAL(conn);
	}

	private Country(int id) {

		initConnection();
		dal = new CountryDAL(conn);
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

				conn = CountryDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static Country load(Map<String, Object> data) {
		Country res = new Country();
		res.loadProperties(data);

		return res;
	}
	public static Country load(CountryDto dto) {
		Country res = new Country();
		res.loadProperties(dto);
		return res;
	}

	public static Country load(int id) {
		return new Country(id);
	}

	public static Country create() {
		return new Country();
	}

	public void save() {
		if (getId() == 0) {
			int id = dal.insert(this);
			setId(id);
		} else
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
