<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.jo.pojo.*,in.jo.dao.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Product> plist=(List<Product>)session.getAttribute("productlist");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<script>
alert("<%=msg%>")
</script>
<%} %>
<jsp:include page="header.jsp"></jsp:include>
<table class="table table-striped">
<tr>
	<th>Product Id</th>
	<th>Product Name</th>
	<th>Product Category</th>
	<th>Product Weight</th>
	<th>Product Price</th>
	<th colspan=2>Operations</th>
</tr>
<%
for(Product p:plist){
%>
<tr>
	<td><%=p.getProductid() %></td>
	<td><%=p.getProductname() %></td>
	<td><%=p.getProductcategory() %></td>
	<td><%=p.getProductweight() %></td>
	<td><%=p.getProductprice() %></td>
	<td><a href="/JustOrganicOnline/productc?action=delete&pid=<%=p.getProductid() %>" class="btn btn-danger">Delete</a></td>
	<td><a href="/JustOrganicOnline/productc?action=edit&pid=<%=p.getProductid() %>" class="btn btn-success">Update</a></td>
</tr>
<%} %>
</table>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>