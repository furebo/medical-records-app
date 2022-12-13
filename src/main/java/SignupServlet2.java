
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignupServlet2
 */
public class SignupServlet2 extends HttpServlet {
	
	HashMap <String,HashMap<String,String>>usermap = new HashMap<String,HashMap<String,String>>();
	
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		        res.addHeader("Access-Control-Allow-Origin","*");
		        
	            String IncomingFirstName=req.getParameter("firstname");
	            String IncomingLastName=req.getParameter("lastname");
	            String IncomingEmail=req.getParameter("email");
	            String IncomingPassword=req.getParameter("password");
	            
    	 class Users extends User {
    		
    			String firstname;
    			String lastname;
    			String email;
    			String password;
    			String role;
    		
    		Users(String firstname, String lastname, String email, String password,String role){
    			this.firstname=IncomingFirstName;
    			this.lastname=IncomingLastName;
    			this.email=IncomingEmail;
    			this.password=IncomingPassword;
    			this.role=role;
    		}
    		
    	     void signup(String UserRole){
    	    		Users user = new Users(firstname,lastname,email,password,UserRole);
    	    		//System.out.println(user);
    	    		HashMap<String,String>newusermap = new HashMap<String,String>();
    	    		newusermap.put("firstname", user.firstname);
    	    		newusermap.put("lastname", user.lastname);
    	    		newusermap.put("email", user.email);
    	    		newusermap.put("password", user.password);
    	    		newusermap.put("role", user.role);
    	    		
    	    		usermap.put(user.role, newusermap);
    	    
    	    		 for(Entry<String,HashMap<String,String>> m : usermap.entrySet()) {
    	         		System.out.println(m.getValue());
    	         	} 
    	    		
    	    };
    	};
    	if(IncomingPassword.length()==4||IncomingPassword.length()==6||IncomingPassword.length()==8||IncomingPassword.length()==10) {
    		Users Patient = new Users(IncomingFirstName,IncomingLastName,IncomingEmail,IncomingPassword,"Patient");
    	    if(IncomingPassword.length()==4) {
    	    	Patient.signup("Patient");
    	    }else if(IncomingPassword.length()==6) {
    	    	Patient.signup("Phyarmacist");
    	    }else if(IncomingPassword.length()==8) {
    	    	Patient.signup("Physician");
    	    }else if(IncomingPassword.length()==10) {
    	    	Patient.signup("Admin");
    	    }
    		
    	    //System.out.println("The role of the user is: " + Patient.role);
    	    
    	    HttpSession session = req.getSession();
        	session.setAttribute("userdata", usermap);
        	
    		res.sendRedirect("http://localhost:3000/login");
    	}
    	
    	
	};
};





	


