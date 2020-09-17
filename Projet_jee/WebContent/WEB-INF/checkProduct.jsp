<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<link rel="stylesheet" type="text/css" href="inc/article.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<header style="width:100%;
	height:70px;
	 margin: 0px;
  padding: 0px;
	background-color: #696969 ;">
	<h1 style="position:absolute;
	padding:3px;
	float:left;
	margin-left: 2%;
	margin-top: 10px;
	color: white;">Ebay</h1>
	<nav>
	<ul style="width: auto;
	float: right;
	margin-top: 8px;
	display: inline-block;">


		<li style="display: inline-block;
	padding: 15px 30px;"><a style="color: white;font-weight: bold;" href="accueil?goTo=accueil">Home</a></li>
		
	</ul>
	</nav> </header>
	 <div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" src="${image }" />
                </div>
                <div class="col-xs-5" style="border:0px solid gray">
                    <h3><c:out value="${title }"></c:out></h3>    
                    <h5 style="color:#337ab7"><c:out value="${description }"></c:out></h5>
        
                    <h6 class="title-price"><small>PRIX</small></h6>
                    <h3 style="margin-top:0px;"><c:out value="${prix}"> &#8364;</c:out></h3>
        
                    
                    
                    <div class="section" style="padding-bottom:20px;">
                        <h6 class="title-attr"><small>Quantité</small></h6>                    
                        <div>
                            <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                            <input value="1" />
                            <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                        </div>
                    </div>                
        
                    <!-- Botones de compra -->
                    <div class="section" style="padding-bottom:20px;">
                        <a class="btn btn-success"
									href="accueil?goTo=accueil&add=addtopanier">
									<span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to Basket</a>
                    </div>                                        
                </div>                              		
            </div>
        </div>   
<script>
$(document).ready(function(){
    //-- Click on detail
    $("ul.menu-items > li").on("click",function(){
        $("ul.menu-items > li").removeClass("active");
        $(this).addClass("active");
    });

    $(".attr,.attr2").on("click",function(){
        var clase = $(this).attr("class");

        $("." + clase).removeClass("active");
        $(this).addClass("active");
    });

    //-- Click on QUANTITY
    $(".btn-minus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            if (parseInt(now) -1 > 0){ now--;}
            $(".section > div > input").val(now);
        }else{
            $(".section > div > input").val("1");
        }
    });           
    $(".btn-plus").on("click",function(){
        var now = $(".section > div > input").val();
        if ($.isNumeric(now)){
            $(".section > div > input").val(parseInt(now)+1);
        }else{
            $(".section > div > input").val("1");
        }
    });                      
});
</script>     
</body>
</html>