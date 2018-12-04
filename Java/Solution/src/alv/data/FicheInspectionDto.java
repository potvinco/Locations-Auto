package alv.data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class FicheInspectionDto {
	protected int _id;
	protected int _vehiculeId;
	protected String _description;
	protected int _estimatedCost;
	protected LocalDate _inspectionDt;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

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

	public LocalDate getInspectionDt() {
		return _inspectionDt;
	}

	public void setInspectionDt(LocalDate _inspectionDt) {
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
			setVehiculeId((int) data.get("VEHICULEID"));
			setDescription((String) data.get("DESCRIPTION"));
			setEstimatedCost((int) data.get("ESTIMATEDCOST"));
			setInspectionDt(data.get("INSPECTIONDT") == null ? null : ((Date)data.get("INSPECTIONDT")).toLocalDate());
			
			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Date)data.get("LASTUPDATED")).toLocalDate());
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
