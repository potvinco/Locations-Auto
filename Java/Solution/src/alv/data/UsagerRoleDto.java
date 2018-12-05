package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class UsagerRoleDto {
	protected int _id;
	protected int _usagerId;
	protected int _roleId;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

	public int getUsagerId() {
		return _usagerId;
	}

	public void setUsagerId(int _usagerId) {
		this._usagerId = _usagerId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int _roleId) {
		this._roleId = _roleId;
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
			setUsagerId((int) data.get("USAGERID"));
			setRoleId((int) data.get("ROLEID"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(UsagerRoleDto data) {
		if (data != null) {
			setId((int) data.getId());
			setUsagerId((int) data.getUsagerId());
			setRoleId((int) data.getRoleId());

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
