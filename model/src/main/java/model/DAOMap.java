package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The Class DAOMap.
 *
 */
class DAOMap {

	
	private Connection connection;

	/**
	 * Instantiating a new DAO map.
	 *
	 * 
	 */
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	
	public boolean create(final Map entity) {
		
		return false;
	}

	
	public boolean delete(final Map entity) {
		
		return false;
	}

	
	public boolean update(final Map entity) {
		
		return false;
	}

	/**
	 * Finds the map
	 * @param id Map ID from DB
	 * @return Map
	 */
	public Map find(final int id) {
		Map map = new Map();

		try {
			final String sql = "CALL getMap(?)";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet result = call.getResultSet();
			result.next();
			map = new Map(result.getObject(1).toString(), (int) result.getObject(2), (int) result.getObject(3), (int) result.getObject(4));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return map;
	}


	public Map find(final String code) {
		return null;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
}

