package alv.data;

import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.Map;

public class PermisConduireDto {
	protected int _id;
	protected int _personneId;
	protected String _numero;
	protected int _countryId;
	protected int _provinceId;
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

	public int getPersonneId() {
		return _personneId;
	}

	public void setPersonneId(int _personneId) {
		this._personneId = _personneId;
	}

	public int getCountryId() {
		return _countryId;
	}

	public void setCountryId(int _countryId) {
		this._countryId = _countryId;
	}

	public int getProvinceId() {
		return _provinceId;
	}

	public void setProvinceId(int _provinceId) {
		this._provinceId = _provinceId;
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
			setCountryId((int) data.get("COUNTRYID"));
			setProvinceId((int) data.get("PROVINCEID"));

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
			setCountryId((int) data.getCountryId());
			setProvinceId((int) data.getProvinceId());
			setDateExpiration(data.getDateExpiration());
			setDateEmission(data.getDateEmission());
			
			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}

	
}
