package deal;

/*
 * Copyright (c) 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
public class face2 extends HttpServlet{
	
			public void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws IOException {
			      
				  HttpSession session = req.getSession();
				String na="",value="";
				
				Cookie[] cookie_jar = req.getCookies();

					if (cookie_jar != null)
					{
						for (int i =0; i< cookie_jar.length; i++)
						{
							Cookie aCookie = cookie_jar[i];
							na =aCookie.getName();
							if("facebook".equals(na)){
								value=aCookie.getValue();
							}
							
						}
					}
		
					String token=value;
					String graph = null;
			        try {
			            String g = "https://graph.facebook.com/me?" + token;
			            URL u = new URL(g);
			            URLConnection c = u.openConnection();
			            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			            String inputLine;
			            StringBuffer b = new StringBuffer();
			            while ((inputLine = in.readLine()) != null)
			                b.append(inputLine + "\n");            
			            in.close();
			            graph = b.toString();
			        } catch (Exception e) {
			               resp.sendRedirect("fgentoken.jsp");
			        }

			        
			        String middleNames;
			        String firstName="";
			        String email;
			        String username="";
			       
			        try {
			            JSONObject json = new JSONObject(graph);
			            if (json.has("username"))
			            	username = json.getString("username");
			             else
			            	 username = null;
			            firstName = json.getString("first_name");
			            if (json.has("middle_name"))
			               middleNames = json.getString("middle_name");
			            else
			                middleNames = null;
			            if (middleNames != null && middleNames.equals(""))
			                middleNames = null;
			            email = json.getString("email");
			            session.setAttribute("name", firstName);
						session.setAttribute("email", email);
						session.setAttribute("gender", username);
						
						resp.sendRedirect("redirect.jsp");
			      
			        } catch (JSONException e) {
			            // an error occurred, handle this
			        	 resp.sendRedirect("fgentoken.jsp");
			        }
			        
			        
			        try {
			            String g = "https://graph.facebook.com/"+username+"?fields=picture.type(large)";
			            
			            URL u = new URL(g);
			            URLConnection c = u.openConnection();
			            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			            String inputLine;
			            StringBuffer b = new StringBuffer();
			            while ((inputLine = in.readLine()) != null)
			                b.append(inputLine + "\n");            
			            in.close();
			            graph = b.toString();
			            
			        } catch (Exception e) {
			          //     resp.sendRedirect("fgentoken.jsp");
			        }
			        String url= null;
			        try {
			            JSONObject json = new JSONObject(graph);
			            
			          /*  if(json.getJSONObject("picture").getJSONObject("data").has("url")){
			            	resp.getWriter().println(url=json.getString(json.getJSONObject("picture").getJSONObject("data").getString("url")));
			            }*/
			            
			           
			            
			            
			            resp.getWriter().println("url is"+json);
					//	resp.sendRedirect("redirect.jsp");
			      
			        } catch (JSONException e) {
			        	
			            // an error occurred, handle this
			        	resp.getWriter().println("error catched");
			        //	 resp.sendRedirect("fgentoken.jsp");
			        }
			        
		}
}
