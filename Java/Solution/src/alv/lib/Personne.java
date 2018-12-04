package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.PersonneDto;
import alv.data.msAccess.PersonneDAL;

public class Personne extends PersonneDto {
	private Adresse _adresse;
	Connection conn;
	private PersonneDAL dal;

	//PROPERTIES
	public Adresse getAdresse() {return _adresse;}
	private void setAdresse(Adresse adresse) {_adresse = adresse;}
	
	//@Override 
//	public void setNom(String nom) {
//		this._nom = nom;
//	}
	
	
	// CONSTRUCTOR
	private Personne() {
		initConnection();
		dal = new PersonneDAL(conn);
		
		_adresse = Adresse.create();
	}

	private Personne(int id) {
		initConnection();
		dal = new PersonneDAL(conn);
		loadProperties(dal.fetch(id));
		
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

				conn = PersonneDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//this method will be used when the object is a child of Personnes
	public static Personne load(Map<String, Object> data) {
		Personne res = new Personne();
		res.loadProperties(data);
		
		return res;
	}
		
	protected static Personne load(PersonneDto dto) {
		Personne res = new Personne();
		res.loadProperties(dto);

		if(res.getAdresseId()>0)
			res.setAdresse(Adresse.load(res.getAdresseId()));
		
		return res;
	}

	public static Personne load(int id) {
		return new Personne(id);
	}

	public static Personne create() {
		return new Personne();
	}

	public void save() {

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
				getAdresse().delete();
			}
		}
	}
}
