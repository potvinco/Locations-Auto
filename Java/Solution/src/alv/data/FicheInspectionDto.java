package alv.data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

public class FicheInspectionDto {
	protected int _id;
	protected int _vehiculeId;
	protected String _description;
	private int _litreCarburant;
	protected int _coutDommages;
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

	public int getCoutDommages() {
		return _coutDommages;
	}

	public void setCoutDommages(int value) {
		this._coutDommages = value;
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

	public int getLitreCarburant() {
		return _litreCarburant;
	}

	public void setLitreCarburant(int _litreCarburant) {
		this._litreCarburant = _litreCarburant;
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
			setLitreCarburant((int) data.get("LITRECARBURANT"));
			setCoutDommages((int) data.get("ESTIMATEDCOST"));
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
			setLitreCarburant((int) data.getLitreCarburant());
			setCoutDommages((int) data.getCoutDommages());
			setInspectionDt(data.getInspectionDt());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
