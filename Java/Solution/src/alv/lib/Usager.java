package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.UsagerDto;
import alv.data.msAccess.UsagerDAL;

public class Usager extends UsagerDto {
	Connection conn;
	private UsagerDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private Usager() {
		initConnection();
		dal = new UsagerDAL(conn);
	}

	private Usager(int id) {

		initConnection();
		dal = new UsagerDAL(conn);
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

				conn = UsagerDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static Usager load(Map<String, Object> data) {
		Usager res = new Usager();
		res.loadProperties(data);

		return res;
	}
	
	public static Usager load(UsagerDto dto) {
		Usager res = new Usager();
		res.loadProperties(dto);
		return res;
	}

	public static Usager load(int id) {
		return new Usager(id);
	}

	public static Usager create() {
		return new Usager();
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
