package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import alv.data.PermisConduireDto;
import alv.data.msAccess.PermisConduireDAL;

public class PermisConduire extends PermisConduireDto {
	Connection conn;
	private PermisConduireDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private PermisConduire() {
		initConnection();
		dal = new PermisConduireDAL(conn);
	}

	private PermisConduire(int id) {

		initConnection();
		dal = new PermisConduireDAL(conn);
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

				conn = PermisConduireDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PermisConduire load(PermisConduireDto dto) {
		PermisConduire res = new PermisConduire();
		res.loadProperties(dto);
		return res;
	}

	public static PermisConduire load(int id) {
		return new PermisConduire(id);
	}

	public static PermisConduire create() {
		return new PermisConduire();
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
