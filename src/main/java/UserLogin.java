import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.addHeader("Access-Control-Allow-Origin","*");
    	String password = req.getParameter("password");
    	String email = req.getParameter("email");
    	
    	 class Login extends User {
    		String email;
    		String password;
    		
    		Login(String email, String password){
    			this.email=email;
    			this.password=password;
    		}
    		void login() {
    			SignupServlet2 signedeup = new SignupServlet2();
    			if(password.length()==4) {
    		    	for(Entry user : signedeup.usermap.entrySet()) {
    		    		if(user.getKey()=="pharmacist") {
    		    			try {
								res.sendRedirect("http://localhost:3000/pharmacists");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    		    		}
    		    	}
    				
    			}else if(password.length()==6) {
    				for(Entry user : signedeup.usermap.entrySet()) {
    					if(user.getKey()=="patient") {
    						try {
								res.sendRedirect("http://localhost:3000/patients");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    					}
    				}
    			}else if(password.length()==8) {
    				for(Entry user : signedeup.usermap.entrySet()) {
    					if(user.getKey()=="physician") {
    						try {
								res.sendRedirect("http://localhost:3000/physicians");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    					}
    				}
    			}else if(password.length()==10) {
    				for(Entry user : signedeup.usermap.entrySet()) {
    					if(user.getKey()=="admin") {
    						try {
								res.sendRedirect("http://localhost:3000/users");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
    					}
    				}
    			}
    		};
    	    void signup() {
    	    	System.out.println("The user is registered.");
    	    };
    	}	
    	
	}
}
