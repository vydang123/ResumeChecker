package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_ACTION = "DEFAULT";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") == null ? DEFAULT_ACTION : request.getParameter("action");
		switch (action) {
		case "GET_PROFILE": {
			getProfile(request, response);
			break;
		}

		default:
			modifyProfile(request, response);
		}
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void modifyProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        
        

        // Create a User object with the updated information
        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        System.out.println(user);
        if (firstName != null && !firstName.isEmpty()) {
            user.setFirstName(firstName);
        } else {
        	 user.setFirstName("");
        }
        if (lastName != null && !lastName.isEmpty()) {
            user.setLastName(lastName);
        } else {
        	user.setLastName("");
        }
        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        } else {
        	user.setEmail("");
        }
        if (dob != null && !dob.isEmpty()) {
            user.setDob(dob);
        } else {
        	user.setDob("");
        }
        
        if (title != null && !title.isEmpty()) {
            user.setTitle(title);
        } else {
            user.setTitle("");
        }
        
        if (price != null && !price.isEmpty()) {
                user.setPrice(Integer.parseInt(price));
        } else {
            user.setPrice(0);
        }

        if (description != null && !description.isEmpty()) {
            user.setDescription(description);
        } else {
            user.setDescription("");
        }
        

        // Update the user in the database
        UserDAO userDAO = new UserDAO();
        userDAO.updateUser(user);

        // Redirect back to the profile page
        response.sendRedirect("profile.jsp");
    }
	
	protected void getProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
