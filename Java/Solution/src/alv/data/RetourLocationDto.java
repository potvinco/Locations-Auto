package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class RetourLocationDto {
	private int _id;

	
	private int _personneId;
	private int _locationId;
	private int _ficheInspectionId;

	private Date _retourDt;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}


	public Date getRetourDt() {
		return _retourDt;
	}

	public void setRetourDt(Date date) {
		this._retourDt = date;
	}

	public int getPersonneId() {
		return _personneId;
	}

	public void setPersonneId(int _personneId) {
		this._personneId = _personneId;
	}

	public int getFicheInspectionId() {
		return _ficheInspectionId;
	}

	public void setFicheInspectionId(int _ficheInspectionId) {
		this._ficheInspectionId = _ficheInspectionId;
	}

	public int getLocationId() {
		return _locationId;
	}

	public void setLocationId(int _locationId) {
		this._locationId = _locationId;
	}
	
	public String getUpdatedBy() {
		return _updatedBy;
	}

	protected void setUpdatedBy(String _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public Date getLastUpdated() {
		return _lastUpdated;
	}

	protected void setLastUpdated(Date _lastUpdated) {
		this._lastUpdated = _lastUpdated;
	}

	// METHODS
	public void loadProperties(Map<String, Object> data) {
		if (data != null) {
			setId((int) data.get("ID"));
			setFicheInspectionId((int) data.get("FICHEINSPECTIONID"));
			setLocationId((int) data.get("LOCATIONID"));
			setRetourDt(data.get("RETOURDT") == null ? null
					: Date.valueOf(((Timestamp) data.get("RETOURDT")).toLocalDateTime().toLocalDate()));

			setLastUpdated(data.get("LASTUPDATED") == null ? null
					: Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(RetourLocationDto data) {
		if (data != null) {
			setId((int) data.getId());
			setFicheInspectionId((int) data.getFicheInspectionId());
			setLocationId((int) data.getLocationId());
			setRetourDt(data.getRetourDt());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}

}
