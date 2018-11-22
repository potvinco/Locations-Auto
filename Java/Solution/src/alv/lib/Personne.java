package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import alv.data.PersonneDto;
import alv.data.msAccess.PersonneDAL;

public class Personne {

	private PersonneDto _dto = new PersonneDto();
	Connection conn;
	private PersonneDAL dal;

	// CONSTRUCTOR
	private Personne() {
		initConnection();
		dal = new PersonneDAL(conn);
	}

	private Personne(int id) {
		initConnection();
		dal = new PersonneDAL(conn);
		_dto = dal.fetch(id);
	}

	public PersonneDto getDto() {
		return _dto;
	}

	private void setDto(PersonneDto dto) {
		_dto = dto;
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

				conn = PersonneDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected static Personne load(PersonneDto dto) {
		Personne res = new Personne();
		// res.loadProperties(data);
		res.setDto(dto);
		return res;
	}

	public static Personne load(int id) {
		return new Personne(id);
	}

	public static Personne create() {
		return new Personne();
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
