package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.HrDao;

@WebServlet("/SearchUsersController")
public class SearchUsersController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String name = request.getParameter("name");
		
		ArrayList<UserBean> userBeanAL = new HrDao().searchUsers(name);
		
		RequestDispatcher rd = null;
		if(userBeanAL.isEmpty())
		{
			request.setAttribute("msg", "Sorry Data Not Found");
			rd = request.getRequestDispatcher("SearchUsers.jsp");
		}
		else {
			request.setAttribute("userBeanAL", userBeanAL);
			rd = request.getRequestDispatcher("DisplayUsersList.jsp");
		}
		rd.forward(request, response);
		
	}
		
	}
	
	

