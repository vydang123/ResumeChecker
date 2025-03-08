package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDAO {
	DBUtils utils = new DBUtils();
	Connection conn = utils.makeConnection();;
	PreparedStatement statement = null;
	public void bookAppointment (Appointment appointment) {
		try {
			//WRITE SQL QUERY
			String SQL_QUERY = "INSERT INTO appointment (date, title, price, job_seeker_id, mentor_id) VALUES (?, ?, ?, ?, ?)";
			
			
			//EXECUTE QUERY	
			statement = conn.prepareStatement(SQL_QUERY);
			
			statement.setString(1, appointment.getDate());
			statement.setString(2, appointment.getTitle());
			statement.setInt(3, appointment.getPrice());
			statement.setInt(4, appointment.getJobSeekerID());
			statement.setInt(5, appointment.getMentorID());
			
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
	
	public ArrayList<Appointment> getAppointments(int id) {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            // SQL query to select users with occupation type 2 (mentors)
            String SQL_QUERY = "SELECT * FROM appointment WHERE job_seeker_id = " + id + " OR mentor_id = " + id + " ORDER BY id DESC";

            statement = conn.prepareStatement(SQL_QUERY);
			
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setDate(resultSet.getString("date"));
                appointment.setTitle(resultSet.getString("title"));
                appointment.setPrice(resultSet.getInt("price"));
                appointment.setJobSeekerID(resultSet.getInt("job_seeker_id"));
                appointment.setMentorID(resultSet.getInt("mentor_id"));

                appointments.add(appointment);
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
        System.out.println(appointments);
        return appointments;
    }
	
    public void updateAppointment(Appointment appointment) {
        try {
            String SQL_QUERY = "UPDATE appointment SET date = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
            statement.setString(1, appointment.getDate());
            statement.setInt(2, appointment.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelAppointment(int appointmentId) {
        try {
            String SQL_QUERY = "DELETE FROM appointment WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
            statement.setInt(1, appointmentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment = null;
        try {
            String SQL_QUERY = "SELECT * FROM appointment WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
            statement.setInt(1, appointmentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setDate(resultSet.getString("date"));
                appointment.setTitle(resultSet.getString("title"));
                appointment.setPrice(resultSet.getInt("price"));
                appointment.setJobSeekerID(resultSet.getInt("job_seeker_id"));
                appointment.setMentorID(resultSet.getInt("mentor_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointment;
    }
}
