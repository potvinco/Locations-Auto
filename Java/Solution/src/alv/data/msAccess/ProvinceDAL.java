package alv.data.msAccess;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alv.data.ProvinceDto;
import alv.data.ConnectionAdapter;
import alv.data.IProvinceDAL;

public class ProvinceDAL extends ConnectionAdapter implements IProvinceDAL {

	public ProvinceDAL(Connection connection) {
		super(connection);
	}

	@Override
	public ProvinceDto fetch(int id) {
		ProvinceDto dto = new ProvinceDto();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {
			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblProvince WHERE Id = ?");
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
	public int insert(ProvinceDto dto) {
		if (dto != null) {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"INSERT INTO tblProvince ( Description, Abbreviation, CountryId) VALUES( ?, ?, ?)");

				cstmt.setString(1, dto.getDescription());
				cstmt.setString(2, dto.getAbbreviation());
				cstmt.setInt(3, dto.getCountryId());
				cstmt.executeUpdate();

				// SELECT NEW ID
				// This is a BAD implementation but with this driver it is not possible:
				// - call MSAccess query
				// - obtain the new id using SELECT @@IDENTITY after INSERT
				//
				cstmt = connection.prepareCall("SELECT TOP 1 * FROM tblProvince ORDER BY Id DESC");

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
	public void update(ProvinceDto dto) {
		if (dto != null) {
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"UPDATE tblProvince SET Description = ?, Abbreviation = ?, CountryId = ? WHERE Id = ?");

				cstmt.setString(1, dto.getDescription());
				cstmt.setString(2, dto.getAbbreviation());
				cstmt.setInt(3, dto.getCountryId());
				cstmt.setInt(4, dto.getId());
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
			CallableStatement cstmt = connection.prepareCall("DELETE FROM tblProvince WHERE Id = ?");
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
