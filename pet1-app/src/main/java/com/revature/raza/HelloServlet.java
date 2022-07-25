package com.revature.raza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// pet1-app/hello
		StringBuilder uriString = new StringBuilder(req.getRequestURI());
		uriString.replace(0, req.getContextPath().length()+1, ""); 
		
		if (uriString.indexOf("/") != -1) {
			uriString.replace(0, uriString.indexOf("/")+1, ""); 
			PrintWriter writer = resp.getWriter(); 
			writer.write("Hello! path variable: " + uriString.toString());
		}else {
			PrintWriter writer = resp.getWriter(); 
			writer.write("Hello: .."); 
		}
		
		
		
		PrintWriter writer = resp.getWriter(); 
	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String language = req.getParameter("language"); 
		
		 
		
		// this gets a reader taht will read the http request body 
		BufferedReader reader = req.getReader(); 
		String requestBody = ""; 
		String line = ""; 
		
		while((line = reader.readLine())!= null) {
			requestBody += line; 
		}
		
		PrintWriter writer = resp.getWriter();
		if (language == null ) language = ""; 
		
		switch (language) {
		case "en": 
			writer.write("Hello " + requestBody);
			break; 
		case "fr":
			writer.write("Hello " + requestBody);
			break; 
		default: 
			break; 
				
		
		}
//		writer.write("Salam Alykum everyone,..." + requestBody);
		
		
	}
	
	
	
	
	
	

}
