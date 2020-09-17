<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="inc/design.css">
</head>
<body>

	<header>
	<h1>Ebay</h1>
	<nav>
	<ul>


		<li><a class="haut" href="accueil?goTo=accueil">Home</a></li>
		<c:choose>
			<c:when test="${session == null}">
				<li><a class="haut" href="accueil?goTo=connexion">Login</a></li>
				<li><a class="haut" href="accueil?goTo=inscription">Sign-up</a></li>
			</c:when>
			<c:when test="${session != null}">
				<li><a class="haut" href="accueil?goTo=logout"
					style="color: #F24638;">Logout</a></li>
				<li><a href="#"><c:out value="${username }"></c:out>
				</a></li>
			</c:when>
		</c:choose>
		<li><a class="haut" href="#">panier(<c:out value="${panier}"></c:out>)
		</a></li>
	</ul>
	</nav> </header>
	<div class="topnav">
		<ul>
			<li><a class="active" href="accueil?goTo=getproducts">All
					Products</a></li>
			<li><a href="accueil?goTo=homefurniture">Home Furniture</a></li>
			<li><a href="accueil?goTo=clothings">Clothings</a></li>
			<li><a href="accueil?goTo=garden">Garden</a></li>
			<li><a href="accueil?goTo=laptops">Laptops</a></li>
			<li><a href="accueil?goTo=mobiles">Mobiles</a></li>
			<li><a href="accueil?goTo=games">Games</a></li>
			<li><a href="accueil?goTo=jewelry">Jewelry</a></li>
			<li><a href="accueil?goTo=sports">Sports</a></li>
			<li><a href="accueil?goTo=hightech">High-tech</a></li>
			<li><a href="accueil?goTo=pharmacy">Pharmacy</a></li>
		</ul>
	</div>

	<div class="wrap">
		<div id="arrow-left" class="arrow"></div>
		<div id="slider">
			<div class="slide slide1">
				<div class="slide-content">
					<span>Home furniture</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=homefurniture'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide2">
				<div class="slide-content">
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=garden'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide3">
				<div class="slide-content">
					<span>Clothing</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=clothings'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide4">
				<div class="slide-content">
					<span>Laptops</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=laptops'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide5">
				<div class="slide-content">
					<span>Mobiles</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=mobiles'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide6">
				<div class="slide-content">
					<span>Games</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=games'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide7">
				<div class="slide-content">
					<span>Jewelry</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=jewelry'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide8">
				<div class="slide-content">
					<span>Sports</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=sports'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide9">
				<div class="slide-content">
					<span>HIGH-TECH</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=hightech'"
						class="btn">View Products</button>
				</div>
			</div>
			<div class="slide slide10">
				<div class="slide-content">
					<span>Pharmacy</span>
					<button
						onclick="location.href='http://localhost:8081/Projet_jee/accueil?goTo=pharmacy'"
						class="btn">View Products</button>
				</div>
			</div>

		</div>
		<div id="arrow-right" class="arrow"></div>
	</div>
	<div class="pagewhole-content">
		<div class="container">
			<br>

			

			<div class="container">
				<c:forEach items="${list }" var="product" varStatus="counter">
					<c:if test="${(counter.count) % 4 == 1}">
						<div class="row">
					</c:if>
					<div class="col-xs-3">
						<img src="${product.getImage() }" class="img-responsive"><br>
						<div class="text-center">
							<a style="color: black;"><c:out
									value="${product.getTitre() }"></c:out></a>
						</div>
						<p style="text-align: center;">
							<c:out value="${ product.getPrice() }"></c:out>
							&#8364;
						</p>
						<div class="text-center">
							<a class="btn btn-success"
								href="accueil?goTo=checkProduct&id=<c:out value="${product.getId()}"/>">View
								Product</a> <br /> <br /> <a class="btn btn-success"
								href="accueil?goTo=accueil&add=addtopanier">Add to Basket</a>
						</div>
						<br>
					</div>
					<c:if test="${(counter.count) % 4 == 0}">
						</div>
					</c:if>
				</c:forEach>
			</div>

		</div>
	</div>


	<footer>
	<div class="footer">
		&copy; 2019 Copyright: <a href="accueil?goTo=index"> Ebay.fr</a>
	</div>
	</footer>
	<script>
	let sliderImages = document.querySelectorAll(".slide"),
	arrowLeft = document.querySelector("#arrow-left"),
	arrowRight = document.querySelector("#arrow-right"),
	current = 0;

//Clear all images
function reset() {
	
for (let i = 0; i < sliderImages.length; i++) {
  sliderImages[i].style.display = "none";
}
}

//Init slider
function startSlide() {
	reset();
	sliderImages[0].style.display = "block";
}

//Show prev
function slideLeft() {
	reset();
	sliderImages[current - 1].style.display = "block";
	current--;
}

//Show next
function slideRight() {
	reset();
	sliderImages[current + 1].style.display = "block";
	current++;
}

//Left arrow click
arrowLeft.addEventListener("click", function() {
	if (current === 0) {
	  current = sliderImages.length;
	}
	slideLeft();
});

//Right arrow click
arrowRight.addEventListener("click", function() {
	if (current === sliderImages.length - 1) {
	  current = -1;
	}
	slideRight();
});

startSlide();

</script>
</body>
</html>