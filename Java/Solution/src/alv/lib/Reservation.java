package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.ReservationDto;
import alv.data.msAccess.ReservationDAL;

public class Reservation extends ReservationDto {

	private Personne _personne;
	Connection conn;
	private ReservationDAL dal;

	//PROPERTIES
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
		loadProperties(dal.fetch(id));

		setPersonne(Personne.load(getPersonneId()));
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
	protected static Reservation load(Map<String, Object> data) {
		Reservation res = new Reservation();
		res.loadProperties(data);
		
		if(res.getPersonneId()>0)
			res.setPersonne(Personne.load(res.getPersonneId()));
		
		return res;
	}
	
	public static Reservation load(ReservationDto data) {
		Reservation res = new Reservation();
		res.loadProperties(data);
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
			setPersonneId(getPersonne().getId());
		}
		if(getId()==0) {
			int id = dal.insert(this);
			setId(id);
		}
		else
			dal.update(this);
	}

	public void delete() {
		int id = getId();

		if (id != 0) {
			if (dal.delete(id)) {
				setId(0);
				getPersonne().delete();
			}
		}
	}
}
