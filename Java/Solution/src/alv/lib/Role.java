package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.RoleDto;
import alv.data.msAccess.RoleDAL;

public class Role extends RoleDto {
	Connection conn;
	private RoleDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private Role() {
		initConnection();
		dal = new RoleDAL(conn);
	}

	private Role(int id) {

		initConnection();
		dal = new RoleDAL(conn);
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

				conn = RoleDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static Role load(Map<String, Object> data) {
		Role res = new Role();
		res.loadProperties(data);

		return res;
	}
	
	public static Role load(RoleDto dto) {
		Role res = new Role();
		res.loadProperties(dto);
		return res;
	}

	public static Role load(int id) {
		return new Role(id);
	}

	public static Role create() {
		return new Role();
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
