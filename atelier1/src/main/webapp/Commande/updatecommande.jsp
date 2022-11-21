<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Modifier commande</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="row">
    <div class="col-md-6 mx-auto mt-5">
        <form action="commande?action=update" method="POST" >
         <input type="hidden" class="form-control" name="id" value="${commande.id_cmd}">
            <div class="mb-3">
                <label class="form-label">Date</label>
                <input type="date" class="form-control" name="dateCmd" value="${commande.date_cmd}">               
            </div>
            <div class="mb-3">
                 <label class="form-label">Client</label>
               <select name="idCli" class="form-control" >
                  <c:forEach items="${listclients}" var="cli"><option  <c:if test="${cli.id_cli==client.id_cli}">  selected="selected" </c:if>  value="${cli.id_cli}">${cli.nom_cli}</option></c:forEach>   
                   </select>
            </div>           
            <div class="d-grid gap-2 ">
                <button type="submit" class="btn btn-primary "><i class="fas fa-save"></i> Modifier</button>
            </div>   
        </form>
    </div>
</div>
</div>
</body>
</html>