package alv.data.msAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alv.data.ConnectionAdapter;
import alv.data.IReservationsDAL;

public class ReservationsDAL extends ConnectionAdapter implements IReservationsDAL {

	public ReservationsDAL(Connection connection) {
		super(connection);
	}

	@Override
	public List<Map<String, Object>> fetch() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {
//			st = this.connection.createStatement();
//			rs = st.executeQuery("SELECT * FROM tblReservation");
			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblReservation");
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