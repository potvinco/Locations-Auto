package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class PersonneDto {
	private int _id;
	private int _adresseId;
	private String _nom;
	private String _prenom;
	private String _telephone;
	private Date _dateNaissance;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public String getNom() {
		return _nom;
	}

	public void setNom(String _nom) {
		this._nom = _nom;
	}

	public String getPrenom() {
		return _prenom;
	}

	public void setPrenom(String _prenom) {
		this._prenom = _prenom;
	}

	public String getTelephone() {
		return _telephone;
	}

	public void setTelephone(String _telephone) {
		this._telephone = _telephone;
	}

	public Date getDateNaissance() {
		return _dateNaissance;
	}

	public void setDateNaissance(Date _dateNaissance) {
		this._dateNaissance = _dateNaissance;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public Date getLastUpdated() {
		return _lastUpdated;
	}

	public void setLastUpdated(Date _lastUpdated) {
		this._lastUpdated = _lastUpdated;
	}

	
	//METHODS
	public void loadProperties(Map<String, Object> data) {
		if (data != null) {
			setId((int) data.get("ID"));
			setNom((String) data.get("NOM"));
			setPrenom((String) data.get("PRENOM"));
			setTelephone((String) data.get("TELEPHONE"));
			setDateNaissance(data.get("DATENAISSANCE") == null ? null : Date.valueOf(((Timestamp) data.get("DATENAISSANCE")).toLocalDateTime().toLocalDate()));

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.get("LASTUPDATED") == null ? null : Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public int getAdresseId() {
		return _adresseId;
	}

	public void setAdresseId(int _adresseId) {
		this._adresseId = _adresseId;
	}
}
