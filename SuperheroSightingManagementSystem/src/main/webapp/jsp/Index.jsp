<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Superhero Sightings: Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/SuperheroSightingsStyles.css" rel="stylesheet">
        <link rel="icon" type="images/gif" href="${pageContext.request.contextPath}/images/icon.jpg">
    </head>
    <header>
        <div id="heading"><h1>Superhero Sightings Home Page</h1></div>
    </header>
    <hr>
    <body>
        <div class="container-fluid"> 
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active tabs"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Superheroes.jsp">Superheroes</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Locations.jsp">Locations</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/Organizations/displayOrganizations">Organizations</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/Sightings/displaySightings">Sightings</a></li>
                </ul>
            </div>
        </div>
        <div class="container-fluid jumbotron">
            <h3 id="jumboTitle"><p>- Welcome to the Superhero Sighting Management System -</p></h3>
            <br>
            <h4><p>This system has been designed for you to easily track and trace superheroes, supervillains, mutants, their overall locations, the places they've been sighted, and their self-appointed organizations. See below for the most recent ten sightings. Click the navbar above to complete other actions related to superhero sightings.</p></h4>
        </div>
        <hr>        
        <div class="container-fluid col-xs-12">
            <div class="col-xs-2">                
            </div>
            <div class="col-xs-8" id="displayFirst10Sightings">            
                <table class="table table-striped table-hover table-responsive" id="sightingOutput">
                    <tr scope="row">
                        <th>Date:</th>
                        <th>Location Name:</th>
                        <th>Superheroes:</th>
                        <th>Description:</th>
                    </tr>
                    <tr scope="row">
                        <c:forEach var="ivm" items="${ivm}" varStatus="loop">
                        <td>
                            <c:out value="${ivm.sighting.sightingDateTime.toLocalDate()}"/>
                        </td>                    
                        <td>
                            <c:out value="${ivm.location.locationName}"/>
                        </td>  
                        <td>
                            <c:forEach var="sp" items="${ivm.superpersonList}" varStatus="loop">
                            <c:out value="${sp.person.personFirstName}"/> 
                            </c:forEach>
                        </td>
                        <td>
                            <c:out value="${ivm.sighting.sightingDescription}"/>                        
                        </td> 
                    </tr>
                    <tr scope="row">
                        </c:forEach>
                    </tr>
                </table>            
            </div>
            <div class="col-xs-2">
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <noscript>
            <div>Please update your browser to the most recent version of Java, or, if it is disabled, enable Javascript.</div>
            <div>Until you complete this operation you will not be able to view or use this web application.</div>
        </noscript>
    </body>
</html>

