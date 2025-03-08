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
		AppointmentDAO dao= new AppointmentDAO();
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");        

        ArrayList<Appointment> appointments = dao.getAppointments(user.getId());
        System.out.println("List of appointments: " + appointments);
        
        request.setAttribute("appointments", appointments);

        RequestDispatcher rd=request.getRequestDispatcher("appointments.jsp");
		rd.forward(request, response);
	}

	
	protected void cancelAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
		AppointmentDAO dao = new AppointmentDAO();
		dao.cancelAppointment(appointmentId);
		response.sendRedirect("AppointmentServlet");
		
	}

	protected void updateAppointment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
        String newDate = request.getParameter("newDate") + " " + request.getParameter("newTime");

        AppointmentDAO dao = new AppointmentDAO();
        Appointment appointment = dao.getAppointmentById(appointmentId);

        appointment.setDate(newDate);
        
        dao.updateAppointment(appointment);

        // Redirect back to the appointment list after update
        response.sendRedirect("AppointmentServlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		doGet(request, response);
	}

}
