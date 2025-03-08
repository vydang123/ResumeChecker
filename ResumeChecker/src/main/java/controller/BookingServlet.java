package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Appointment;
import model.AppointmentDAO;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String DEFAULT_ACTION = "DEFAULT";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mentorID = request.getParameter("mentorID");
	    System.out.println("mentor ID: "+ mentorID);
		String action = request.getParameter("action") == null ? DEFAULT_ACTION : request.getParameter("action");
		switch (action) {
		case "BOOK_APPOINTMENT": {
			bookAppointment(request, response);
			break;
		}
		default:
			defaultLoad(mentorID, request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void defaultLoad(String mentorID, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User mentor = new User();
        UserDAO userDAO = new UserDAO();
        mentor = userDAO.getUserByID(Integer.parseInt(mentorID));
        System.out.println("Selected mentor: " + mentor);
        
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        System.out.println("session user: " + user);
        System.out.println("session user id: "+user.getId());
    
        
        request.setAttribute("mentor", mentor);
		
		RequestDispatcher rd=request.getRequestDispatcher("appointment.jsp");
		rd.forward(request, response);
	}

	
	protected void bookAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mentorID = request.getParameter("mentorID");
	    System.out.println("mentor ID: "+ mentorID);
	    
		String title = request.getParameter("title");
        String date = request.getParameter("date");
        System.out.println("mentor ID: "+ mentorID);
        System.out.println("Date: "+ date);
        System.out.println("Title: " + title);
        
        User mentor = new User();
        UserDAO userDAO = new UserDAO();
        mentor = userDAO.getUserByID(Integer.parseInt(mentorID));
        System.out.println("Selected mentor: " + mentor);
        
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        System.out.println("session user: " + user);
        System.out.println("session user id: "+user.getId());
        
        Appointment appointment = new Appointment();
        AppointmentDAO dao = new AppointmentDAO();
        
        appointment.setDate(date);
        appointment.setPrice(mentor.getPrice());
        appointment.setTitle(title);
        appointment.setJobSeekerID(user.getId());
        appointment.setMentorID(mentor.getId());
        
        dao.bookAppointment(appointment);
        
        response.sendRedirect("AppointmentServlet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
