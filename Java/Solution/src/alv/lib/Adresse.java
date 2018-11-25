package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import alv.data.AdresseDto;
import alv.data.msAccess.AdresseDAL;

public class Adresse extends AdresseDto {
	Connection conn;
	private AdresseDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private Adresse() {
		initConnection();
		dal = new AdresseDAL(conn);
	}

	private Adresse(int id) {

		initConnection();
		dal = new AdresseDAL(conn);
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

				conn = AdresseDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Adresse load(AdresseDto dto) {
		Adresse res = new Adresse();
		res.loadProperties(dto);
		return res;
	}

	public static Adresse load(int id) {
		return new Adresse(id);
	}

	public static Adresse create() {
		return new Adresse();
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
