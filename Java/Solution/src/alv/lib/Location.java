package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Properties;

import alv.data.LocationDto;
import alv.data.msAccess.LocationDAL;

public class Location extends LocationDto {

	private Personne _personne;
	private Adresse _adresse;
	private FicheInspection _ficheInspection;
	private PermisConduire _permisConduire;
	private Vehicule _vehicule;
	
	Connection conn;
	private LocationDAL dal;

	// PROPERTIES
	@Override 
	public void setLocationDt(LocalDate date)
	{
		
	}	

	@Override 
	public void setVehicleId(int id)
	{
		_vehicleId = id;		
		_vehicule = Vehicule.load(id);
	}
	
	public Personne getPersonne() {
		return _personne;
	}

	private void setPersonne(Personne value) {
		_personne = value;
	}

	public PermisConduire getPermisConduire() {
		return _permisConduire;
	}

	private void setPermisConduire(PermisConduire value) {
		this._permisConduire = value;
	}

	public Vehicule getVehicule() {
		return _vehicule;
	}

	private void setVehicule(Vehicule value) {
		this._vehicule = value;
	}

	public Adresse getAdresse() {
		return _adresse;
	}

	private void setAdresse(Adresse value) {
		this._adresse = value;
	}

	public FicheInspection getFicheInspection() {
		return _ficheInspection;
	}

	private void setFicheInspection(FicheInspection value) {
		this._ficheInspection = value;
	}

	// CONSTRUCTOR
	private Location() {
		initConnection();
		dal = new LocationDAL(conn);

		_personne = Personne.create();
		_adresse = Adresse.create();
		_ficheInspection = FicheInspection.create();
		_permisConduire = PermisConduire.create();
	}

	private Location(int id) {
		initConnection();
		dal = new LocationDAL(conn);
		loadProperties(dal.fetch(id));

		setPersonne(Personne.load(getPersonneId()));
		setAdresse(Adresse.load(getAdresseId()));
		setFicheInspection(FicheInspection.load(getFicheInspectionId()));
		setPermisConduire(PermisConduire.load(getPermisConduireId()));
		setVehicule(Vehicule.load(getVehicleId()));
	}

	// METHODS
	public int calculatePrice()
	{
		return 0;
	}
	
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

	// this method will be used when the object is a child of Locations
	public static Location load(Map<String, Object> data) {
		Location res = new Location();
		res.loadProperties(data);

		if (res.getPersonneId() > 0)
			res.setPersonne(Personne.load(res.getPersonneId()));

		if (res.getAdresseId() > 0)
			res.setAdresse(Adresse.load(res.getAdresseId()));

		if (res.getPermisConduireId() > 0)
			res.setPermisConduire(PermisConduire.load(res.getPermisConduireId()));
		
		if (res.getFicheInspectionId() > 0)
			res.setFicheInspection(FicheInspection.load(res.getFicheInspectionId()));

		return res;
	}

	public static Location load(LocationDto data) {
		Location res = new Location();
		res.loadProperties(data);

		if (res.getPersonneId() > 0)
			res.setPersonne(Personne.load(res.getPersonneId()));

		if (res.getAdresseId() > 0)
			res.setAdresse(Adresse.load(res.getAdresseId()));

		if (res.getPermisConduireId() > 0)
			res.setPermisConduire(PermisConduire.load(res.getPermisConduireId()));
		
		if (res.getFicheInspectionId() > 0)
			res.setFicheInspection(FicheInspection.load(res.getFicheInspectionId()));

		return res;
	}

	public static Location load(int id) {
		return new Location(id);
	}

	public static Location create() {
		return new Location();
	}

	public void save() {

		if (getPersonne() != null) {
			getPersonne().save();
			setPersonneId(getPersonne().getId());
		}
		
		if (getAdresse() != null) {
			getAdresse().save();
			setAdresseId(getAdresse().getId());
		}

		if (getPermisConduire() != null) {
			getPermisConduire().save();
			setPermisConduireId(getPermisConduire().getId());
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
				//getPersonne().delete();
				getAdresse().delete();
				getPermisConduire().delete();
				getFicheInspection().delete();
			}
		}
	}
}
