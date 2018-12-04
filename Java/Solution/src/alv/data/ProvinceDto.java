package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class ProvinceDto {
	protected int _id;
	protected int _countryId;
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


	public int getCountryId() {
		return _countryId;
	}

	public void setCountryId(int id) {
		this._countryId = id;
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
			setCountryId((int) data.get("COUNTRYID"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(ProvinceDto data) {
		if (data != null) {
			setId((int) data.getId());
			setDescription((String) data.getDescription());
			setAbbreviation((String) data.getAbbreviation());
			setCountryId((int) data.getCountryId());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
