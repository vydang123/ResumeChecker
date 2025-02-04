package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	DBUtils utils = new DBUtils();
	Connection conn = utils.makeConnection();;
	PreparedStatement statement = null;

	public User login(User user) {
		try {
			//WRITE SQL QUERY
			String SQL_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
			
			
			//EXECUTE QUERY	
			statement = conn.prepareStatement(SQL_QUERY);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
                // Populate JobSeeker object with data from the database
                User loggedInUser = new User();
                loggedInUser.setId(resultSet.getInt("id"));
                loggedInUser.setUsername(resultSet.getString("username"));
                loggedInUser.setPassword(resultSet.getString("password"));
                loggedInUser.setFirstName(resultSet.getString("first_name"));
                loggedInUser.setLastName(resultSet.getString("last_name"));
                loggedInUser.setEmail(resultSet.getString("email"));
                loggedInUser.setDob(resultSet.getString("dob"));
                loggedInUser.setDescription(resultSet.getString("description"));
                loggedInUser.setTitle(resultSet.getString("title"));
                loggedInUser.setPrice(resultSet.getInt("price"));
                loggedInUser.setOccupation(resultSet.getInt("occupation_id"));
                
                return loggedInUser;
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			}catch (SQLException ex) {
				
			}
		}
		
		return null;
	}
	
	public void register (User user) {
		try {
			//WRITE SQL QUERY
			String SQL_QUERY = "INSERT INTO user (username, password, first_name, last_name, email, dob, title, price, description, occupation_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			
			//EXECUTE QUERY	
			statement = conn.prepareStatement(SQL_QUERY);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getDob());
			statement.setString(7, user.getTitle());
			statement.setInt(8, user.getPrice());
			statement.setString(9, user.getDescription());
			statement.setInt(10, user.getOccupation());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conn.close();
			}catch (SQLException ex) {
				
			}
		}

	}
	
	public ArrayList<User> getAllUsers () {
		try {
			ArrayList<User> list = new ArrayList<User>();
			DBUtils utils = new DBUtils();
			Connection conn = utils.makeConnection();
			//WRITE SQL QUERY
			String SQL_QUERY = "SELECT * FROM user";
			
			
			//EXECUTE QUERY	
			PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
			ResultSet resultSet = statement.executeQuery();
			
			
			//READ RESULTSET
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("first_name");
				String lastname = resultSet.getString("last_name");
				
				
				User user = new User();
				user.setId(id);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				list.add(user);
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
