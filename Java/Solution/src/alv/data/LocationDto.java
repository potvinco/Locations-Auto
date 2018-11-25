package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class LocationDto {
	private int _id;

	private boolean _assuranceOption;
	private boolean _kmOption;
	private int _personneId;
	private int _adresseId;
	
	private Date _LocationDt;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public boolean getAssuranceOption() {
		return _assuranceOption;
	}

	public void setAssuranceOption(boolean _assuranceOption) {
		this._assuranceOption = _assuranceOption;
	}

	public boolean getKmOption() {
		return _kmOption;
	}

	public void setKmOption(boolean _kmOption) {
		this._kmOption = _kmOption;
	}

	public Date getLocationDt() {
		return _LocationDt;
	}

	public void setLocationDt(Date _LocationDt) {
		this._LocationDt = _LocationDt;
	}

	public int getPersonneId() {
		return _personneId;
	}

	public void setPersonneId(int _personneId) {
		this._personneId = _personneId;
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
			setKmOption((boolean) data.get("KMOPTION"));
			setAssuranceOption((boolean) data.get("ASSURANCEOPTION"));
			setLocationDt(data.get("LOCATIONDT") == null ? null : Date.valueOf(((Timestamp) data.get("LOCATIONDT")).toLocalDateTime().toLocalDate()));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}
}
