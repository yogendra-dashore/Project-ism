package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;

@WebServlet("/EditHrController")
public class EditHrController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		
		HrBean hrBean = new AdminDao().getHrDetails(id);
		
		request.setAttribute("hrBean", hrBean);
		request.getRequestDispatcher("EditHr.jsp").forward(request, response);;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hrname = request.getParameter("hrname");
		String hremail = request.getParameter("hremail");
		String hrpassword = request.getParameter("hrpassword");
		String hrmobno = request.getParameter("hrmobno");
		Integer hrid = Integer.valueOf(request.getParameter("hrid"));
		
		HrBean hrBean = new HrBean();
		
		hrBean.setId(hrid);
		hrBean.setHrname(hrname);
		hrBean.setHremail(hremail);
		hrBean.setHrpassword(hrpassword);
		hrBean.setHrmobno(hrmobno);
		
		new AdminDao().updateHr(hrBean);
		
		response.sendRedirect("HrListController");
	}

}
