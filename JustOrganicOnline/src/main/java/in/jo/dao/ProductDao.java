package in.jo.dao;		// DAO : Data Access Object

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import in.jo.pojo.Product;
import in.jo.utility.DBconnection;

public class ProductDao {
	Connection conn=DBconnection.getConnection();
	String sql=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<Product>  plist=null;
	int i=0;
	public int addProduct(Product p) {
		System.out.println("inside product add dao");
		try {
			sql="insert into product(productname,productcategory,productweight,productprice)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, p.getProductname());
			ps.setString(2, p.getProductcategory());
			ps.setDouble(3, p.getProductweight());
			ps.setDouble(4, p.getProductprice());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			System.out.println("i="+i);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	
	public int deleteProduct(int pid) {
		System.out.println("inside product delete dao");
		try {
			sql="delete from product where productid=?";
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
	
	public int updateProduct(Product p) {
		System.out.println("inside product update dao");
		try {
			sql="update product set productname=?, productcategory=?, productweight=? ,productprice=? where productid= ?";
			ps=conn.prepareStatement(sql);

			ps.setString(1, p.getProductname());
			ps.setString(2, p.getProductcategory());
			ps.setDouble(3, p.getProductweight());
			ps.setDouble(4, p.getProductprice());
			System.out.println("query:"+ps);
			i=ps.executeUpdate();
			System.out.println("i="+i);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	
	public List<Product> showProductList(){
		plist=new ArrayList<Product>();
		System.out.println("Inside productlist Dao");
		try {
			sql="select *from product";
			ps=conn.prepareStatement(sql);
			System.out.println("Query:"+ps);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setProductid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcategory(rs.getString(3));
				p.setProductweight(rs.getDouble(4));
				p.setProductprice(rs.getDouble(5));
				plist.add(p);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return plist;
		}
	
	public List<Product> searchProductByCategory(String productcategory){
		plist=new ArrayList<Product>();
		System.out.println("Inside productlist Search product By category Dao");
		try {
			sql="select *from product where productCategory=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productcategory);
			System.out.println("Query:"+ps);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setProductid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcategory(rs.getString(3));
				p.setProductweight(rs.getDouble(4));
				p.setProductprice(rs.getDouble(5));
				plist.add(p);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return plist;
		}
	
	public Product searchProductById(int pid){
		Product p=null;
		System.out.println("Inside productlist Search product by Id Dao");
		try {
			sql="select *from product where productId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,pid);
			System.out.println("Query:"+ps);
			rs=ps.executeQuery();
			if(rs.next()) {
				p=new Product();
				p.setProductid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcategory(rs.getString(3));
				p.setProductweight(rs.getDouble(4));
				p.setProductprice(rs.getDouble(5));
				return p;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
		}
	
	public List<Product> searchProductByName(String productname){
		plist=new ArrayList<Product>();
		System.out.println("Inside productlist Search product By name Dao");
		try {
			sql="select *from product where productName=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productname);
			System.out.println("Query:"+ps);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setProductid(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setProductcategory(rs.getString(3));
				p.setProductweight(rs.getDouble(4));
				p.setProductprice(rs.getDouble(5));
				plist.add(p);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return plist;
		}
	
	}

