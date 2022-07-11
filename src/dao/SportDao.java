package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Sport;

public class SportDao {
	
	private Connection connection;
	private final String GET_SPORTS_QUERY = "SELECT * FROM sports";
	private final String CREATE_NEW_SPORT_QUERY = "INSERT INTO sports(name) VALUES(?)";
	private final String DELETE_SPORT_BY_ID_QUERY = "DELETE FROM sports WHERE sport_id = ?";
	private final String UPDATE_SPORT_BY_ID_QUERY = "UPDATE sports SET name = ? WHERE sport_id = ?";
	
	public SportDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Sport> getSports() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_SPORTS_QUERY).executeQuery();
		List<Sport> sports = new ArrayList<Sport>();
		
		while (rs.next()) {
			sports.add(new Sport(rs.getInt(1), rs.getString(2)));
		}
		return sports;
		
	}
	
	public void createNewSport(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_SPORT_QUERY);
		ps.setString(1, name);
		ps.executeUpdate();
	}
	
	public void deleteSport(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SPORT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateSport(String new_sport, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_SPORT_BY_ID_QUERY);
		ps.setInt(2, id);
		ps.setString(1, new_sport);
		ps.executeUpdate();
	}
	
}
