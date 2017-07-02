package com.java.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.LoginDAO;
import com.java.model.User;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
		try{
			LoginDAO loginDAO = new LoginDAO();
		
		boolean valid = loginDAO.isValid(user);
		
		if(valid){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);			
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);
		
		}}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
