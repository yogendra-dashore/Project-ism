package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.HrDao;

@WebServlet("/UsersListController")
public class UsersListController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 ArrayList<UserBean> userBeanAL = new HrDao().getAllUsers();	
		    
		    request.setAttribute("userBeanAL",userBeanAL );
		    
		    request.getRequestDispatcher("DisplayUsersList.jsp").forward(request, response);
		}
	}

