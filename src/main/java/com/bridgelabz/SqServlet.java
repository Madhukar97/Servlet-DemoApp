package com.bridgelabz;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//		int sum = (int) req.getAttribute("sum");		// Passing data from 1 servlet to other by RequestDispatcher
		
//		int sum = Integer.parseInt(req.getParameter("sum"));	//Passing data by sendRedirect method by URL Rewriting
		
//		HttpSession session = req.getSession();					//Passing data by session	
//		int sum = (int)session.getAttribute("sum");
		
		int sum = 0;
		
		Cookie cookies[] = req.getCookies();					//Passing data by using cookies
		for(Cookie c : cookies) {
			if(c.getName().equals("sum")) sum = Integer.parseInt(c.getValue());
		}
		
		int square = sum*sum;
		
		res.getWriter().println("Sq Servet called" + "\n Sum = " + sum + "\n Square = " + square);
	}
}
