package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.filter.Validation;

@WebServlet("/AdminAuthenticationController")
public class AdminAuthenticationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		boolean isError = false;
		if(Validation.isEmpty(email)) {
			isError=true;
			request.setAttribute("email1", "Email Can't Be Empty");
	    }
	    else if(Validation.isEmailAlpha(email))
	    {
	    	isError=true;
	    	request.setAttribute("email1", "Enter Valid Email ");
	    }
	    else {
 		   
			request.setAttribute("emailvalue", email);
		
		}if(Validation.isEmpty(password))
	    {
	    	isError=true;
	    	request.setAttribute("password1", "Password Can't Be Empty");
	    }
	    else if(Validation.isPasswordAlpha(password))
	    {
	    	isError=true;
    		request.setAttribute("password1", "Enter Valid Password");	
	    }
	   	else 
	   	{
	    	   
				request.setAttribute("passwordvalue", password);
		}
		
		RequestDispatcher rd = null;
	    if(isError)
	    {
	    	rd = request.getRequestDispatcher("AdminLogin.jsp");
	    }
	    else {
	    	AdminDao adminDao = new AdminDao();
	    	AdminBean adminBean = adminDao.authenticate(email, password);
	    	
	    	if(adminBean==null) {
	    		request.setAttribute("error",  "Please Enter Valid Credentials");
	        	   rd = request.getRequestDispatcher("AdminLogin.jsp");
	    	}
	    	
	    	 else {
				 request.setAttribute("adminBean", adminBean);
	         	 rd = request.getRequestDispatcher("AdminDashBoard.jsp");
			}
			}
		    rd.forward(request, response);
		}

	}
	    
	    
	    
	    