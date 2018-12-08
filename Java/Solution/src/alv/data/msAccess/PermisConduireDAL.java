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

import alv.data.PermisConduireDto;
import alv.data.ConnectionAdapter;
import alv.data.IPermisConduireDAL;

public class PermisConduireDAL extends ConnectionAdapter implements IPermisConduireDAL {

	public PermisConduireDAL(Connection connection) {
		super(connection);
	}

	@Override
	public PermisConduireDto fetch(int id) {
		PermisConduireDto dto = new PermisConduireDto();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {
			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblPermisConduire WHERE Id = ?");
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
	public int insert(PermisConduireDto dto) {
		if (dto != null) {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"INSERT INTO tblPermisConduire ( Numero, PersonneId, CountryId, ProvinceId, ClassePermisConduireId, DateExpiration, DateEmission) VALUES( ?, ?, ?, ?, ?, ?, ?)");

				cstmt.setString(1, dto.getNumero());
				cstmt.setInt(2, dto.getPersonneId());
				cstmt.setString(3, dto.getCountry());
				cstmt.setString(4, dto.getProvince());
				cstmt.setInt(5, dto.getClassePermisConduireId());
				//cstmt.setDate(6, Date.valueOf(dto.getDateExpiration()));
				if(dto.getDateExpiration()==null)
					cstmt.setNull(6,java.sql.Types.DATE);
				else
					cstmt.setDate(6,Date.valueOf(dto.getDateExpiration()));
				
				
				//cstmt.setDate(7, Date.valueOf(dto.getDateEmission()));
				if(dto.getDateEmission()==null)
					cstmt.setNull(7,java.sql.Types.DATE);
				else
					cstmt.setDate(7,Date.valueOf(dto.getDateEmission()));
				cstmt.executeUpdate();

				// SELECT NEW ID
				// This is a BAD implementation but with this driver it is not possible:
				// - call MSAccess query
				// - obtain the new id using SELECT @@IDENTITY after INSERT
				//
				cstmt = connection.prepareCall("SELECT TOP 1 * FROM tblPermisConduire ORDER BY Id DESC");

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
	public void update(PermisConduireDto dto) {
		if (dto != null) {
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"UPDATE tblPermisConduire SET Numero = ?, PersonneId = ?, CountryId = ?, ProvinceId = ?, ClassePermisConduireId = ?, DateExpiration = ?, DateEmission = ? WHERE Id = ?");

				cstmt.setString(1, dto.getNumero());
				cstmt.setInt(2, dto.getPersonneId());
				cstmt.setString(3, dto.getCountry());
				cstmt.setString(4, dto.getProvince());
				cstmt.setInt(5, dto.getClassePermisConduireId());
				//cstmt.setDate(6, Date.valueOf(dto.getDateExpiration()));
				if(dto.getDateExpiration()==null)
					cstmt.setNull(6,java.sql.Types.DATE);
				else
					cstmt.setDate(6,Date.valueOf(dto.getDateExpiration()));
				
				//cstmt.setDate(7, Date.valueOf(dto.getDateEmission()));
				if(dto.getDateEmission()==null)
					cstmt.setNull(7,java.sql.Types.DATE);
				else
					cstmt.setDate(7,Date.valueOf(dto.getDateEmission()));
				cstmt.setInt(8, dto.getId());
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
			CallableStatement cstmt = connection.prepareCall("DELETE FROM tblPermisConduire WHERE Id = ?");
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
