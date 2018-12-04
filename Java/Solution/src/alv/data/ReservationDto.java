package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class ReservationDto {
	protected int _id;
	protected int _personneId;
	protected int _categoryId;
	protected LocalDate _startDt;
	protected LocalDate _endDt;
	protected boolean _assuranceOption;
	protected boolean _kmOption;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

	public LocalDate getStartDt() {
		return _startDt;
	}

	public void setStartDt(LocalDate _startDt) {
		this._startDt = _startDt;
	}

	public LocalDate getEndDt() {
		return _endDt;
	}

	public void setEndDt(LocalDate _endDt) {
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

	protected void setUpdatedBy(String _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public LocalDate getLastUpdated() {
		return _lastUpdated;
	}

	protected void setLastUpdated(LocalDate _lastUpdated) {
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
			setStartDt(data.get("STARTDT") == null ? null : ((Timestamp)data.get("STARTDT")).toLocalDateTime().toLocalDate());
			setEndDt(data.get("ENDDT") == null ? null : ((Timestamp)data.get("ENDDT")).toLocalDateTime().toLocalDate());
			
			this.setCategoryId((int) data.get("CATEGORYID"));
			this.setAssuranceOption((boolean) data.get("ASSURANCEOPTIONID"));
			this.setKmOption((boolean) data.get("KMOPTIONID"));
			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			
			this.setUpdatedBy((String) data.get("UPDATEDBY"));
		} catch (NullPointerException ex) {

		}
	}

	public void loadProperties(ReservationDto data) {
		if (data != null) {
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
