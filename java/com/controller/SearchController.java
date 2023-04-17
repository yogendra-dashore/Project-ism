package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;



@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String hrname = request.getParameter("hrname");
		ArrayList<HrBean> hrBeanAL = new AdminDao().search(hrname);
		
		RequestDispatcher rd;
		if(hrBeanAL==null)
		{
			request.setAttribute("msg", "Data Not Found");
			rd = request.getRequestDispatcher("Search.jsp");
		}
		else {
			request.setAttribute("hrBeanAL", hrBeanAL);
			rd=request.getRequestDispatcher("DisplayHrList.jsp");
		}
		rd.forward(request, response);
	}
		
	}
	

