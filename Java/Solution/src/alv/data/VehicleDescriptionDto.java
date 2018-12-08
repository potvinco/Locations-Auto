package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class VehicleDescriptionDto {
	protected int _id;

	protected int _annee;
	protected int _categoryId;
	protected int _classeId;
	protected String _description;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

	public int getAnnee() {
		return _annee;
	}

	public void setAnnee(int _annee) {
		this._annee = _annee;
	}

	public int getClasseId() {
		return _classeId;
	}

	public void setClasseId(int _classeId) {
		this._classeId = _classeId;
	}

	public int getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(int _categoryId) {
		this._categoryId = _categoryId;
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
		if (data != null) {
			setId((int) data.get("ID"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(VehicleDescriptionDto data) {
		if (data != null) {
			setId((int) data.getId());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
