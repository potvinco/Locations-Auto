package alv.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionAdapter {
	// private static final String DEFAULT_URL = "jdbc:odbc:Driver={Microsoft Access
	// Driver (*.mdb)}; DBQ=C:\\UQO\\2018-3-INF1163-01 Modélisation et conception
	// orientée objet\\Java\\SQLProject\\data\\alv.mdb;";
	// private static final String SQL_FIND_ALL_EVENTS = "SELECT * FROM tblClient";

	protected Connection connection;

	public ConnectionAdapter(Connection connection) {
		this.connection = connection;
	}

	public static Connection createConnection(String driver, String url, String username, String password)
			throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		if ((username == null) || (password == null) || (username.trim().length() == 0)
				|| (password.trim().length() == 0)) {
			return DriverManager.getConnection(url);
		} else {
			return DriverManager.getConnection(url, username, password);
		}
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection connection) {
		try {
			if (connection != null) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected static List<Map<String, Object>> map(ResultSet rs) throws SQLException {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		try {
			if (rs != null) {
				ResultSetMetaData meta = rs.getMetaData();
				int numColumns = meta.getColumnCount();
				while (rs.next()) {
					Map<String, Object> row = new HashMap<String, Object>();
					for (int i = 1; i <= numColumns; ++i) {
						String name = meta.getColumnName(i);
						Object value = rs.getObject(i);
						row.put(name, value);
					}
					results.add(row);
				}
			}
		} finally {
			close(rs);
		}
		return results;
	}

	public static List<Map<String, Object>> query(Connection connection, String sql, List<Object> parameters)
			throws SQLException {
		List<Map<String, Object>> results = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);

			int i = 0;
			for (Object parameter : parameters) {
				ps.setObject(++i, parameter);
			}
			rs = ps.executeQuery();
			results = map(rs);
		} finally {
			close(rs);
			close(ps);
		}
		return results;
	}
}
