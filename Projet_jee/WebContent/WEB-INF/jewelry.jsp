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

		<li><input placeholder="Search.." type="text" size="40"
			width="75"></input>
			<button type="submit">Go!</button></li>
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
			<li><a href="accueil?goTo=getproducts">All
					Products</a></li>
			<li><a href="accueil?goTo=homefurniture">Home Furniture</a></li>
			<li><a href="accueil?goTo=clothings">Clothings</a></li>
			<li><a href="accueil?goTo=garden">Garden</a></li>
			<li><a href="accueil?goTo=laptops">Laptops</a></li>
			<li><a href="accueil?goTo=mobiles">Mobiles</a></li>
			<li><a href="accueil?goTo=games">Games</a></li>
			<li><a class="active" href="accueil?goTo=jewelry">Jewelry</a></li>
			<li><a href="accueil?goTo=sports">Sports</a></li>
			<li><a href="accueil?goTo=hightech">High-tech</a></li>
			<li><a href="accueil?goTo=pharmacy">Pharmacy</a></li>
		</ul>
	</div>

	<div class="pagewhole-content">
		<div class="container">
			<div class="row">
				<br>


				<c:forEach items="${list }" var="product">
					<c:if test="${product.getCategory() == 'jewelry' }">
						<div class="col-md-3">
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
									href="accueil?goTo=jewelry&add=addtopanier">Add
									to Basket</a>
							</div>
							<br>
						</div>
					</c:if>

				</c:forEach>

			</div>
		</div>


		<footer>
		<div class="footer">
			&copy; 2019 Copyright: <a href="accueil?goTo=index"> Ebay.fr</a>
		</div>
		</footer>
</body>
</html>