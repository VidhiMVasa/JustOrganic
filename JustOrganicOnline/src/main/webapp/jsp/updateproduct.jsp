<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.jo.pojo.*,in.jo.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Product p=(Product)session.getAttribute("product");
%>
<jsp:include page="header.jsp"></jsp:include>
<p class="text-primary text-center h2 m-3">Update Product here!!</p>
<div class="container mb-3 shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px">
<form action="/JustOrganicOnline/productc" method="post">
<input type="hidden" name="action" value="updateproduct">
<div class="mb-3">
    <label for="productid" class="form-label mt-2">Product Id</label>
    <input type="text" class="form-control" name="productid" value="<%=p.getProductid() %>" id="productid" aria-describedby="emailHelp" readonly=true >
  </div>
  <div class="mb-3">
    <label for="productid" class="form-label mt-2">Product Name</label>
    <input type="text" class="form-control" name="productname" value="<%=p.getProductname() %>" id="productid" aria-describedby="emailHelp">
  </div>
 
  <div class="mb-1">
    <label for="producttype" class="form-label">Product Type</label>
  </div>
  <%if(p.getProductcategory().equals("fruits")){ %>
  <div class="form-check float-start me-5">
  <input class="form-check-input" type="radio" name="producttype" id="flexRadioDefault1" value="fruit" checked="checked">
  <label class="form-check-label" for="flexRadioDefault1">
    fruit
  </label>
</div>

<div class="form-check">

  <input class="form-check-input " type="radio" name="producttype" id="flexRadioDefault2" value="vegetables">
  <label class="form-check-label" for="flexRadioDefault2">
    vegetables
  </label>
 
</div>
<%}
else { %>
  <div class="form-check float-start me-5">
  <input class="form-check-input" type="radio" name="producttype" id="flexRadioDefault1" value="fruit" >
  <label class="form-check-label" for="flexRadioDefault1">
    fruit
  </label>
</div>

<div class="form-check">

  <input class="form-check-input " type="radio" name="producttype" id="flexRadioDefault2" value="vegetables" checked="checked">
  <label class="form-check-label" for="flexRadioDefault2">
    vegetables
  </label>
 
</div>
<%} %>
  <div class="mb-3">
    <label for="productid" class="form-label mt-2">Product weight</label>
    <input type="text" class="form-control" name="productweight" value="<%=p.getProductweight() %>" id="productid" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="productid" class="form-label mt-2">Product Price</label>64.0
    <input type="text" class="form-control" name="productprice" value="<%=p.getProductprice() %>" id="productid" aria-describedby="emailHelp">
  </div>
   <button type="submit" class="btn btn-primary w-100">update Food</button>
 

</div>

</form>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<p class="text-danger text-center"><%=msg %></p>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>