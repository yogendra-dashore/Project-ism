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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hrname = request.getParameter("HrName");
		String hremail = request.getParameter("HrEmail");
		String hrpassword = request.getParameter("HrPassword"); 
		String hrmobno = request.getParameter("HrMobileNo");
		
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
			 else if(Validation.chackLength(hrmobno))
			 {
				 isError=true;
				 request.setAttribute("hrmobno", "Mobile No Should Be 10 Digit");	
			 }
			 else if(Validation.isMobNuAlpha(hrmobno))
			 {
				 isError=true;
				 request.setAttribute("hrmobno", "Enter Valid MobNo");	
			 }
			 
			 RequestDispatcher rd=null;
			 
			 if(isError)
			 {
				 rd=request.getRequestDispatcher("AddHr.jsp");
			 }
			 else {
				AdminDao adminDao = new AdminDao();
				int rowaffected = adminDao.addHr(hrname,hremail,hrpassword,hrmobno);
				
				if(rowaffected>0)
				{
				
					rd=request.getRequestDispatcher("AdminDashBoard.jsp");
				}
				else {
					rd=request.getRequestDispatcher("AddHr.jsp");
				}
				rd.forward(request, response);
			}
	}
}
