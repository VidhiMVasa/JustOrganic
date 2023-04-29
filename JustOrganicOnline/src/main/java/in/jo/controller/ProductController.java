package in.jo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.jo.dao.ProductDao;
import in.jo.pojo.Product;


@WebServlet("/productc")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter out=null;
	Product product=null;
	ProductDao pdao=new ProductDao();
	RequestDispatcher rd=null;
	HttpSession session=null;
	int i;
	boolean result;
	String action=null;
	int productid;
	String productname;
	String productcategory;
	double productweight;
	double productprice;
	List<Product> plist=new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		session =request.getSession();
		action=request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			productid=Integer.parseInt(request.getParameter("pid"));
			i=pdao.deleteProduct(productid);
			if(i>0) {
		
			plist =pdao.showProductList();
			
				if(!plist.isEmpty()) {
					request.setAttribute("msg", "product deleted");
					session.setAttribute("productlist", plist);
					rd=request.getRequestDispatcher("/jsp/productlist.jsp");
					rd.forward(request, response);
					}
				}
				else {
					request.setAttribute("msg", "product not deleted");
					rd=request.getRequestDispatcher("/jsp/productlist.jsp");
					rd.include(request, response);
					}
				}
			//update
			if(action!=null && action.equals("edit")) {
				productid=Integer.parseInt(request.getParameter("pid"));
				product=pdao.searchProductById(productid);
				session.setAttribute("product", product);
				rd=request.getRequestDispatcher("/jsp/updateproduct.jsp");
				rd.forward(request, response);
			}
		
			//show
			else {
				plist=pdao.showProductList();
				if(!plist.isEmpty()) {
					session.setAttribute("productlist", plist);
					rd=request.getRequestDispatcher("/jsp/productlist.jsp");
					rd.forward(request, response);
				}
			}
		}

//add update
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		response.setContentType("text/html");
		action=request.getParameter("action");
		if(action!=null && action.equals("addproduct")) {
			productname=request.getParameter("productname");
			productcategory=request.getParameter("producttype");
			productweight=Double.parseDouble(request.getParameter("productweight"));
			productprice=Double.parseDouble(request.getParameter("productprice"));
			product=new Product(productname, productcategory, productweight, productprice);
			System.out.println(product);
			i=pdao.addProduct(product);
			if(i>0) {
				System.out.println("product added");
				request.setAttribute("msg", "product added successfully");
				rd=request.getRequestDispatcher("/jsp/addproduct.jsp");
				rd.include(request, response);
			}
			else {
				System.out.println("product not added");
				request.setAttribute("msg", "product not added");
				rd=request.getRequestDispatcher("/jsp/addproduct.jsp");
				rd.include(request, response);
			}
		}
		
		//add product
		if(action!=null && action.equals("updateproduct")) {
			productid=Integer.parseInt(request.getParameter("productid"));
			System.out.println(productid);
			productname=request.getParameter("productname");
			productcategory=request.getParameter("producttype");
			productweight=Double.parseDouble(request.getParameter("productweight"));
			productprice=Double.parseDouble(request.getParameter("productprice"));
			product=new Product(productid,productname, productcategory, productweight, productprice);
			System.out.println(product);
			i=pdao.updateProduct(product);
			if(i>0) {
				System.out.println("product updated");
				request.setAttribute("msg", "product updated successfully");
				plist=pdao.showProductList();
				if(!plist.isEmpty()) {
					session.setAttribute("productlist", plist);
					rd=request.getRequestDispatcher("/jsp/productlist.jsp");
					rd.forward(request, response);
					}
				}
				
				else {
					System.out.println("product not updated");
					request.setAttribute("msg", "product not updated");
					rd=request.getRequestDispatcher("/jsp/updateproduct.jsp");
					rd.include(request, response);
				}
			}
//		else {
//			session.setAttribute("productlist", plist);
//			rd=request.getRequestDispatcher("/jsp/addproduct.jsp");
//			rd.forward(request, response);
//			
//		}
	}

}
