<%-- 
    Document   : Organizations
    Created on : Oct 26, 2017, 1:57:06 PM
    Author     : EJB Laptop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organizations</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/SuperheroSightingsStyles.css" rel="stylesheet">
    </head>
    <header>
        <div id="heading"><h1>Organizations</h1></div>
    </header>
    <hr>
    <body>
        <div class="container-fluid"> 
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Superheroes.jsp">Superheroes</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Locations.jsp">Locations</a></li>
                    <li role="presentation" class="active tabs"><a href="${pageContext.request.contextPath}/Organizations/displayOrganizations">Organizations</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/Sightings/displaySightings">Sightings</a></li>
                </ul>    
            </div>
        </div>
        <div class="container-fluid jumbotron">
            <h3 id="jumboTitle"><p>- Organizations -</p></h3>
            <br>
            <h4><p>Below you can see a list of all organizations. If there are many organizations you can click the next button or page number. To return to the last page click the last button or the page number. On the right panel you can see details for any organization you click on.</p></h4>
        </div>  
        <hr>
        <div class="container-fluid" id="buttonSpaceDiv">
            <div class="col-xs-7">               
            </div>
            <div class="col-xs-1">
            </div>
            <div class="col-xs-4" id="buttonHouse">
                <button class="button-button" id="createButton">Create New</button>
            </div>
        </div>
        <div class="container-fluid">            
            <div class="col-xs-7" id="displaySightings">
                <table class="table table-striped table-hover table-responsive" id="sightingOutput">
                    <tr scope="row">
                        <th>Organization Name:</th>
                        <th>Morality Type:</th>
                        <th>City Name:</th>
                        <th>Edit / Delete:</th>
                    </tr>
                    <tr scope="row">
                        <c:forEach var="ovm" items="${ovm}" varStatus="loop">
                        <td>
                            <c:out value="${ovm.organization.organizationName}"/>
                        </td>                    
                        <td>
                            <a href="displaySightingDetails?displaySightingDetailsBool=true&sightingId=${svm.sighting.sightingId}" id="show"><c:out value="${svm.location.locationName}"/></a>
                        </td>  
                        <td>
                            <c:out value="${ovm.organization.address.cityName}"/>
                        </td>
                        <td>
                            <a href="displayEditSightingForm?displayEditSightingFormBool=true&sightingId=${svm.sighting.sightingId}">Edit</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="#">Delete</a>
                        </td>
                    </tr>
                    <tr scope="row">
                        </c:forEach>
                    </tr>                            
                </table>
            </div>
            <div class="col-xs-1" id="displayBuffer">               
            </div>
            <div class="col-xs-4" id="displayDetails">
                <table class="table table-striped table-hover table-responsive" id="sightingOutput">
                    <tr scope="row">
                        <th class="text-center">Details:</th>
                    </tr>
                </table>
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