
package deal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;








//import com.acti.util.StringConverterUtil;
import com.google.gdata.client.*;
import com.google.gdata.client.contacts.*;
import com.google.gdata.data.*;
import com.google.gdata.data.contacts.*;
import com.google.gdata.data.extensions.*;
import com.google.gdata.util.*;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gson.JsonObject;
public class authocontact extends HttpServlet{
			@SuppressWarnings("null")
			public void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws IOException {
			    
				  HttpSession session = req.getSession();
				
		//		  String email="",name="",emailID="",nameID="",genderID="",imageID="",na="",value="";
				  
				
					
					String redirectUrl=	"https://accounts.google.com/o/oauth2/auth?"+
							"access_type=offline&"+
							"client_id=1019109411027.apps.googleusercontent.com&"+
							"redirect_uri=http://rnak-1991.appspot.com/authocontact&"+
							"response_type=code&"+
							"scope=https://www.google.com/m8/feeds+https://www.googleapis.com/auth/calendar&"+
							"v=3.0";

				String code = req.getParameter("code");
				System.out.println(code +":::: is code");
				
					if(code == null)
					
				{
						resp.sendRedirect(redirectUrl); 
		        }
					
				else 
				{
					
					session.setAttribute("code",code);
					System.out.println("codde:"+code);
					GoogleAuthorizationCodeTokenRequest authorizationTokenRequest = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),  new JacksonFactory(), "1019109411027.apps.googleusercontent.com", "OzVOEtw1iqot606iBe3pTuv2", req.getParameter("code"), "http://rnak-1991.appspot.com/authocontact");
					GoogleTokenResponse tokenResponse = authorizationTokenRequest.execute();
					String accesstoken=tokenResponse.getAccessToken();
					accesstoken=tokenResponse.getAccessToken();
					try{
						
						 URL url = new URL("https://www.googleapis.com/calendar/v3/calendars/ronak.anil@a-cti.com/events");

						  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						  connection.setDoInput(true);
						  connection.setDoOutput(true);
						  connection.setRequestMethod("GET");
						  connection.setReadTimeout(60000);
						  connection.setConnectTimeout(60000);
						  
						  if(accesstoken != null){
						   connection.setRequestProperty("Authorization", "Bearer " + accesstoken);
						   connection.setRequestProperty("Gdata-version", "3.0");
						  }
						  
						
						  connection.setRequestProperty("Content-Type","application/json"); 
						  
						  StringBuffer contacts=new StringBuffer();
						  if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
							 
						   BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

						   String responseString = "";
						   while ((responseString = reader.readLine()) != null) {
						    
							   
							   contacts.append(responseString);
							   
						   }
						contacts.toString();
						   resp.getWriter().println("code"+contacts);
						  }
						
						
						
					}catch(Exception e){
						resp.getWriter().println("calender error");
					}
					try{
					
					 URL url = new URL("https://www.google.com/m8/feeds/contacts/default/full/");

					  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					  connection.setDoInput(true);
					  connection.setDoOutput(true);
					  connection.setRequestMethod("GET");
					  connection.setReadTimeout(60000);
					  connection.setConnectTimeout(60000);
					  
					  if(accesstoken != null){
					   connection.setRequestProperty("Authorization", "Bearer " + accesstoken);
					   connection.setRequestProperty("Gdata-version", "3.0");
					  }
					  
					  connection.setRequestProperty("Content-Type","application/json"); 
					
					  StringBuffer contacts=new StringBuffer();
					  if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
						 
					   BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					   
					   String responseString = "";
					   while ((responseString = reader.readLine()) != null) {
					    
						   resp.getWriter().println(responseString);
					   }
					   resp.getWriter().println(contacts);
					  }
				
				}catch(Exception e){
					resp.getWriter().println("contact error");
					
				}
					}
				/* String ip1 = req.getHeader("Remote_Addr");
				//  If this code returns empty string, then use this way:

				  String ip2= req.getHeader("HTTP_X_FORWARDED_FOR");

				 
				   String   ip3 = req.getRemoteAddr();
				  
				// String userIpAddress = req.getHeader("X-Forwarded-For");
				  String ip4=req.getHeader("X-Forwarded-For");
				  resp.getWriter().println(ip1+ip2+ip3+ip4);*/
	}
}

