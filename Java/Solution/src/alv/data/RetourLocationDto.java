package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class RetourLocationDto {
	protected int _id;
	protected int _locationId;
	protected int _ficheInspectionId;

	protected LocalDate _retourDt;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}


	public LocalDate getRetourDt() {
		return _retourDt;
	}

	public void setRetourDt(LocalDate date) {
		this._retourDt = date;
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
			setFicheInspectionId((int) data.get("FICHEINSPECTIONID"));
			setLocationId((int) data.get("LOCATIONID"));
			setRetourDt(data.get("RETOURDT") == null ? null : ((Timestamp)data.get("RETOURDT")).toLocalDateTime().toLocalDate());
			
			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
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
