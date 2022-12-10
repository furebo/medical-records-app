
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet2
 */
public class SignupServlet2 extends HttpServlet {
	
	HashMap <String,Object>usermap;
	
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.addHeader("Access-Control-Allow-Origin","*");
    	String firstname = req.getParameter("firstname");
    	String password = req.getParameter("password");
    	String email = req.getParameter("email");
    	String lastname = req.getParameter("lastname");
    	
    	 class Users extends User {
    		String firstname;
    		String lastname;
    		String email;
    		String password;
    		String role;
    		
    		Users(String firstname, String lastname, String email, String password,String role){
    			this.firstname=firstname;
    			this.lastname=lastname;
    			this.email=email;
    			this.password=password;
    			this.role=role;
    		}
    	    void signup() {
    	    	if(password.length()==6) {
    	    		Users patient = new Users(firstname,lastname,email,password,"Patient");
    	    		usermap.put("patient", patient);
    	    		try {
						res.sendRedirect("http://localhost:3000/login");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}else if(password.length()==4) {
    	    		Users pharmacist = new Users(firstname,lastname,email,password,"Patient");
    	    		usermap.put("pharmacist", pharmacist);
    	    		try {
						res.sendRedirect("http://localhost:3000/login");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}else if(password.length()==8) {
    	    		Users physician = new Users(firstname,lastname,email,password,"Patient");
    	    		usermap.put("physician", physician);
    	    		try {
						res.sendRedirect("http://localhost:3000/login");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}else if(password.length()==10) {
    	    		Users admin = new Users(firstname,lastname,email,password,"Patient");
    	    		usermap.put("admin", admin);
    	    		try {
						res.sendRedirect("http://localhost:3000/login");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}
    	    };
    	}
	}




	

}
