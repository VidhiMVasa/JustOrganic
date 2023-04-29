package in.jo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.jo.utility.DBconnection;

public class LoginDao {

	Connection conn=DBconnection.getConnection();
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int i=0;
	public boolean isAdmin(String email,String pass) {
		try {
			sql="select adminemail, adminpass from admin where adminemail=? and adminpass=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			System.out.println("query:"+ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean isCustomer(String email,String pass) {
		try {
			sql="select custemail, custpass from customer where custemail=? and custpass=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			System.out.println("query:"+ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int forgotPasswod(String email,String newpass) {
		try {
			sql="update customer set custpass=? where custemail= ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, newpass);
			ps.setString(2, email);
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
