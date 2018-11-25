package alv.data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

public class VehiculeDto {
	private int _id;
	private int _lookUpId;
	private String _noSerie;
	private String _immatriculation;
	//private String _km;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}


	public int getLookUpId() {
		return _lookUpId;
	}

	public void setLookUpId(int _lookUpId) {
		this._lookUpId = _lookUpId;
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

	public void setUpdatedBy(String _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public Date getLastUpdated() {
		return _lastUpdated;
	}

	public void setLastUpdated(Date _lastUpdated) {
		this._lastUpdated = _lastUpdated;
	}

	
	//METHODS
	public void loadProperties(Map<String, Object> data) {
		if (data != null) {
			setId((int) data.get("ID"));
			setLookUpId((int) data.get("LOOKUPID"));
			setNoSerie((String) data.get("NOSERIE"));
			setImmatriculation((String) data.get("IMMAtRICULAtION"));

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.get("LASTUPDATED") == null ? null : Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}
}
