package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddHrController")
public class AddHrController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hrname = request.getParameter("hrname");
		String hremail = request.getParameter("hremail");
		String hrpassword = request.getParameter("hrpassword");
		String hrmobno = request.getParameter("hrmobno");
	}
}
