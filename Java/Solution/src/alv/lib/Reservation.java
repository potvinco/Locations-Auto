package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import alv.data.PersonneDto;
import alv.data.ReservationDto;
import alv.data.msAccess.PersonneDAL;
import alv.data.msAccess.ReservationDAL;

public class Reservation {

	private Personne _personne;
	private ReservationDto _dto = new ReservationDto();
	Connection conn;
	private ReservationDAL dal;

	//PROPERTIES
	public ReservationDto getDto() {return _dto;}
	private void setDto(ReservationDto dto) {_dto = dto;}

	public Personne getPersonne() {return _personne;}
	private void setPersonne(Personne personne) {_personne = personne;}
	
	// CONSTRUCTOR
	private Reservation() {
		initConnection();
		dal = new ReservationDAL(conn);
		
		_personne = Personne.create();
	}

	private Reservation(int id) {
		initConnection();
		dal = new ReservationDAL(conn);
		_dto = dal.fetch(id);

		setPersonne(Personne.load(_dto.getPersonneId()));
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

				conn = ReservationDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of Reservations
	public static Reservation load(Map<String, Object> data) {
		Reservation res = new Reservation();
		res.getDto().loadProperties(data);
		
		if(res.getDto().getPersonneId()>0)
			res.setPersonne(Personne.load(res.getDto().getPersonneId()));
		
		return res;
	}
	
	public static Reservation load(ReservationDto data) {
		Reservation res = new Reservation();
		res.setDto(data);
		return res;
	}

	public static Reservation load(int id) {
		return new Reservation(id);
	}

	public static Reservation create() {
		return new Reservation();
	}

	public void save() {

		if(getPersonne()!=null) {
			getPersonne().save();
			_dto.setPersonneId(getPersonne().getDto().getId());
		}
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
				getPersonne().delete();
			}
		}
	}
}
