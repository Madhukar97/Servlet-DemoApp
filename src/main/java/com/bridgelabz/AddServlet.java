package com.bridgelabz;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int n1 = Integer.parseInt(req.getParameter("num1"));
		int n2 = Integer.parseInt(req.getParameter("num2"));
		
		int sum = n1+n2;
		
		//res.getWriter().println(n1 + " + " + n2 + " = " + sum);
		
//		req.setAttribute("sum", sum);
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
//		res.sendRedirect("sq?sum="+sum);			//sending data to another servlet by sendRedirect URL rewriting
		
//		HttpSession session = req.getSession();		//sending data to another servlet by saving it in session
//		session.setAttribute("sum", sum);
		
		Cookie cookie = new Cookie("sum", sum+"");	//sending data to another servlet using cookie object
		res.addCookie(cookie);
		
		res.sendRedirect("sq");
	}

}
