package com.HrController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.HrDao;


@WebServlet("/ViewUsersController")
public class ViewUsersController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String id = request.getParameter("id");
		
		
		UserBean resourceBean =new HrDao().getuserInfo(id);
		
		request.setAttribute("userBean", resourceBean);
		request.getRequestDispatcher("ViewUsers.jsp").forward(request, response);
		}

		
	
}
