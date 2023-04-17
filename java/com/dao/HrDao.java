package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.taglibs.standard.tag.common.core.CatchTag;

import com.bean.HrBean;
import com.bean.UserBean;
import com.util.DbConnection;

public class HrDao {

	public HrBean authenticate(String hremail, String hrpassword) {
		HrBean hrBean = null;
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Hr where HrEmail=? and HrPassword=?");
			
			ps.setString(1, hremail);
			ps.setString(2, hrpassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				hrBean = new HrBean();
				hrBean.setHremail(rs.getString("HrEmail"));
				hrBean.setHrpassword(rs.getString("HrPassword"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return hrBean;
	}
	
	public ArrayList<UserBean> getAllUsers(){
		ArrayList<UserBean> userBeansAL = new ArrayList<UserBean>();
		UserBean userBean = null;
		Connection con = DbConnection.getConnection();
		
		try {
		PreparedStatement ps = con.prepareStatement("select * from Users");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			userBean = new UserBean();
			userBean.setId(rs.getInt("UserId"));
			userBean.setName(rs.getString("FirstName"));
			userBean.setEmail(rs.getString("Email"));
			userBean.setMobno(rs.getString("ContactNo"));
			userBean.setExperience(rs.getString("Experience"));
			userBean.setResumeurl(rs.getString("ResumeURL"));
			userBean.setQualification(rs.getString("Qualification"));
			
			userBeansAL.add(userBean);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return userBeansAL;
	
}
	
	public UserBean getuserInfo(String id) {
		UserBean userBean = null;
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Users where UserId = ?");
			
            ps.setInt(1, Integer.valueOf(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				userBean = new UserBean();
				userBean.setId(rs.getInt("UserId"));
				userBean.setName(rs.getString("FirstName"));
				userBean.setEmail(rs.getString("Email"));
				userBean.setMobno(rs.getString("ContactNo"));
				userBean.setExperience(rs.getString("Experience"));
				userBean.setResumeurl(rs.getString("ResumeURL"));
				userBean.setQualification(rs.getString("Qualification"));
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBean;
	}
	
public void updateUsers(UserBean userBean) {
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update Users set FirstName=?, Email=?, ContactNo=?, Experience=?, ResumeURL=?, Qualification=? where UserId=?");
			
			ps.setString(1, (userBean.getName()));
			ps.setString(2, (userBean.getEmail()));
			ps.setString(3, (userBean.getMobno()));
			ps.setString(4, (userBean.getExperience()));
			ps.setString(5, (userBean.getResumeurl()));
			ps.setString(6, (userBean.getQualification()));
			ps.setInt(7,(userBean.getId()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void deleteUsers(String id) {
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from Users where id=?");
			
			ps.setInt(1, Integer.valueOf(id));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public ArrayList<UserBean> searchUsers(String name) {
		ArrayList<UserBean> userBeanAL = new ArrayList<UserBean>();
		UserBean userBean =null;
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Users where FirstName like ?");
			
			ps.setString(1, name+"%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				userBean = new UserBean();
				userBean.setId(rs.getInt("Id"));
				userBean.setName(rs.getString("Name"));
				userBean.setEmail(rs.getString("Email"));
				userBean.setMobno(rs.getString("Mobno"));
				userBean.setExperience(rs.getString("Experience"));
				userBean.setResumeurl(rs.getString("ResumeURL"));
				userBean.setQualification(rs.getString("Qualification"));
				
				userBeanAL.add(userBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userBeanAL;
	}
	
	
	
	public void addLanguage(int id, String[] language) {
		
		Connection con = DbConnection.getConnection();
		//int[] lanId = new int [language.length];
		for(int i=0;i<language.length;i++)
		{
			String lng = language[i];
			
			PreparedStatement ps = null;
			
			try {
				ps = con.prepareStatement("select LanId from Language where LanName=?");
				
				
				ps.setString(1, lng);
				
				ResultSet rs = ps.executeQuery();
				int tempid=0;
				if(rs.next()) {
					tempid = rs.getInt("LanId");
				}
				
				ps = con.prepareStatement("insert into User_Language values(?,?)");
				
				ps.setInt(i, tempid);
				ps.setInt(2, id);
				ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	public int addUsers(String name, String email, String cono, String experience, String url, String qualification)
	{
		int id =0;
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps ;
			ps = con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, cono);
			ps.setString(4, experience);
			ps.setString(5, url);
			ps.setString(6, qualification);
			
			
	
			ps.executeUpdate();
			
			ps = con.prepareStatement("select UserId from Users where Email=?");
			ps.setString(1, email);
			
            ResultSet rs = ps.executeQuery();
		    
		    if(rs.next())
		    {
		    	id = rs.getInt("UserId");
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
		
	}

	public void addDatabase(int id, String[] database) {
		Connection con = DbConnection.getConnection();
		
		for(int i=0;i<database.length;i++)
		{
			String db = database[i];
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select DbId from Databasee where DbName = ?");
				
				ps.setString(1, db);
				 
				ResultSet rs = ps.executeQuery();
				int tempDbid = 0;
				if(rs.next())
				{
					tempDbid = rs.getInt("DbId");
					
				}
				
				ps = con.prepareStatement("insert into User_Databasee values(?,?)");
				
				ps.setInt(1, tempDbid);
				ps.setInt(2, id);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public void addTechnology(int id, String[] technology) {
		Connection con = DbConnection.getConnection();
		
		
		for(int i=0;i<technology.length;i++)
		{
			String tech = technology[i];
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select TachId from Tachnology where TachName = ?");
				
				ps.setString(1, tech);
				 
				ResultSet rs = ps.executeQuery();
				int tempTechid = 0;
				if(rs.next())
				{
					tempTechid = rs.getInt("TechId");
					
				}
				
				ps = con.prepareStatement("insert into User_Tachnology values(?,?)");
				
				ps.setInt(1, tempTechid);
				ps.setInt(2, id);
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public ArrayList viewLanguage(String id) {
		ArrayList languageAL = new ArrayList<>();
		
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select LanName from Language where LanId in (select LanId from User_Language where Id in(select Id from Users where Id=?))");
		    
			ps.setInt(1, Integer.valueOf(id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				 languageAL.add(rs.getString("LanName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return languageAL;
	}

	public ArrayList viewDatabase(String id) {
        
		ArrayList databaseAL = new ArrayList();
		
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select DbName from DBName where DBId in (select DBId from Res_DB where Id in(select Id from Resource where Id=?))");
		    
			ps.setInt(1, Integer.valueOf(id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				databaseAL.add(rs.getString("DbName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return databaseAL;
	}

	public ArrayList viewTechnology(String id) {
ArrayList technologyAL = new ArrayList();
		
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select TachName from Tachnology where TachId in (select TachId from Users_Tachnology where Id in(select Id from Users where Id=?))");
		    
			ps.setInt(1, Integer.valueOf(id));
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				technologyAL.add(rs.getString("TachName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return technologyAL;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
