package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.HrBean;
import com.dao.AdminDao;

@WebServlet("/ViewHrController")
public class ViewHrController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer hrid = Integer.valueOf(request.getParameter("id"));
		

		HrBean hrBean = new AdminDao().getHrInfo(hrid);
		
		request.setAttribute("hrBean", hrBean);
		request.getRequestDispatcher("ViewHr.jsp").forward(request, response);;
	}
	}

