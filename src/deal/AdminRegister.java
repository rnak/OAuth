package deal;


import java.io.IOException;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import javax.servlet.http.*;

//upload image part

@SuppressWarnings("serial")
public class AdminRegister extends HttpServlet {
	
			
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		
		
		resp.setContentType("text/plain");
		double a=0;
		String one=req.getParameter("one");
		String two=req.getParameter("two");
		String three=req.getParameter("three");
		String four=req.getParameter("four");
		String five=req.getParameter("five");
		String e=req.getParameter("email");
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		admin admin=new admin();
		Query q=pm.newQuery(admin.class,"eid==e");
		q.declareParameters("String e");
		
		List<testing> results = (List<testing>)q.execute(e); 
		
		if(results.size()==0)
		{
			 admin.setOne(one);
             admin.setTwo(two);
             admin.setThree(three);
             admin.setFour(four);
             admin.setFive(five);
             admin.setEid(e);
         
		
        try 
        {
            pm.makePersistent(admin);
        }
        
        catch(Exception ex)
        {
        	ex.printStackTrace();
        	
            
        }finally{
        pm.close();
        resp.sendRedirect("index.html");
        }
        }
       /* if(u.equals(p))
        {
        	resp.sendRedirect("index.html");
        	
        }
        else
        {
        	resp.sendRedirect("fail.html");
        }
        
*/    
        
			// TODO Auto-generated catch block
			//e1.printStackTrace();
				
		
       
//		resp.sendRedirect("jata.jsp");
		

	}
}
