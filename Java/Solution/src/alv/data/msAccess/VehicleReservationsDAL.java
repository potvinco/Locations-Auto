package alv.data.msAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alv.data.ConnectionAdapter;
import alv.data.IVehicleReservationsDAL;

public class VehicleReservationsDAL extends ConnectionAdapter implements IVehicleReservationsDAL {

	public VehicleReservationsDAL(Connection connection) {
		super(connection);
	}

	@Override
	public List<Map<String, Object>> fetch(int id) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {
			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblReservation WHERE VehiculeId = ?");
			cstmt.setInt(1, id);
			
			boolean state = cstmt.execute();
			int rowsAffected = 0;

			// Protects against lack of SET NOCOUNT in stored prodedure
			while (state || rowsAffected != -1) {
				if (state) {
					rs = cstmt.getResultSet();
					break;
				} else {
					rowsAffected = cstmt.getUpdateCount();
				}
				state = cstmt.getMoreResults();
			}

			results = map(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(st);
		}
		return results;
	}
}