package in.jo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.jo.utility.DBconnection;

public class CartDao {
	Connection conn=DBconnection.getConnection();
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int i=0;
	
	public boolean addToCart(String email,int productid) {
		try {
			sql="insert into cart(cutemail,productid)values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, productid);
			i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
