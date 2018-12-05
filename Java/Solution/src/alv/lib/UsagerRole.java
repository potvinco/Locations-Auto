package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.UsagerRoleDto;
import alv.data.msAccess.UsagerRoleDAL;

public class UsagerRole extends UsagerRoleDto {
	Connection conn;
	private UsagerRoleDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private UsagerRole() {
		initConnection();
		dal = new UsagerRoleDAL(conn);
	}

	private UsagerRole(int id) {

		initConnection();
		dal = new UsagerRoleDAL(conn);
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

				conn = UsagerRoleDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static UsagerRole load(Map<String, Object> data) {
		UsagerRole res = new UsagerRole();
		res.loadProperties(data);

		return res;
	}
	
	public static UsagerRole load(UsagerRoleDto dto) {
		UsagerRole res = new UsagerRole();
		res.loadProperties(dto);
		return res;
	}

	public static UsagerRole load(int id) {
		return new UsagerRole(id);
	}

	public static UsagerRole create() {
		return new UsagerRole();
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
