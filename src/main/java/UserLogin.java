import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.addHeader("Access-Control-Allow-Origin","*");
    	String IncomingPassword = req.getParameter("password");
    	String IncomingEmail = req.getParameter("email");
    	
    
    	HttpSession session = req.getSession();
    	HashMap<String,HashMap<String,String>> userdata = (HashMap<String,HashMap<String,String>>)session.getAttribute("userdata");
    	
    	System.out.println(userdata);
    	
    	HashMap<String,String> IncomingUser=new HashMap<String,String>();
    	
    	 for(Entry<String,HashMap<String,String>> m : userdata.entrySet()) {
      	    IncomingUser=m.getValue();
      	}
    	 System.out.println(IncomingUser);
    	 
 
    	 for(Entry m: IncomingUser.entrySet()) {
    		 if( m.getKey().equals("password")&m.getValue().equals(IncomingPassword)) {
    			 
    				if(IncomingPassword.length()==4) {
    					SignupServlet2 signedeup = new SignupServlet2();
    			    	try {
    						res.sendRedirect("http://localhost:3000/patients");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    					
    				}else if(IncomingPassword.length()==6) {
    					try {
    						res.sendRedirect("http://localhost:3000/pharmacists");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    				}else if(IncomingPassword.length()==8) {
    					try {
    						res.sendRedirect("http://localhost:3000/physicians");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    				}else if(IncomingPassword.length()==8) {
    					try {
    						res.sendRedirect("http://localhost:3000/users");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    				}
    			 
    		 }
    	 }
    	
 	
    	
    	 class Login extends User {
    		String email;
    		String password;
    		
    		Login(String email, String password){
    			this.email=IncomingEmail;
    			this.password=IncomingPassword;
    		}
    		
    		 void signup() {
     	    	System.out.println("The user is registered.");
     	    };
  
    	}	
    }
}
