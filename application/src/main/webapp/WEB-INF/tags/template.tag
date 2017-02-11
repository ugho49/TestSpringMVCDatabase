<%@tag description="template de chaque page" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="false" type="java.lang.String" %>
<%@attribute name="style" required="false" fragment="true" %>
<%@attribute name="script" required="false" fragment="true" %>
<%@attribute name="content" required="true" fragment="true" %>

<!doctype html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>
        <c:choose>
            <c:when test="${empty title}">TestSpringMVC</c:when>
            <c:otherwise>${title}</c:otherwise>
        </c:choose>
    </title>
	
	<!-- Google Font -->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      
	<!-- Stylesheets -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
	<spring:url value="/static/css/style.css" var="style_css"/>
	<link rel="stylesheet" href="${style_css}">

    <!-- Optional stylesheets -->
    <jsp:invoke fragment="style"/>

</head>
<body>

    <%@ include file="../jspf/header.jspf" %>
	
	<div class="row">
	    <section id="container" class="col s12">

			<!-- Main Content -->
			<jsp:invoke fragment="content"/>

	    </section>
	</div>

    <%@ include file="../jspf/footer.jspf" %>
	
	<!-- Scripts -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>

	<spring:url value="/static/js/main.js" var="main_js"/>
	<script src="${main_js}"></script>

    <!-- Optional stylesheets -->
    <jsp:invoke fragment="script"/>

</body>
</html>