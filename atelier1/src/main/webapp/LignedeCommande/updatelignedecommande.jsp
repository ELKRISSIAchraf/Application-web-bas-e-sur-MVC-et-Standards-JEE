<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Modifier ligne de commande</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="row">
    <div class="col-md-6 mx-auto mt-5">
        <form action="lignedecommande?action=update" method="POST" >
         <input type="hidden" class="form-control" name="id" value="${lignedecommande.id_lignecmd}">
          <input type="hidden" class="form-control" name="idCmd" value="${lignedecommande.id_cmd}">
            <div class="mb-3">
                 <label class="form-label">Produit</label>
               <select name="idPro" class="form-control" >
                  <c:forEach items="${listproduits}" var="pro"><option  <c:if test="${pro.id_pro==lignedecommande.id_pro}">  selected="selected" </c:if>  value="${pro.id_pro}">${pro.nom_pro}</option></c:forEach>   
                   </select>
            </div>  
            <div class="mb-3">
                <label class="form-label">QTE Demandé</label>
                <input type="number" class="form-control" name="qteCmd" value="${lignedecommande.qte_cmd}">               
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