package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HrDao;

@WebServlet("/ViewDatabaseController")
public class ViewDatabaseController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String id = request.getParameter("id");
		
        ArrayList databaseAL = new HrDao().viewDatabase(id);
		
		request.setAttribute("databaseAL", databaseAL);
		request.setAttribute("check", "Database");
		request.getRequestDispatcher("LDTViewPage.jsp").forward(request, response);
	}

		
	}

