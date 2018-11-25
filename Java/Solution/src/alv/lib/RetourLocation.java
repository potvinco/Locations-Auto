package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import alv.data.RetourLocationDto;
import alv.data.msAccess.RetourLocationDAL;

public class RetourLocation extends RetourLocationDto {

	private Personne _personne;
	private FicheInspection _ficheInspection;
	Connection conn;
	private RetourLocationDAL dal;

	// PROPERTIES
	public Personne getPersonne() {
		return _personne;
	}

	private void setPersonne(Personne personne) {
		_personne = personne;
	}

	public FicheInspection getFicheInspection() {
		return _ficheInspection;
	}

	public void setFicheInspection(FicheInspection _ficheInspection) {
		this._ficheInspection = _ficheInspection;
	}

	// CONSTRUCTOR
	private RetourLocation() {
		initConnection();
		dal = new RetourLocationDAL(conn);

		_personne = Personne.create();
		_ficheInspection = FicheInspection.create();
	}

	private RetourLocation(int id) {
		initConnection();
		dal = new RetourLocationDAL(conn);
		loadProperties(dal.fetch(id));

		setPersonne(Personne.load(getPersonneId()));
		//setAdresse(Adresse.load(getAdresseId()));
		setFicheInspection(FicheInspection.load(getFicheInspectionId()));
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

				conn = RetourLocationDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// this method will be used when the object is a child of Locations
	public static RetourLocation load(Map<String, Object> data) {
		RetourLocation res = new RetourLocation();
		res.loadProperties(data);

		if (res.getPersonneId() > 0)
			res.setPersonne(Personne.load(res.getPersonneId()));

		if (res.getFicheInspectionId() > 0)
			res.setFicheInspection(FicheInspection.load(res.getFicheInspectionId()));

		return res;
	}

	public static RetourLocation load(RetourLocationDto data) {
		RetourLocation res = new RetourLocation();
		res.loadProperties(data);

		if (res.getPersonneId() > 0)
			res.setPersonne(Personne.load(res.getPersonneId()));

		if (res.getFicheInspectionId() > 0)
			res.setFicheInspection(FicheInspection.load(res.getFicheInspectionId()));

		return res;
	}

	public static RetourLocation load(int id) {
		return new RetourLocation(id);
	}

	public static RetourLocation create() {
		return new RetourLocation();
	}

	public void save() {

		if (getPersonne() != null) {
			getPersonne().save();
			setPersonneId(getPersonne().getId());
		}
		
		if (getFicheInspection() != null) {
			getFicheInspection().save();
			setFicheInspectionId(getFicheInspection().getId());
		}

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
				getPersonne().delete();
				getFicheInspection().delete();
			}
		}
	}
}
