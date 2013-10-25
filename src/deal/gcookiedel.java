package deal;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class gcookiedel extends HttpServlet{
	
	//	@SuppressWarnings("unchecked")
	//	@RequestMapping(value = "/oauth2callback", method = RequestMethod.GET)
			public void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws IOException {
				HttpSession session = req.getSession();
				Cookie c2=new Cookie("refreshtoken","all"); 
				c2.setDomain("rnak-1991.appspot.com");
				
				c2.setMaxAge(0);
				resp.addCookie(c2);
				Cookie c1=new Cookie("hello","all"); 
				c1.setDomain("rnak-1991.appspot.com");
				
				c1.setMaxAge(0);
				resp.addCookie(c1);
				session.invalidate();
				resp.sendRedirect("index.html");

}
}