package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class ClassePermisConduireDto {
	protected int _id;
	protected String _description;
	protected String _abbreviation;
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

	public void setDescription(String value) {
		this._description = value;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String value) {
		this._abbreviation = value;
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
			setDescription((String) data.get("DESCRIPTION"));
			setAbbreviation((String) data.get("ABBREVIATION"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(ClassePermisConduireDto data) {
		if (data != null) {
			setId((int) data.getId());
			setDescription((String) data.getDescription());
			setAbbreviation((String) data.getAbbreviation());

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
