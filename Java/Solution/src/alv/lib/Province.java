package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.ProvinceDto;
import alv.data.msAccess.ProvinceDAL;

public class Province extends ProvinceDto {
	Connection conn;
	private ProvinceDAL dal;

	// PROPERTIES
	
	// CONSTRUCTOR
	private Province() {
		initConnection();
		dal = new ProvinceDAL(conn);
	}

	private Province(int id) {

		initConnection();
		dal = new ProvinceDAL(conn);
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

				conn = ProvinceDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Province load(Map<String, Object> data) {
		Province res = new Province();
		res.loadProperties(data);

		return res;
	}
	
	public static Province load(ProvinceDto dto) {
		Province res = new Province();
		res.loadProperties(dto);
		return res;
	}

	public static Province load(int id) {
		return new Province(id);
	}

	public static Province create() {
		return new Province();
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
