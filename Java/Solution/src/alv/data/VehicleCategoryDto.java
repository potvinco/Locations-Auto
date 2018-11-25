package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class VehicleCategoryDto {
	private int _id;
	private String _description;

	private String _updatedBy;
	private Date _lastUpdated;

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
		try {
			this.setId((int) data.get("ID"));
			this.setDescription((String) data.get("DESCRIPTION"));

			this.setLastUpdated(data.get("LASTUPDATED") == null ? null
					: Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			this.setUpdatedBy((String) data.get("UPDATEDBY"));
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
