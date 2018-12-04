package alv.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Map;

public class LocationDto {
	protected int _id;

	private String _contractNo;
	protected int _reservationId;
	protected int _personneId;
	protected int _adresseId;
	protected int _permisConduireId;
	protected int _vehicleId;
	protected int _ficheInspectionId;
	protected LocalDate _LocationDt;
	
	protected String _TPSNo;
	protected String _TVQNo;
	protected String _immatriculation;
	
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

	public int getPermisConduireId() {
		return _permisConduireId;
	}

	public void setPermisConduireId(int _permisConduireId) {
		this._permisConduireId = _permisConduireId;
	}

	public String getTVQNo() {
		return _TVQNo;
	}

	public void setTVQNo(String _TVQNo) {
		this._TVQNo = _TVQNo;
	}

	public String getTPSNo() {
		return _TPSNo;
	}

	public void setTPSNo(String _TPSNo) {
		this._TPSNo = _TPSNo;
	}

	public String getContractNo() {
		return _contractNo;
	}

	public void setContractNo(String _contractNo) {
		this._contractNo = _contractNo;
	}

	public String getImmatriculation() {
		return _immatriculation;
	}

	public void setImmatriculation(String _immatriculation) {
		this._immatriculation = _immatriculation;
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

	public LocalDate getLocationDt() {
		return _LocationDt;
	}

	public void setLocationDt(LocalDate _LocationDt) {
		this._LocationDt = _LocationDt;
	}

	public int getPersonneId() {
		return _personneId;
	}

	public void setPersonneId(int _personneId) {
		this._personneId = _personneId;
	}

	public int getVehicleId() {
		return _vehicleId;
	}

	public void setVehicleId(int _vehicleId) {
		this._vehicleId = _vehicleId;
	}

	public int getAdresseId() {
		return _adresseId;
	}

	public void setAdresseId(int _adresseId) {
		this._adresseId = _adresseId;
	}

	public int getFicheInspectionId() {
		return _ficheInspectionId;
	}

	public void setFicheInspectionId(int _ficheInspectionId) {
		this._ficheInspectionId = _ficheInspectionId;
	}

	public int getReservationId() {
		return _reservationId;
	}

	public void setReservationId(int _reservationId) {
		this._reservationId = _reservationId;
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
			setContractNo((String) data.get("CONTRACTNO"));
			setPersonneId((int) data.get("PERSONNEID"));
			setReservationId((int) data.get("RESERVATIONID"));
			setAdresseId((int) data.get("ADRESSEID"));
			setPermisConduireId((int) data.get("PERMISCONDUIREID"));
			setVehicleId((int) data.get("VEHICLEID"));
			setFicheInspectionId((int) data.get("FICHEINSPECTIONID"));
			setLocationDt(data.get("LOCATIONDT") == null ? null : ((Timestamp)data.get("LOCATIONDT")).toLocalDateTime().toLocalDate());
			
			setTPSNo((String) data.get("TPSNO"));
			setTVQNo((String) data.get("TVQNO"));
			
			setKmOption((boolean) data.get("KMOPTION"));
			setAssuranceOption((boolean) data.get("ASSURANCEOPTION"));
			
			setLastUpdated(data.get("LASTUPDATED") == null ? null : ((Timestamp)data.get("LASTUPDATED")).toLocalDateTime().toLocalDate());
			setUpdatedBy((String) data.get("UPDATEDBY"));
		}
	}

	public void loadProperties(LocationDto data) {
		if (data != null) {
			setId((int) data.getId());
			setContractNo((String) data.getContractNo());
			setPersonneId((int) data.getPersonneId());
			setReservationId((int) data.getReservationId());
			setAdresseId((int) data.getAdresseId());
			setPermisConduireId((int) data.getPermisConduireId());
			setVehicleId((int) data.getVehicleId());
			setFicheInspectionId((int) data.getFicheInspectionId());
			setLocationDt(data.getLocationDt());

			setTPSNo((String) data.getTPSNo());
			setTVQNo((String) data.getTVQNo());
			
			setKmOption((boolean) data.getKmOption());
			setAssuranceOption((boolean) data.getAssuranceOption());
			
			setLastUpdated(data.getLastUpdated());
			setUpdatedBy((String) data.getUpdatedBy());
		}
	}
}
