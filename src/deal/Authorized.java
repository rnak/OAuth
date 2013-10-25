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

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
public class Authorized extends HttpServlet{
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
							
							
							if("app2".equals(na)){
								value=aCookie.getValue();
							}
							
						}
					}
				String code = req.getParameter("code");
				System.out.println(code +":::: is code");
				String redirectUrl="https://accounts.google.com/o/oauth2/auth?"+
						"client_id=461617240934.apps.googleusercontent.com&"+
						"response_type=code&"+
						"scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&"+
						"state=%2Fprofile&"+
						"redirect_uri=http://rnak-1991.appspot.com/autho&"+
						"access_type=offline&"+
						"approval_prompt=force";
		
					if(code == null)
					
				{
					
						resp.sendRedirect(redirectUrl); 
		     }
					
				else 
				{
					session.setAttribute("code",code);
					System.out.println("codde:"+code);
					TokenResponse accessresponse = new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),new GenericUrl("https://accounts.google.com/o/oauth2/token"), code).setRedirectUri("http://rnak-1991.appspot.com/autho").setClientAuthentication(new ClientParametersAuthentication("461617240934.apps.googleusercontent.com", "KxTR3Loam_zKVoGsCu6G2V_s")).execute();                                                                                                                                                                                                                                                                                                 //id		                                   //key
					String accesstoken=accessresponse .getAccessToken();	
					String refreshtoken=accessresponse.getRefreshToken();
				//	resp.getWriter().println(refreshtoken);
					 Cookie Refreshcookie=new Cookie("refreshtoken","all"); 
					 Refreshcookie.setDomain("rnak-1991.appspot.com");
					 Refreshcookie.setValue(refreshtoken);
					 Refreshcookie.setMaxAge(60*60*24);
						resp.addCookie(Refreshcookie);
					 Cookie c1=new Cookie("hello","all"); 
						c1.setDomain("rnak-1991.appspot.com");
						c1.setValue(accesstoken);
						c1.setMaxAge(60*60*24);
						resp.addCookie(c1);
						if(value==null||value==""){
						resp.sendRedirect("genratedtoken.jsp");
						}else
						{
							resp.sendRedirect("generatedtoken2.jsp");
						}
						
					 }
				}
			}
			
