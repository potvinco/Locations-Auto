package alv.data;

import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.Map;

public class PermisConduireDto {
	protected int _id;
	protected int _personneId;
	protected String _numero;
	protected String _country;
	protected String _province;
	protected int _classePermisConduireId;
	protected LocalDate _dateExpiration;
	protected LocalDate _dateEmission;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}


	public String getNumero() {
		return _numero;
	}

	public void setNumero(String value) {
		this._numero = value;
	}

	public int getClassePermisConduireId() {
		return _classePermisConduireId;
	}

	public void setClassePermisConduireId(int _classePermisConduireId) {
		this._classePermisConduireId = _classePermisConduireId;
	}

	public int getPersonneId() {
		return _personneId;
	}

	public void setPersonneId(int _personneId) {
		this._personneId = _personneId;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String _country) {
		this._country = _country;
	}

	public String getProvince() {
		return _province;
	}

	public void setProvince(String _province) {
		this._province = _province;
	}

	public LocalDate getDateExpiration() {
		return _dateExpiration;
	}

	public void setDateExpiration(LocalDate _dateExpiration) {
		this._dateExpiration = _dateExpiration;
	}

	public LocalDate getDateEmission() {
		return _dateEmission;
	}

	public void setDateEmission(LocalDate _dateEmission) {
		this._dateEmission = _dateEmission;
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
			setNumero((String) data.get("NUMERO"));
			setPersonneId((int) data.get("PERSONNEID"));
			setCountry((String) data.get("COUNTRY"));
			setProvince((String) data.get("PROVINCE"));
			setClassePermisConduireId((int) data.get("CLASSEPERMISCONDUIREID"));

			setDateExpiration(data.get("DATEEXPIRATION") == null ? null : ((Timestamp)data.get("DATEEXPIRATION")).toLocalDateTime().toLocalDate());
			setDateEmission(data.get("DATEEMISSION") == null ? null : ((Timestamp)data.get("DATEEMISSION")).toLocalDateTime().toLocalDate());
			
			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(PermisConduireDto data) {
		if (data != null) {
			setId((int) data.getId());
			setNumero((String) data.getNumero());
			setPersonneId((int) data.getPersonneId());
			setCountry((String) data.getCountry());
			setProvince((String) data.getProvince());
			setClassePermisConduireId((int) data.getClassePermisConduireId());
			setDateExpiration(data.getDateExpiration());
			setDateEmission(data.getDateEmission());
			
			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}

	
}
