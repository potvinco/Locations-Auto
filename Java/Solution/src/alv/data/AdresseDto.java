package alv.data;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Map;

public class AdresseDto {
	private int _id;
	private String _adresse;
	private String _ville;
	private String _province;
	private String _codePostal;
	private String _updatedBy;
	private Date _lastUpdated;

	// PROPERTIES
	public int getId() { return _id; }
	public void setId(int _id) { this._id = _id; }

	public String getAdresse() { return _adresse; }
	public void setAdresse(String _adresse) { this._adresse = _adresse; }
	public String getVille() { return _ville; }
	public void setVille(String _ville) { this._ville = _ville; }
	public String getCodePostal() { return _codePostal; 	}
	public void setCodePostal(String _codePostal) { this._codePostal = _codePostal; }
	public String getProvince() { return _province; 	}
	public void setProvince(String _province) { this._province = _province; }
	
	public String getUpdatedBy() {return _updatedBy;}
	public void setUpdatedBy(String _updatedBy) {this._updatedBy = _updatedBy;}
	public Date getLastUpdated() {return _lastUpdated;}
	public void setLastUpdated(Date _lastUpdated) {this._lastUpdated = _lastUpdated;}

	//METHODS
	public void loadProperties(Map<String, Object> data) {
		if (data != null) {
			setId((int) data.get("ID"));
			setAdresse((String) data.get("ADRESSE"));
			setVille((String) data.get("VILLE"));
			setCodePostal((String) data.get("CODEPOSTAL"));
			setProvince((String) data.get("PROVINCE"));

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.get("LASTUPDATED") == null ? null : Date.valueOf(((Timestamp) data.get("LASTUPDATED")).toLocalDateTime().toLocalDate()));
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}
	public void loadProperties(AdresseDto data) {
		if (data != null) {
			setId((int) data.getId());
			setAdresse((String) data.getAdresse());
			setVille((String) data.getVille());
			setCodePostal((String) data.getCodePostal());
			setProvince((String) data.getProvince());

			// setLastUpdated((Date) data.get("LASTUPDATED"));
			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
