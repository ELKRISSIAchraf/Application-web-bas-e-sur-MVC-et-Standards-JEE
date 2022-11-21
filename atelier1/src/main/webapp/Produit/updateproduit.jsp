<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Modifier produit </title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="row">
    <div class="col-md-6 mx-auto mt-5">
        <form action="produit?action=update" method="POST" >
         <input type="hidden" class="form-control" name="id" value="${produit.id_pro}">
            <div class="mb-3">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" name="nomPro" value="${produit.nom_pro}">
                
            </div>
            <div class="mb-3">
                <label class="form-label">telephone</label>
                <input type="number" class="form-control" name="puPro" value="${produit.pu_pro}">
            </div>
            <div class="mb-3">
                <label class="form-label">adresse</label>
                <input type="number" class="form-control" name="qtePro" value="${produit.qte_pro}">
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