package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class FicheInspectionDto {
	private int _id;
//	private int _locationId;
	private int _vehiculeId;
	private String _description;
	private int _estimatedCost;
	private Date _inspectionDt;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

//	public int getLocationId() {
//		return _locationId;
//	}
//
//	public void setLocationId(int _locationId) {
//		this._locationId = _locationId;
//	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
	}

	public int getEstimatedCost() {
		return _estimatedCost;
	}

	public void setEstimatedCost(int _estimatedCost) {
		this._estimatedCost = _estimatedCost;
	}

	public Date getInspectionDt() {
		return _inspectionDt;
	}

	public void setInspectionDt(Date _inspectionDt) {
		this._inspectionDt = _inspectionDt;
	}

	public int getVehiculeId() {
		return _vehiculeId;
	}

	public void setVehiculeId(int _vehiculeId) {
		this._vehiculeId = _vehiculeId;
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
			setVehiculeId((int) data.get("VEHICULEID"));
			setDescription((String) data.get("DESCRIPTION"));
			setEstimatedCost((int) data.get("ESTIMATEDCOST"));
			setInspectionDt(data.get("INSPECTIONDT") == null ? null : Date.valueOf(((Timestamp) data.get("INSPECTIONDT")).toLocalDateTime().toLocalDate()));

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.get("LASTUPDATED") == null ? null : Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(FicheInspectionDto data) {
		if (data != null) {
			setId((int) data.getId());
			setVehiculeId((int) data.getVehiculeId());
			setDescription((String) data.getDescription());
			setEstimatedCost((int) data.getEstimatedCost());
			setInspectionDt(data.getInspectionDt());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
