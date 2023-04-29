package in.jo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.jo.pojo.Customer;
import in.jo.utility.DBconnection;

public class CustomerDao {
	Connection conn=DBconnection.getConnection();
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int i=0;
	List<Customer>  clist=null;
	
	public int addCustomer(Customer c) {
		try {
			System.out.println("inside cust dao add method");
			sql="insert into customer(custname ,custemail,custcontact,custaddress,custpass)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, c.getCustname());
			ps.setString(2, c.getCustemail());
			ps.setString(3, c.getCustcontact());
			ps.setString(4, c.getCustaddress());
			ps.setString(5, c.getCustpass());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public int updateCustomer(Customer c) {
		System.out.println("inside Customer update dao");
		try {
			sql="update customer set custname=?, custemail=?, custcontact=? ,custaddress=? custpass=? where custid= ?";
			ps=conn.prepareStatement(sql);

			ps.setString(2, c.getCustname());
			ps.setString(3, c.getCustemail());
			ps.setString(4, c.getCustcontact());
			ps.setString(5, c.getCustaddress());
			ps.setString(6, c.getCustpass());
			ps.setInt(1, c.getCustid());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			System.out.println("i="+i);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Customer> showCustomerList(){
		clist=new ArrayList<Customer>();
		System.out.println("Inside Customer list Dao");
		try {
			sql="select *from customer";
			ps=conn.prepareStatement(sql);
			System.out.println("Query:"+ps);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer();
				c.setCustid(rs.getInt(1));
				c.setCustname(rs.getString(2));
				c.setCustemail(rs.getString(3));
				c.setCustcontact(rs.getString(4));
				c.setCustaddress(rs.getString(5));
				c.setCustpass(rs.getString(6));
				clist.add(c);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return clist;
		}
	
	public int deleteCustomer(int pid) {
		System.out.println("inside Cutomer delete dao");
		try {
			sql="delete from Customer where Cutomerid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			System.out.println("i="+i);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
}
