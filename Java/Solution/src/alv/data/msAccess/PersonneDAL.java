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
import alv.data.IPersonneDAL;
import alv.data.PersonneDto;

public class PersonneDAL extends ConnectionAdapter implements IPersonneDAL {

	public PersonneDAL(Connection connection) {
		super(connection);
	}

	@Override
	public PersonneDto fetch(int id) {
		PersonneDto dto = new PersonneDto();
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		Statement st = null;
		ResultSet rs = null;
		try {

			CallableStatement cstmt = connection.prepareCall("SELECT * FROM tblPersonne WHERE Id = ?");
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
	public int insert(PersonneDto dto) {
		if (dto != null) {
			List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"INSERT INTO tblPersonne ( Nom, Prenom, Telephone, DateNaissance, AdresseId) VALUES( ?, ?, ?, ?, ?)");

				cstmt.setString(1, dto.getNom());
				cstmt.setString(2, dto.getPrenom());
				cstmt.setString(3, dto.getTelephone());
				cstmt.setDate(4, Date.valueOf(dto.getDateNaissance()));
				cstmt.setInt(5, dto.getAdresseId());
				cstmt.executeUpdate();

				// SELECT NEW ID
				// This is a BAD implementation but with this driver it is not possible:
				// - call MSAccess query
				// - obtain the new id using SELECT @@IDENTITY after INSERT
				//
				cstmt = connection.prepareCall("SELECT TOP 1 * FROM tblPersonne ORDER BY Id DESC");

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
	public void update(PersonneDto dto) {
		if (dto != null) {
			Statement st = null;
			ResultSet rs = null;
			try {

				CallableStatement cstmt = connection.prepareCall(
						"UPDATE tblPersonne SET Nom = ?, Prenom = ?, Telephone = ?, DateNaissance = ?, AdresseId = ? WHERE Id = ?");

				cstmt.setString(1, dto.getNom());
				cstmt.setString(2, dto.getPrenom());
				cstmt.setString(3, dto.getTelephone());
				cstmt.setDate(4, Date.valueOf(dto.getDateNaissance()));
				cstmt.setInt(5, dto.getAdresseId());
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
			CallableStatement cstmt = connection.prepareCall("DELETE FROM tblPersonne WHERE Id = ?");
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
