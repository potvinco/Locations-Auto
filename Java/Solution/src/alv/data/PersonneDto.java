package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
//import java.sql.Date;
//import java.sql.Timestamp;
import java.util.Map;

public class PersonneDto {
	protected int _id;
	protected int _adresseId;
	protected String _nom;
	protected String _prenom;
	protected String _telephone;
	protected LocalDate _dateNaissance;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
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

	public LocalDate getDateNaissance() {
		return _dateNaissance;
	}

	public void setDateNaissance(LocalDate _dateNaissance) {
		this._dateNaissance = _dateNaissance;
	}

	public int getAdresseId() {
		return _adresseId;
	}

	public void setAdresseId(int _adresseId) {
		this._adresseId = _adresseId;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	protected void setUpdatedBy(String _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public LocalDate getLastUpdated() {
		return _lastUpdated;
	}

	protected void setLastUpdated(LocalDate _lastUpdated) {
		this._lastUpdated = _lastUpdated;
	}

	// METHODS
	public void loadProperties(Map<String, Object> data) {
		if (data != null) {
			setId((int) data.get("ID"));
			setNom((String) data.get("NOM"));
			setPrenom((String) data.get("PRENOM"));
			setTelephone((String) data.get("TELEPHONE"));
			setDateNaissance(data.get("DATENAISSANCE") == null ? null : ((Timestamp)data.get("DATENAISSANCE")).toLocalDateTime().toLocalDate());
						
			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(PersonneDto data) {
		if (data != null) {
			setId((int) data.getId());
			setNom((String) data.getNom());
			setPrenom((String) data.getPrenom());
			setTelephone((String) data.getTelephone());
			setDateNaissance(data.getDateNaissance());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}

}
