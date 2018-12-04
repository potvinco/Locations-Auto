package alv.data;

import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.Map;

public class AdresseDto {
	protected int _id;
	protected String _adresse;
	protected String _ville;
	protected int _provinceId;
	protected String _codePostal;
	protected String _updatedBy;
	protected LocalDate _lastUpdated;

	// PROPERTIES
	public int getId() {
		return _id;
	}

	protected void setId(int _id) {
		this._id = _id;
	}

	public String getAdresse() {
		return _adresse;
	}

	public void setAdresse(String _adresse) {
		this._adresse = _adresse;
	}

	public String getVille() {
		return _ville;
	}

	public void setVille(String _ville) {
		this._ville = _ville;
	}

	public String getCodePostal() {
		return _codePostal;
	}

	public void setCodePostal(String _codePostal) {
		this._codePostal = _codePostal;
	}

	public int getProvinceId() {
		return _provinceId;
	}

	public void setProvinceId(int id) {
		this._provinceId = id;
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
			setAdresse((String) data.get("ADRESSE"));
			setVille((String) data.get("VILLE"));
			setCodePostal((String) data.get("CODEPOSTAL"));
			setProvinceId((int) data.get("PROVINCEID"));

			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(AdresseDto data) {
		if (data != null) {
			setId((int) data.getId());
			setAdresse((String) data.getAdresse());
			setVille((String) data.getVille());
			setCodePostal((String) data.getCodePostal());
			setProvinceId((int) data.getProvinceId());

			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
