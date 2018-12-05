package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class UsagerDto {
	protected int _id;
	protected String _code;
	protected String _password;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String value) {
		this._code = value;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String value) {
		this._password = value;
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
			setCode((String) data.get("CODE"));
			setPassword((String) data.get("PASSWORD"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(UsagerDto data) {
		if (data != null) {
			setId((int) data.getId());
			setCode((String) data.getCode());
			setPassword((String) data.getPassword());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
