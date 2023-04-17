package com.HrController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HrDao;
import com.filter.Validation;


@WebServlet("/AddNewUsersController")
public class AddNewUsersController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String cono = request.getParameter("cono");
		String[] language = request.getParameterValues("language");
		String[] database = request.getParameterValues("database");
		String[] technology = request.getParameterValues("technology");
		String experience = request.getParameter("experience");
		String url = request.getParameter("resumeurl");
		String qualification = request.getParameter("qualification");
		
		boolean isError = false;
		
		if(Validation.isEmpty(name))
		{
			isError = true;
			request.setAttribute("name", "Name Can't Be Empty");
		}
		
		else if(Validation.chackLength(name)) {
			isError = true;
			request.setAttribute("name", "Greater Than 1 Character");
			
		}
		
		else if(Validation.isNameAlpha(name))
		{
			isError = true;
			request.setAttribute("name", "Enter Valid Name");
		}
		else {
			request.setAttribute("namevalue", name);
			
		}
		
		if(Validation.isEmpty(email))
		{
			isError = true;
			request.setAttribute("email", "Email Can't Be Empty");
					
		}
		else if(Validation.isEmailAlpha(email)) {
			isError = true;
			request.setAttribute("hrmail", "Enter Valid Email");
			
		}
		else {
			request.setAttribute("emailvalue", email);
		}
		
		if(Validation.isEmpty(cono)) {
			isError = true;
			request.setAttribute("cono", "Contact No Can't be Empty");
		}
		else if(Validation.checkMobNolength(cono)) {
			isError = true;
			request.setAttribute("mobno", "Enter Valid MobNo");
		}
		else {
			request.setAttribute("monnovalue", cono);
		}
		
		if(experience.matches("[0-9]+")==false) {
			isError = true;
			request.setAttribute("experience", "Enter Valid Experience");
		}
		else {
			request.setAttribute("experiencevalue", experience);
			
		}
		
		if(Validation.isEmpty(url)) {
			isError = true;
			request.setAttribute("url", "URL Can't Be Empty");
			
		}else {
			request.setAttribute("urlvalue", url);
			
		}
		
		if(Validation.isEmpty(qualification)) {
			isError = true;
			request.setAttribute("qualification", "Qualification Can't Be Empty");
		}
		else {
			request.setAttribute("qualificationvalue", qualification);
		}
		
		RequestDispatcher rd = null;
		if(isError) {
			System.out.println("Hello");
			rd = request.getRequestDispatcher("AddNewUsers.jsp");
		}
		else {
			HrDao hrDao = new HrDao();
			
			int id = hrDao.addUsers(name, email, cono, experience, url, qualification);
			 System.out.println(id);
			  hrDao.addLanguage(id,language);
			  hrDao.addDatabase(id,database);
			  hrDao.addTechnology(id,technology);
			
			rd = request.getRequestDispatcher("HrDashBoard.jsp");
			
			
		}
		rd.forward(request, response);
		
		
		}
	
}
