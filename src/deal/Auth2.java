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
import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
public class Auth2 extends HttpServlet{
	
			public void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws IOException {
			      
				  HttpSession session = req.getSession();
				String email="",name="",emailID="",nameID="",genderID="",imageID="",na="",value="";
				
				Cookie[] cookie_jar = req.getCookies();

					if (cookie_jar != null)
					{
						for (int i =0; i< cookie_jar.length; i++)
						{
							Cookie aCookie = cookie_jar[i];
							na =aCookie.getName();
							/*if("hello".equals(na)){
								value=aCookie.getValue();
							}*/
							if("refreshtoken".equals(na)){
								value=aCookie.getValue();
							}
							
						}
					}
		
			//	String accesstoken=value;
					String refreshtoken=value;
				try{

					TokenResponse newAccessResponse = new RefreshTokenRequest(new NetHttpTransport(), new JacksonFactory(),new GenericUrl("https://accounts.google.com/o/oauth2/token"),refreshtoken).setGrantType("refresh_token").setClientAuthentication(new ClientParametersAuthentication("461617240934.apps.googleusercontent.com", "KxTR3Loam_zKVoGsCu6G2V_s")).execute();; 
				    
				   String  accesstoken=newAccessResponse.getAccessToken();
	
				   
				   
				   Credential usercredentials=new Credential(BearerToken.authorizationHeaderAccessMethod()).setAccessToken(accesstoken);
					
					HttpRequestFactory userrequest = new NetHttpTransport().createRequestFactory(usercredentials);
					
			//		String googleapi = "https://www.googleapis.com/oauth2/v1/userinfo?access_token="+accesstoken;
					
			            String g = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accesstoken;
			            URL u = new URL(g);
			            URLConnection c = u.openConnection();
			            BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			            String inputLine;
			            StringBuffer b = new StringBuffer();
			            while ((inputLine = in.readLine()) != null)
			                b.append(inputLine + "\n");            
			            in.close();
			         String   graph = b.toString();
			         JSONObject json = new JSONObject(graph);
			         emailID = json.getString("email");
			         if (json.has("name"))
			            	nameID = json.getString("name");
			             else
			            	 nameID = null;
			         if (json.has("picture"))
			            	imageID = json.getString("picture");
			             else
			            	 imageID = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcThMN76PYySr60rMyiPWWXx_G6q2TO2pX-YoOIoeJD7-uEnIcOhMw";
			         if (json.has("gender"))
			            	genderID = json.getString("gender");
			             else
			            	 genderID = "Not Mentioned";
			         resp.getWriter().println(email+name+imageID+genderID);
					
					 
				    	session.setAttribute("name", nameID);
						session.setAttribute("email", emailID);
						session.setAttribute("gender", genderID);
						session.setAttribute("image", imageID);
						
						
						resp.sendRedirect("redirect.jsp");
				}catch(Exception e){
					resp.sendRedirect("gentoken.jsp");
				} 	
				}
				
			}
			
