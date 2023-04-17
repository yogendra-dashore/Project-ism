package com.HrController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.HrDao;

@WebServlet("/EditUsersController")
public class EditUsersController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobno = request.getParameter("mobno");
		String experience = request.getParameter("experience");
		String url = request.getParameter("url");
		String qualification = request.getParameter("qualification");
		
		UserBean userBean = new UserBean();
		userBean.setId(Integer.valueOf(id));
		userBean.setName(name);
		userBean.setEmail(email);
		userBean.setMobno(mobno);
		userBean.setExperience(experience);
		userBean.setResumeurl(url);
		userBean.setQualification(qualification);
		
		new HrDao().updateUsers(userBean);
		
		response.sendRedirect("UsersListController");
	}
}
