package alv.data.msAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alv.data.ConnectionAdapter;
import alv.data.IReservationValidatorDAL;

public class ReservationValidatorDAL extends ConnectionAdapter implements IReservationValidatorDAL{

	public ReservationValidatorDAL(Connection connection) {
		super(connection);
	}
	
	@Override
	public int fetch(int categoryId, Date startDt, Date endDt) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {

			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblPersonne WHERE Id = ?");
			cstmt.setInt(1, categoryId);
			cstmt.setDate(2, startDt);
			cstmt.setDate(3, endDt);

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

		return results.isEmpty() ? 0 : (int)results.get(0).get("COUNT");
	}

}
