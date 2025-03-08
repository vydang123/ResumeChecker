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
                
                System.out.println(loggedInUser);
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
				System.out.println(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public ArrayList<User> getMentors() {
        ArrayList<User> mentors = new ArrayList<>();
        try {
            // SQL query to select users with occupation type 2 (mentors)
            String SQL_QUERY = "SELECT * FROM user WHERE occupation_id = 2";

            statement = conn.prepareStatement(SQL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User mentor = new User();
                mentor.setId(resultSet.getInt("id"));
                mentor.setUsername(resultSet.getString("username"));
                mentor.setFirstName(resultSet.getString("first_name"));
                mentor.setLastName(resultSet.getString("last_name"));
                mentor.setEmail(resultSet.getString("email"));
                mentor.setTitle(resultSet.getString("title"));
                mentor.setPrice(resultSet.getInt("price"));
                mentor.setDescription(resultSet.getString("description"));
                mentor.setOccupation(resultSet.getInt("occupation_id"));

                mentors.add(mentor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return mentors;
    }
    
    public User getUser(String username, String password) {
		try {
			//WRITE SQL QUERY
			String SQL_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
			
			
			//EXECUTE QUERY	
			statement = conn.prepareStatement(SQL_QUERY);
			statement.setString(1, username);
			statement.setString(2, password);
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
                
                System.out.println(loggedInUser);
                return loggedInUser;
                
            }
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
    
    public void updateUser(User user) {
        try {
            // SQL query to update user details
            String SQL_QUERY = "UPDATE user SET first_name = ?, last_name = ?, email = ?, dob = ?, title = ?, price = ?, description = ? WHERE id = ?";
            
            // Prepare the statement
            statement = conn.prepareStatement(SQL_QUERY);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getDob());
            statement.setString(5, user.getTitle());
            statement.setInt(6, user.getPrice());
            statement.setString(7, user.getDescription());
            statement.setInt(8, user.getId());
            
            // Execute the update
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public User getUserByID(int id) {
		try {
			//WRITE SQL QUERY
			String SQL_QUERY = "SELECT * FROM user WHERE id = ?";
			
			
			//EXECUTE QUERY	
			statement = conn.prepareStatement(SQL_QUERY);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
                // Populate JobSeeker object with data from the database
                User mentor = new User();
                mentor.setId(resultSet.getInt("id"));
                mentor.setUsername(resultSet.getString("username"));
                mentor.setPassword(resultSet.getString("password"));
                mentor.setFirstName(resultSet.getString("first_name"));
                mentor.setLastName(resultSet.getString("last_name"));
                mentor.setEmail(resultSet.getString("email"));
                mentor.setDob(resultSet.getString("dob"));
                mentor.setDescription(resultSet.getString("description"));
                mentor.setTitle(resultSet.getString("title"));
                mentor.setPrice(resultSet.getInt("price"));
                mentor.setOccupation(resultSet.getInt("occupation_id"));
                
                return mentor;
                
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
