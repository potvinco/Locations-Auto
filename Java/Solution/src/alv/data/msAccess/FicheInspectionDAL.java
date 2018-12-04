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
import alv.data.IFicheInspectionDAL;
import alv.data.FicheInspectionDto;

public class FicheInspectionDAL extends ConnectionAdapter implements IFicheInspectionDAL {

	public FicheInspectionDAL(Connection connection) {
		super(connection);
	}

	@Override
	public FicheInspectionDto fetch(int id) {
		FicheInspectionDto dto = new FicheInspectionDto();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {

			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblFicheInspection WHERE Id = ?");
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
			dto.loadProperties(results.isEmpty() ? null : results.get(0));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(st);
		}

		return dto;
	}

	@Override
	public int insert(FicheInspectionDto dto) {
		if (dto != null) {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"INSERT INTO tblFicheInspection ( VehiculeId, Description, EstimatedCost,LitreCarburant, InspectionDt) VALUES( ?, ?, ?, ?, ?)");

				cstmt.setInt(1, dto.getVehiculeId());
				cstmt.setString(2, dto.getDescription());
				cstmt.setInt(3, dto.getCoutDommages());
				cstmt.setInt(4, dto.getLitreCarburant());
				cstmt.setDate(5, Date.valueOf(dto.getInspectionDt()));
				
				cstmt.executeUpdate();

				// SELECT NEW ID
				// This is a BAD implementation but with this driver it is not possible:
				// - call MSAccess query
				// - obtain the new id using SELECT @@IDENTITY after INSERT
				//
				cstmt = connection.prepareCall("SELECT TOP 1 * FROM tblFicheInspection ORDER BY Id DESC");

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
				return results.isEmpty() ? 0 : (int) results.get(0).get("ID");

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				close(rs);
				close(st);
			}
		}
		return 0;
	}
	
	@Override
	public void update(FicheInspectionDto dto) {
		if (dto != null) {
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"UPDATE tblFicheInspection SET VehiculeId = ?, Description = ?, EstimatedCost = ?, LitreCarburant = ?, IspectionDt = ? WHERE Id = ?");

				cstmt.setInt(1, dto.getVehiculeId());
				cstmt.setString(2, dto.getDescription());
				cstmt.setInt(3, dto.getCoutDommages());
				cstmt.setInt(4, dto.getLitreCarburant());
				cstmt.setDate(5, Date.valueOf(dto.getInspectionDt()));
				cstmt.setInt(6, dto.getId());
				cstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				close(rs);
				close(st);
			}
		}
	}

	@Override
	public boolean delete(int id) {
		Statement st = null;
		ResultSet rs = null;
		try {
			CallableStatement cstmt = connection.prepareCall("DELETE FROM tblFicheInspection WHERE Id = ?");
			cstmt.setInt(1, id);
			cstmt.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			// throw new RuntimeException(e);
		} finally {
			close(rs);
			close(st);
		}
	}

}
