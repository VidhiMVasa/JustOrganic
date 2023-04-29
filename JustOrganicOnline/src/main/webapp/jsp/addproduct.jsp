<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add food form</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container mb-3 shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px">
<p class="text-primary text-center h2 m-3">Add Product here!!</p>

<form action="/JustOrganicOnline/productc" method="post" >
<input type="hidden" name="action" value="addproduct">
  <div class="mb-3">
    <label for="productname" class="form-label mt-2">Product Name</label>
    <input type="text" class="form-control" name="productname" id="productname" aria-describedby="emailHelp">
  </div>
  <div class="mb-1">
    <label for="producttype" class="form-label">Product Type</label>
  </div>
  <div class="form-check float-start me-5">
  <input class="form-check-input" type="radio" name="producttype" id="flexRadioDefault1" value="fruit">
  <label class="form-check-label" for="flexRadioDefault1">
    fruit
  </label>
</div>
<div class="form-check">

  <input class="form-check-input " type="radio" name="producttype" id="flexRadioDefault2" value="non-veg">
  <label class="form-check-label" for="flexRadioDefault2">
    vegetables
  </label>
</div>

   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Product weight</label>
    <input type="number" min=1 class="form-control" step=0.5 name="productweight" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
 
   <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Product Price</label>
    <input type="text" class="form-control" name="productprice" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Pruduct Image</label>
    <input type="file" class="form-control" name="productimage" id="exampleInputPassword1">
  </div>
 
  <button type="submit" class="btn btn-primary w-100">Add Food</button>
 
</form>

</div>
<%
String msg=(String)request.getAttribute("msg");
    		if(msg!=null){    		
%>
<p class="text-danger text-center"><%=msg %></p>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
