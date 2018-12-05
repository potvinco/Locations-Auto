package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.ClassePermisConduireDto;
import alv.data.msAccess.ClassePermisConduireDAL;

public class ClassePermisConduire extends ClassePermisConduireDto {
	Connection conn;
	private ClassePermisConduireDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private ClassePermisConduire() {
		initConnection();
		dal = new ClassePermisConduireDAL(conn);
	}

	private ClassePermisConduire(int id) {

		initConnection();
		dal = new ClassePermisConduireDAL(conn);
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

				conn = ClassePermisConduireDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static ClassePermisConduire load(Map<String, Object> data) {
		ClassePermisConduire res = new ClassePermisConduire();
		res.loadProperties(data);

		return res;
	}
	public static ClassePermisConduire load(ClassePermisConduireDto dto) {
		ClassePermisConduire res = new ClassePermisConduire();
		res.loadProperties(dto);
		return res;
	}

	public static ClassePermisConduire load(int id) {
		return new ClassePermisConduire(id);
	}

	public static ClassePermisConduire create() {
		return new ClassePermisConduire();
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
