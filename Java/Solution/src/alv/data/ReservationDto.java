package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class ReservationDto {
	private int _id;
	private int _personneId;
	private int _categoryId;
	private Date _startDt;
	private Date _endDt;
	private boolean _assuranceOption;
	private boolean _kmOption;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public Date getStartDt() {
		return _startDt;
	}

	public void setStartDt(Date _startDt) {
		this._startDt = _startDt;
	}

	public Date getEndDt() {
		return _endDt;
	}

	public void setEndDt(Date _endDt) {
		this._endDt = _endDt;
	}

	public int getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(int _categoryId) {
		this._categoryId = _categoryId;
	}

	public boolean getAssuranceOption() {
		return _assuranceOption;
	}

	public void setAssuranceOption(boolean _assuranceOption) {
		this._assuranceOption = _assuranceOption;
	}

	public boolean getKmOption() {
		return _kmOption;
	}

	public void setKmOption(boolean _kmOption) {
		this._kmOption = _kmOption;
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

	public int getPersonneId() {
		return _personneId;
	}

	public void setPersonneId(int _personneId) {
		this._personneId = _personneId;
	}

	// METHODS
	public void loadProperties(Map<String, Object> data) {
		try {
			this.setId((int) data.get("ID"));
			this.setPersonneId((int) data.get("PERSONNEID"));
			this.setStartDt(data.get("STARTDT") == null ? null
					: Date.valueOf(((Timestamp) data.get("STARTDT")).toLocalDateTime().toLocalDate()));
			this.setEndDt(data.get("ENDDT") == null ? null
					: Date.valueOf(((Timestamp) data.get("ENDDT")).toLocalDateTime().toLocalDate()));
			this.setCategoryId((int) data.get("CATEGORYID"));
			this.setAssuranceOption((boolean) data.get("ASSURANCEOPTIONID"));
			this.setKmOption((boolean) data.get("KMOPTIONID"));
			this.setLastUpdated(data.get("LASTUPDATED") == null ? null
					: Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			this.setUpdatedBy((String) data.get("UPDATEDBY"));
		} catch (NullPointerException ex) {

		}
	}

	public void loadProperties(ReservationDto data) {
		if(data!=null) {
			this.setId((int) data.getId());
			this.setPersonneId((int) data.getPersonneId());
			this.setStartDt(data.getStartDt());
			this.setEndDt(data.getEndDt());
			this.setCategoryId((int) data.getCategoryId());
			this.setAssuranceOption((boolean) data.getAssuranceOption());
			this.setKmOption((boolean) data.getKmOption());
			this.setLastUpdated(data.getLastUpdated());
			this.setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
