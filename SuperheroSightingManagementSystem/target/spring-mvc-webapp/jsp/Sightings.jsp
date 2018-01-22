<%-- 
    Document   : Sighting
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
        <title>Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <link href="${pageContext.request.contextPath}/css/SuperheroSightingsStyles.css" rel="stylesheet">
    </head>
    <header>
        <div id="heading"><h1>Sightings</h1></div>
    </header>
    <hr>
    <body>
        <div class="container-fluid"> 
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Superheroes.jsp">Superheroes</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Locations.jsp">Locations</a></li>
                    <li role="presentation" class="tabs"><a href="${pageContext.request.contextPath}/jsp/Organizations.jsp">Organizations</a></li>
                    <li role="presentation" class="active tabs"><a href="${pageContext.request.contextPath}/Sightings/displaySightings">Sightings</a></li>
                </ul>    
            </div>
        </div>
        <div class="container-fluid jumbotron">
            <h3 id="jumboTitle"><p>- Sightings -</p></h3>
            <br>
            <h4><p>Below you can see a list of all sightings listed by date. If there are many sightings you can click the next button or page number. To return to the last page click the last button or the page number. On the right panel you can see details for any sighting you click on.</p></h4>
        </div>  
        <hr>
        <div class="container-fluid" id="buttonSpaceDiv">
            <div class="col-xs-7">               
            </div>
            <div class="col-xs-1">
            </div>
            <div class="col-xs-4" id="buttonHouse">
                <a class="btn btn-primary" type="button" id="createNewButton" href="displayCreateSightingForm?displayCreateSightingFormBool=true">Create New</a>
            </div>
        </div>
        <div class="container-fluid">            
            <div class="col-xs-7" id="displaySightings">
                <table class="table table-striped table-hover table-responsive" id="sightingOutput">
                    <tr scope="row">
                        <th>Date:</th>
                        <th>Location Name:</th>
                        <th>City Name:</th>
                        <th id="centerList">Number of Heroes:</th>
                        <th>Edit / Delete:</th>
                    </tr>
                    <tr scope="row">
                        <c:forEach var="svm" items="${svm}" varStatus="loop">
                        <td>
                            <c:out value="${svm.sighting.sightingDateTime.toLocalDate()}"/>
                        </td>                    
                        <td>
                            <a href="displaySightingDetails?displaySightingDetailsBool=true&sightingId=${svm.sighting.sightingId}" id="show"><c:out value="${svm.location.locationName}"/></a>
                        </td>  
                        <td>
                            <c:out value="${svm.location.address.cityName}"/>
                        </td>
                        <td id="centerList">
                            <c:out value="${svm.superpersonList.size()}"/>                        
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
                <c:if test="${svmSighting.displayCreateSightingFormBool}">
                <div id="sightingAddBox">
                    <form class="form-horizontal" role="form" action="addSighting" method="POST">
                        <h3>Create Sighting</h3>
                        <div>
                            <label for="location" class="col-md-4 control-label">Location:</label>
                            <select name="locationId" class="form-control" id="location">
                                <option disabled selected>Select Location</option>
                                <c:forEach var="loc" items="${svmSighting.allLocationList}">
                                    <option value="${loc.locationId}">&nbsp;<c:out value="${loc.locationName}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <br/>
                        <div class="form-group">
                            <label for="date" class="control-label labelPad">Date:</label>
                            <input type="date" class="form-control editInput" id="date" name="sightingDate"/>
                        </div>
                        <br/>
                        <div class="form-group">
                            <label for="time" class="control-label labelPad">Time:</label>
                            <input type="time" class="form-control editInput" id="time" name="sightingTime"/>
                        </div>
                        <br/>
                        <div>
                            <label for="selectSuper" class="col-md-4 control-label">Super Persons:</label>
                            <div id="chooseSuper">
                                <c:forEach var="sp" items="${svmSighting.allSuperpersonList}" varStatus="loop">
                                   <input type="checkbox" name="superpersonBySightingId" value="${sp.superpersonId}" id="selectSuper">
                                   <c:out value="${sp.person.personFirstName}"/>&nbsp;<c:out value="${sp.person.personLastName}"/><br/>
                                </c:forEach>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group" id="textInput">
                            <label for="comment" id="commentLabel">Description:</label>
                            <textarea class="form-control" rows="5" id="comment" name="sightingDescription"></textarea>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create" id="buttonSpacing1"/>
                                <a href="${pageContext.request.contextPath}/Sightings/displaySightings" type="button" class="btn btn-danger" value="Cancel" id="buttonSpacing2">Cancel</a>
                            </div>
                        </div>
                    </form>  
                </div>
                </c:if>
                <c:if test="${svmSighting.displayEditSightingFormBool}">
                <div id="editSighting">
                    <form class="form-horizontal" role="form" modelAttribute="svmSighting" action="editSighting" method="POST">                    
                        <div scope="row" id="fullRow">
                            <h3 id="editHeader">Edit Sighting:</h3>
                        </div>
                        <div>
                            <label for="location" class="col-md-4 control-label">Location:</label>
                            <select name="locationId" class="form-control" id="location">
                                <option value="${svmSighting.location.locationId}" selected><c:out value="${svmSighting.location.locationName}"/></option> 
<!--                                if statement to test whether current location is correct and select it-->
                                <c:forEach var="loc" items="${svmSighting.allLocationList}">
                                    <option value="${loc.locationId}">&nbsp;<c:out value="${loc.locationName}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <br/>
                        <div class="form-group">
                            <label for="date" class="control-label labelPad">Date:</label>
                            <input type="date" class="form-control editInput" id="date" name="sightingDate" value="${svmSighting.sighting.sightingDateTime.toLocalDate()}"/>
                        </div>
                        <div class="form-group">
                            <label for="time" class="control-label labelPad">Time:</label>
                            <input type="time" class="form-control editInput" id="time" name="sightingTime" value="${svmSighting.sighting.sightingDateTime.toLocalTime()}"/>
                            <input type="hidden" name="sightingId" value="${svmSighting.sighting.sightingId}"/>
                            <input type="hidden" name="userId" value="1"/>
                        </div>
                        <div class="form-group">
                            <label for="editSupers" class="control-label labelPad">Superheroes Currently At This Sighting:</label>
                            <div id="pickSupers">
                                <c:forEach var="sp" items="${svmSighting.superpersonList}" varStatus="loop">
                                    <c:out value="${sp.person.personFirstName}"/>&nbsp;
                                    <c:out value="${sp.person.personLastName}"/>
                                    <a title="Remove SuperPerson From Sighting" href="removeSuperPersonFromSighting?displayEditSightingFormBool=true&superPersonId=${sp.superpersonId}&sightingId=${svmSighting.sighting.sightingId}">x</a>
                                    <br/>
                                </c:forEach>    
                                Add An Additional Superhero:
                                <br>
                                <c:forEach var="sp" items="${svmSighting.allSuperpersonList}" varStatus="loop">
                                    <input name="superpersonBySightingId" type="checkbox" id="selectSuper" name="allSuperPersonIds" value="${sp.superpersonId}">
                                    <c:out value="${sp.person.personFirstName}"/>&nbsp;
                                    <c:out value="${sp.person.personLastName}"/><br/>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group" id="textInput">
                            <label for="comment" id="commentLabel">Description:</label>
                            <textarea class="form-control" rows="5" id="comment" name="sightingDescription"><c:out value="${svmSighting.sighting.sightingDescription}"/></textarea>
                        </div>    
                        <div class="displaySizingRows" id="buttons">
                            <input type="submit" class="btn btn-default" value="Edit Sighting" id="buttonSpacing3"/>
                            <a href="${pageContext.request.contextPath}/Sightings/displaySightings" type="button" class="btn btn-danger" value="Cancel" id="buttonSpacing4">Cancel</a>
                        </div>
                    </form>
                </div>    
                </c:if>
                <c:if test="${svmSighting.displaySightingDetailsBool}">
                <div id="sightingDisplayBox"> 
                    <table class="table table-striped table-hover table-responsive" id="sightingOutput">                    
                            <tr scope="row" id="fullRow">
                                <th class="text-center">Details:</th>
                            </tr>
                            <tr scope="row" class="displaySizingRows">
                                <td>Location:</td>
                                <td class="displayRowsRight"><c:out value="${svmSighting.location.locationName}"/></td>
                            </tr>
                            <tr scope="row" class="displaySizingRows">
                                <td>Date:</td>
                                <td class="displayRowsRight"><c:out value="${svmSighting.sighting.sightingDateTime.toLocalDate()}"/></td>
                            </tr>
                            <tr scope="row" class="displaySizingRows">
                                <td>Time:</td>
                                <td class="displayRowsRight"><c:out value="${svmSighting.sighting.sightingDateTime.toLocalTime()}"/></td>
                            </tr>
                            <tr scope="row" class="displaySizingRows">
                                <td>Superpeople:</td>
                                <td class="displayRowsRight">
                                    <c:forEach var="superperson" items="${svmSighting.superpersonList}" varStatus="loop">
                                    <c:out value="${superperson.person.personFirstName}"/>&nbsp;
                                    <c:out value="${superperson.person.personLastName}"/>,&nbsp; 
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr scope="row" class="displaySizingRows">
                                <td>Description:</td>
                                <td class="displayRowsRight"><c:out value="${svmSighting.sighting.sightingDescription}"/></td>
                            </tr>
                            <tr scope="row" class="displaySizingRows">
                                <td>User:</td>
                                <td class="displayRowsRight"><c:out value="${svmSighting.user.person.personFirstName}"/>&nbsp;<c:out value="${svmSighting.user.person.personLastName}"/></td>
                            </tr>                        
                    </table>
                </div> 
                </c:if>
            </div>
        </div>
        <div id="spacingDiv">
        </div>
        <div class="container-fluid" id="paginationDiv">
            <div class="col-xs-7" id="paginationContainer">
                <c:forEach var="pageNum" items="${pageNumbers}">
                    <a href="${pageContext.request.contextPath}/Sightings/displaySightings?offset=0&pageNumber=${pageNum}">
                    <c:out value="${pageNum}"/>
                    </a>
                </c:forEach>
            </div>
            <div class="col-xs-1">
            </div>
            <div class="col-xs-4">
            </div>
        </div>
        
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <noscript>
            <div>Please update your browser to the most recent version of Java, or, if it is disabled, enable Javascript.</div>
            <div>Until you complete this operation you will not be able to view or use this web application.</div>
        </noscript>
    </body>
</html>