package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import alv.data.PersonneDto;
import alv.data.LocationDto;
import alv.data.msAccess.PersonneDAL;
import alv.data.msAccess.LocationDAL;

public class Location extends LocationDto {

	private Personne _personne;
	private Adresse _adresse;
	private FicheInspection _ficheInspection;
	//private LocationDto _dto = new LocationDto();
	Connection conn;
	private LocationDAL dal;

	//PROPERTIES
//	public LocationDto getDto() {return _dto;}
//	private void setDto(LocationDto dto) {_dto = dto;}

	public Personne getPersonne() {return _personne;}
	private void setPersonne(Personne personne) {_personne = personne;}
	
	public Adresse getAdresse() {
		return _adresse;
	}
	private void setAdresse(Adresse _adresse) {
		this._adresse = _adresse;
	}
	// CONSTRUCTOR
	private Location() {
		initConnection();
		dal = new LocationDAL(conn);

		_personne = Personne.create();
		_adresse = Adresse.create();
	}

	private Location(int id) {
		initConnection();
		dal = new LocationDAL(conn);
		loadProperties(dal.fetch(id));

		setPersonne(Personne.load(getPersonneId()));
		setAdresse(Adresse.load(getAdresseId()));
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

				conn = LocationDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of Locations
	public static Location load(Map<String, Object> data) {
		Location res = new Location();
		res.loadProperties(data);

		if(res.getPersonneId()>0)
			res.setPersonne(Personne.load(res.getPersonneId()));

		if(res.getAdresseId()>0)
			res.setAdresse(Adresse.load(res.getAdresseId()));
		
		return res;
	}
	
	public static Location load(LocationDto data) {
		Location res = new Location();
		res.loadProperties(data);

		if(res.getPersonneId()>0)
			res.setPersonne(Personne.load(res.getPersonneId()));

		if(res.getAdresseId()>0)
			res.setAdresse(Adresse.load(res.getAdresseId()));
		return res;
	}

	public static Location load(int id) {
		return new Location(id);
	}

	public static Location create() {
		return new Location();
	}

	public void save() {

		if(getPersonne()!=null) {
			getPersonne().save();
			setPersonneId(getPersonne().getId());
		}
		if(getAdresse()!=null) {
			getAdresse().save();
			setAdresseId(getAdresse().getId());
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
				getAdresse().delete();
			}
		}
	}
}
