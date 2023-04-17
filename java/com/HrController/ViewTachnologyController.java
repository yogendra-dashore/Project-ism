package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HrDao;


@WebServlet("/ViewTachnologyController")
public class ViewTachnologyController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String id = request.getParameter("id");
		
		ArrayList technologyAL = new HrDao().viewTechnology(id);
		
		request.setAttribute("technologyAL", technologyAL);
		request.setAttribute("check", "Technology");
		request.getRequestDispatcher("LDTViewPage.jsp").forward(request, response);
	}
		
	}

