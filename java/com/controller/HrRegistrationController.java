package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.filter.Validation;


@WebServlet("/HrRegistrationController")
public class HrRegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hrname = request.getParameter("hrname");
		String hremail = request.getParameter("hremail");
		String hrpassword = request.getParameter("hrpassword"); 
		String hrmobno = request.getParameter("hrmobno");
		
		boolean isError = false;
		
		if(Validation.isEmpty(hrname)) {
			isError=true;
			request.setAttribute("hrname", "Name Can't Be Empty");
		}
		else if(Validation.chackLength(hrname))
		{
			 isError=true;
			 request.setAttribute("hrname", "Enter more Than one Character" );
			 
		}else if(Validation.isNameAlpha(hrname))
		{
			isError=true;
			request.setAttribute("hrname", "Enter Valid Name");
		}
		else {
			request.setAttribute("hrnamevalue", hrname);
		} 
		
		if(Validation.isEmpty(hremail))
	    {
	    	isError=true;
	    	request.setAttribute("hremail", "Email Can't Be Empty");
	    }
	    else if(Validation.isEmailAlpha(hremail))
	    {
	    	isError=true;
	    	request.setAttribute("hremail", "Enter Valid Email ");
	    }
	    else {
 		   
			request.setAttribute("hremailvalue", hremail);
		
	         }
		
		if(Validation.isEmpty(hrpassword))
			    {
			    	isError=true;
			    	request.setAttribute("hrpassword", "Password Can't Be Empty");
			    }
			    else if(Validation.isPasswordAlpha(hrpassword))
			    {
			    	isError=true;
		    		request.setAttribute("hrpassword", "Enter Valid Password");	
			    }
			   	else 
			   	{
			    	   
						request.setAttribute("hrpasswordvalue", hrpassword);
				}
	         
		if(Validation.isEmpty(hrmobno))
			 {
				 isError=true;
				 request.setAttribute("hrmobno", "Mobile No Can't Be Empty");	
			 }
			 else if(Validation.checkMobNolength(hrmobno))
			 {
				 isError=true;
				 request.setAttribute("hrmobno", "Mobile No Should Be 10 Digit");	
			 }
			 else if(Validation.isMobNoAlpha(hrmobno))
			 {
				 isError=true;
				 request.setAttribute("hrmobno", "Enter Valid MobNo");	
			 }
			 else {
				 request.setAttribute("hrmobnovalue", hrmobno);
			 }
		
		
			 
		 RequestDispatcher rd=null;
			 if(isError)
			 {
				
				rd = request.getRequestDispatcher("AddHr.jsp");
			 }
			 else {
				AdminDao adminDao = new AdminDao();
				adminDao.addHr(hrname,hremail,hrpassword,hrmobno);
				
				rd = request.getRequestDispatcher("AdminDashBoard.jsp");
				}
				
				rd.forward(request, response);
			}
	}

