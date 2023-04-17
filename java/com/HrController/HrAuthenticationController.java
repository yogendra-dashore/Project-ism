package com.HrController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.HrDao;

@WebServlet("/HrAuthenticationController")
public class HrAuthenticationController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hremail = request.getParameter("hremail");
		String hrpassword = request.getParameter("hrpassword");
		
		HrBean hrBean = new HrDao().authenticate(hremail,hrpassword);
		
		RequestDispatcher rd;
		if(hrBean==null)
		{
			request.setAttribute("error", "Enter Valid Credentials");
			rd = request.getRequestDispatcher("HrLogin.jsp");
		}
		else {
			rd = request.getRequestDispatcher("HrDashBoard.jsp");
		}
		rd.forward(request, response);
	}
	}

