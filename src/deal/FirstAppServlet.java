package deal;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FirstAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		String e=req.getParameter("email");
		System.out.println(u);
		System.out.println(p);
		System.out.println(e);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		testing test=new testing();
		Query q=pm.newQuery(testing.class,"username==u");
		q.declareParameters("String u");
		
		List<testing> results = (List<testing>)q.execute(u); 

		if(results.size()==0)
		{
			
			test.setUserName(u);
             test.setPaswrd(p);
             test.setEid(e);
		}

		
        try 
        {
            pm.makePersistent(test);
        }
        
        catch(Exception ex)
        {
        	ex.printStackTrace();
        	
            
        }
        pm.close();
       /* if(u.equals(p))
        {
        	resp.sendRedirect("index.html");
        	
        }
        else
        {
        	resp.sendRedirect("fail.html");
        }
        
*/    
       
		resp.sendRedirect("redirect.jsp");
		

	}
}
