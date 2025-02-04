package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OccupationDAO {
	public ArrayList<Occupation> getAllOccupations () {
		try {
			ArrayList<Occupation> list = new ArrayList<Occupation>();
			DBUtils utils = new DBUtils();
			Connection conn = utils.makeConnection();
			//WRITE SQL QUERY
			String SQL_QUERY = "SELECT * FROM `occupation`";
			System.out.println("Preparing to execute query...");
			
			
			//EXECUTE QUERY	
			PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
			System.out.println("Statement prepared successfully.");
			ResultSet resultSet = statement.executeQuery();
			
			System.out.println("Query executed.");  // Add this line 
			//READ RESULTSET
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String occupation = resultSet.getString("occupation");
				
				Occupation occupations = new Occupation(id, occupation);
				list.add(occupations);	
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
