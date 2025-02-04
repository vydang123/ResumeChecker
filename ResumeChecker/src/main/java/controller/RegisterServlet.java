package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Occupation;
import model.OccupationDAO;
import model.User;
import model.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String firstName = request.getParameter("firstname");
//        String lastName = request.getParameter("lastname");
//        String email = request.getParameter("email");
//        String dob = request.getParameter("dob");
//        String title = request.getParameter("title");
//        String price = request.getParameter("price");
//        String description = request.getParameter("description");
//        String occupation = request.getParameter("occupationId");
//
//        getOccupation(request, response);
//        
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setDob(dob);
//        
//        if (title != null && !title.isEmpty()) {
//            user.setTitle(title);
//        } else {
//            user.setTitle("");
//        }
//        
//        if (price != null && !price.isEmpty()) {
//                user.setPrice(Integer.parseInt(price));
//        } else {
//            user.setPrice(0);
//        }
//
//        if (description != null && !description.isEmpty()) {
//            user.setDescription(description);
//        } else {
//            user.setDescription("");
//        }
//        
//        user.setOccupation(Integer.parseInt(occupation));
//        
//        UserDAO dao = new UserDAO();        
//        dao.register(user);
		System.out.println("Servlet reached!");
		
		try {
		    OccupationDAO occDAO = new OccupationDAO();
		    ArrayList<Occupation> occupations = occDAO.getAllOccupations();
		    System.out.println(occupations);
		    request.setAttribute("ocs", occupations);
		} catch (Exception e) {
		    e.printStackTrace();  // This will show hidden exceptions
		}
//
//		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
//		rd.forward(request, response);
		
		
		UserDAO userDAO = new UserDAO();
		ArrayList <User> users = userDAO.getAllUsers();
		System.out.println(users);
		request.setAttribute("users", users);
		
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
