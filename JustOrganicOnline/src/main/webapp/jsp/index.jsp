<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.justorganic.com</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
 <div id="home"> 
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active bg-dark" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2" class="bg-dark"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3" class="bg-dark"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active" id="img1">
                <img src="/JustOrganicOnline/img/veg1.jpg" class="d-block w-100 h-100 "  alt="">
              </div>
              <div class="carousel-item" id="img2"> 
                <img src="/JustOrganicOnline/img/veg2.jpg" class="d-block w-100 h-100"  alt="">
              </div>
              <div class="carousel-item" id="img3">
                <img src="/JustOrganicOnline/img/veg3.jpg" class="d-block w-100 h-100" alt="">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden text-dark">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>