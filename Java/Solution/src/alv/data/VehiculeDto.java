package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class VehiculeDto {
	protected int _id;
	protected int _descriptionId;
	protected String _noSerie;
	protected String _immatriculation;

	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

	public int getDescriptionId() {
		return _descriptionId;
	}

	public void setDescriptionId(int id) {
		this._descriptionId = id;
	}

	public String getNoSerie() {
		return _noSerie;
	}

	public void setNoSerie(String _noSerie) {
		this._noSerie = _noSerie;
	}

	public String getImmatriculation() {
		return _immatriculation;
	}

	public void setImmatriculation(String _immatriculation) {
		this._immatriculation = _immatriculation;
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
			setDescriptionId((int) data.get("LOOKUPID"));
			setNoSerie((String) data.get("NOSERIE"));
			setImmatriculation((String) data.get("IMMAtRICULAtION"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(VehiculeDto data) {
		if (data != null) {
			setId((int) data.getId());
			setDescriptionId((int) data.getDescriptionId());
			setNoSerie((String) data.getNoSerie());
			setImmatriculation((String) data.getImmatriculation());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
