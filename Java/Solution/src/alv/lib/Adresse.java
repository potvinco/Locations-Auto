package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.AdresseDAL;
import alv.data.msAccess.PersonneDAL;

public class Adresse {

	private int _id;
	private String _nom;
	private String _prenom;
	private String _telephone;
	private Date _dateNaissance;
	private String _updatedBy;
	private Date _lastUpdated;

	Connection conn;
	private AdresseDAL dal;

	// PROPERTIES
	public int getId() { return _id; }
	public void setId(int _id) { this._id = _id; }

	public String getNom() { return _nom; }
	public void setNom(String _nom) { this._nom = _nom; }
	public String getPrenom() { return _prenom; }
	public void setPrenom(String _prenom) { this._prenom = _prenom; }
	public String getTelephone() { return _telephone; 	}
	public void setTelephone(String _telephone) { this._telephone = _telephone; }
	public Date getDateNaissance() { return _dateNaissance; 	}
	public void setDateNaissance(Date _dateNaissance) { this._dateNaissance = _dateNaissance; }
	
	public String getUpdatedBy() {return _updatedBy;}
	public void setUpdatedBy(String _updatedBy) {this._updatedBy = _updatedBy;}
	public Date getLastUpdated() {return _lastUpdated;}
	public void setLastUpdated(Date _lastUpdated) {this._lastUpdated = _lastUpdated;}

	
	// CONSTRUCTOR
	private Adresse() {
		initConnection();
	}
	
	private Adresse(int id) {		
		initConnection();
		dal = new AdresseDAL(conn);
		loadProperties(dal.fetch(id));		
	}

	// METHODS
	private void loadProperties(Map<String, Object> data) {
		setId((int) data.get("Id"));
		setNom((String) data.get("Nom"));
		setPrenom((String) data.get("Prenom"));
		setDateNaissance((Date) data.get("DateNaissance"));
		setTelephone((String) data.get("Telephone"));


		
		setLastUpdated((Date) data.get("LastUpdated"));
		setUpdatedBy((String) data.get("UpdatedBy"));
	}
	
	private void initConnection() {
		try {
			if(conn == null) {
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
	
	public static Adresse load(Map<String, Object> data) {
		Adresse res = new Adresse();
		res.loadProperties(data);
		return res;
	}
	
	public static Adresse load(int id)
	{
		return new Adresse(id);
	}
	
	public static Adresse create() {
		return new Adresse();
	}
	
	public void delete() {

	}

}
