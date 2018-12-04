package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class VehicleCategoryDto {
	protected int _id;
	protected String _description;
	protected int _prixLocation;

	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}
	
	public int getPrixLocation() {
		return _prixLocation;
	}

	public void setPrixLocation(int value) {
		this._prixLocation = value;
	}
	
	public String getDescription() {
		return _description;
	}

	public void setDescription(String _description) {
		this._description = _description;
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
		try {
			setId((int) data.get("ID"));
			setDescription((String) data.get("DESCRIPTION"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		} catch (NullPointerException ex) {

		}
	}

	public void loadProperties(VehicleCategoryDto data) {
		if (data != null) {
			this.setId((int) data.getId());
			this.setDescription((String) data.getDescription());

			this.setLastUpdated(data.getLastUpdated());
			this.setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
