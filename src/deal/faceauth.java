package deal;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class faceauth extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {     
    	
    	
    	 String na="",value="";
		  
		  Cookie[] cookie_jar = req.getCookies();

			if (cookie_jar != null)
			{
				for (int i =0; i< cookie_jar.length; i++)
				{
					Cookie aCookie = cookie_jar[i];
					na =aCookie.getName();
					
					
					if("app3".equals(na)){
						value=aCookie.getValue();
					}
					
				}
			}
    	
    	
    	
    	
    	
    	
    	
    	
        String code = req.getParameter("code");
        String redirecturi="http://www.facebook.com/dialog/oauth/?"+
                   "client_id=314562382019222&"+
                   "redirect_uri=http://rnak-1991.appspot.com/faceauth&"+
                   "scope=email,read_friendlists"+
                   "&state=0";
        if (code == null || code.equals("")) {
        	//res.getWriter().println("going for redirection");
        	res.sendRedirect(redirecturi);
        }
        else{
        HttpSession session = req.getSession();
        session.setAttribute("code", code);
        String token = null;
        try {
        	
            String g = "https://graph.facebook.com/oauth/access_token?client_id=314562382019222&redirect_uri=http://rnak-1991.appspot.com/faceauth&client_secret=5ec39984b76d196e901fa68c1e0401ad&code=" + code;
            URL u = new URL(g);
            URLConnection c = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String inputLine;
            StringBuffer b = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                b.append(inputLine + "\n");            
            in.close();
            token = b.toString();
            
            
            
            Cookie c1=new Cookie("facebook","all"); 
			c1.setDomain("rnak-1991.appspot.com");
			c1.setValue(token);
			c1.setMaxAge(60*60*24);
			res.addCookie(c1);
			
			if(value==null||value==""){
				res.sendRedirect("facebooktoken.jsp");
				}else
				{
					res.sendRedirect("facebooktoken2.jsp");
				}
			
			
			res.sendRedirect("facebooktoken.jsp");
           /* if (token.startsWith("{"))
                throw new Exception("error on requesting token: " + token + " with code: " + code);*/
        	} catch (Exception e) {
               
        	}
        				
        }
    }
}
