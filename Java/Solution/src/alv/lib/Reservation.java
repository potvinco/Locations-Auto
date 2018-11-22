package alv.lib;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import alv.data.msAccess.ReservationDAL;

public class Reservation {

	private int _id;
	private int _personneId;
	private int _categoryId;
	private Date _startDt;
	private Date _endDt;
	private boolean _assuranceOption;
	private boolean _kmOption;
	private String _updatedBy;
	private Date _lastUpdated;

	Connection conn;
	private ReservationDAL dal;

	// CONSTRUCTOR
	private Reservation() {
		initConnection();
	}

	private Reservation(int id) {
		initConnection();
		dal = new ReservationDAL(conn);
		Map<String, Object> map = dal.fetch(id);
		this.loadProperties(map);
	}

	// METHODS
	private void loadProperties(Map<String, Object> data) {
		try {
			this.setId((int) data.get("ID"));
			this.setPersonneId((int) data.get("PERSONNEID"));
			this.setStartDt((Date) data.get("STARTDT"));
			this.setEndDt((Date) data.get("ENDDT"));
			this.setCategoryId((int) data.get("CATEGORYID"));
			this.setAssuranceOption((boolean) data.get("ASSURANCEOPTIONID"));
			this.setKmOption((boolean) data.get("KMOPTIONID"));
			this.setLastUpdated((Date) data.get("LASTUPDATED"));
			this.setUpdatedBy((String) data.get("UPDATEDBY"));
		} catch (NullPointerException ex) {

		}
	}

	private void initConnection() {
		try {
			if (conn == null) {
				String dbSettingsPropertyFile = "./properties/AppSettings.properties";
				Properties props = new Properties();

				FileReader fReader;
				fReader = new FileReader(dbSettingsPropertyFile);
				props.load(fReader);

				String driver = props.getProperty("db.driver.class");
				String msAccDB = props.getProperty("db.path");
				String dbURL = props.getProperty("db.conn.url") + msAccDB;

				conn = ReservationDAL.createConnection(driver, dbURL, null, null);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Reservation load(Map<String, Object> data) {
		Reservation res = new Reservation();
		res.loadProperties(data);
		return res;
	}

	public static Reservation load(int id) {
		return new Reservation(id);
	}

	public static Reservation create() {
		return new Reservation();
	}

	public void delete() {

	}

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
}
