package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appointment;
import model.AppointmentDAO;
import model.EmailUtils;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String DEFAULT_ACTION = "DEFAULT";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") == null ? DEFAULT_ACTION : request.getParameter("action");
		switch (action) {
		case "CANCEL": {
			cancelAppointment(request, response);
			break;
		}
		case "UPDATE": {
			updateAppointment(request, response);
			break;
		}
		default:
			loadDefault(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void loadDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Map<Integer, String> jobSeekerNames = new HashMap<>();
	    Map<Integer, String> mentorNames = new HashMap<>();
		
		
		AppointmentDAO dao= new AppointmentDAO();
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");   

        ArrayList<Appointment> appointments = dao.getAppointments(user.getId());
        System.out.println("List of appointments: " + appointments);
        
	    for (Appointment appointment : appointments) {
	    	
			UserDAO userDao = new UserDAO();
			User jobSeeker = userDao.getUserByID(appointment.getJobSeekerID());
			User mentor = userDao.getUserByID(appointment.getMentorID());
			System.out.println("Job Seeker: " + jobSeeker);
			System.out.println("Mentor: " + mentor);
			
	        String jobSeekerName = jobSeeker.getFirstName() + " " + jobSeeker.getLastName();
            String mentorName = mentor.getFirstName() + " " + mentor.getLastName();
            System.out.println(jobSeekerName);
            System.out.println(mentorName);

            jobSeekerNames.put(appointment.getJobSeekerID(), jobSeekerName);
            mentorNames.put(appointment.getMentorID(), mentorName);
	    }
        
        request.setAttribute("appointments", appointments);
        request.setAttribute("jobSeekerNames", jobSeekerNames);
        request.setAttribute("mentorNames", mentorNames);

        RequestDispatcher rd=request.getRequestDispatcher("appointments.jsp");
		rd.forward(request, response);
	}

	
	protected void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		AppointmentDAO dao = new AppointmentDAO();
		Appointment app = dao.getAppointmentById(appointmentId);
		
		UserDAO userDao = new UserDAO();
		User jobSeeker = userDao.getUserByID(app.getJobSeekerID());
		User mentor = userDao.getUserByID(app.getMentorID());
		
		// Send email cancellation
        String subject = "Appointment Cancellation";
        String jobSeekerMessage = "Dear " + jobSeeker.getFirstName() + " " + jobSeeker.getLastName() 
        							+ ",\n\nYour appointment with " + mentor.getFirstName() + " " + mentor.getLastName() 
        							+ " on " + app.getDate() + " is CANCELLED" 
        							+ "\n\nThank you!";
        String mentorMessage = "Dear " + mentor.getFirstName() + " " + mentor.getLastName() 
        						+ ",\n\nYour appointment with " + jobSeeker.getFirstName() + " " + jobSeeker.getLastName() 
        						+ " on " + app.getDate() + " is CANCELLED" 
        						+ "\n\nThank you!";
        
        System.out.println("user email: "+jobSeeker.getEmail());
        System.out.println("metor email: " + mentor.getEmail());
        EmailUtils.sendEmail(jobSeeker.getEmail(), subject, jobSeekerMessage);
        EmailUtils.sendEmail(mentor.getEmail(), subject, mentorMessage);
        
        dao.cancelAppointment(appointmentId);
        
		response.sendRedirect("AppointmentServlet");
		
	}

	protected void updateAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
        String newDate = request.getParameter("newDate") + " " + request.getParameter("newTime");

        AppointmentDAO appDao = new AppointmentDAO();
        Appointment appointment = appDao.getAppointmentById(appointmentId);

        appointment.setDate(newDate);
        
        appDao.updateAppointment(appointment);
        
        UserDAO userDao = new UserDAO();
		User jobSeeker = userDao.getUserByID(appointment.getJobSeekerID());
		User mentor = userDao.getUserByID(appointment.getMentorID());
		
        // Send email update
        String subject = "Appointment Update";
        String jobSeekerMessage = "Dear " + jobSeeker.getFirstName() + " " + jobSeeker.getLastName() 
        							+ ",\n\nYour appointment with " + mentor.getFirstName() + " " + mentor.getLastName() 
        							+ " is confirmed and updated for " + appointment.getDate() 
        							+ ".\n\nTitle: " + appointment.getTitle() + "\nPrice: " + mentor.getPrice() 
        							+ "\n\nThank you!";
        String mentorMessage = "Dear " + mentor.getFirstName() + " " + mentor.getLastName() 
        							+ ",\n\nYour appointment with " + jobSeeker.getFirstName() + " " +  jobSeeker.getLastName() 
        							+ " is updated for " + appointment.getDate() + ".\n\nTitle: " + appointment.getTitle() 
        							+ "\n\nThank you!";
        
        System.out.println("user email: "+jobSeeker.getEmail());
        System.out.println("metor email: " + mentor.getEmail());
        EmailUtils.sendEmail(jobSeeker.getEmail(), subject, jobSeekerMessage);
        EmailUtils.sendEmail(mentor.getEmail(), subject, mentorMessage);

        // Redirect back to the appointment list after update
        response.sendRedirect("AppointmentServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		doGet(request, response);
	}

}
