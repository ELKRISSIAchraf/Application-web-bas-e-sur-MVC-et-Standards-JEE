<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Modifier client</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="row">
    <div class="col-md-6 mx-auto mt-5">
        <form action="client?action=update" method="POST" >
         <input type="hidden" class="form-control" name="id" value="${client.id_cli}">
            <div class="mb-3">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" name="nomCli" value="${client.nom_cli}">
                
            </div>
            <div class="mb-3">
                <label class="form-label">telephone</label>
                <input type="text" class="form-control" name="teleCli" value="${client.tele_cli}">
            </div>
            <div class="mb-3">
                <label class="form-label">adresse</label>
                <input type="text" class="form-control" name="adrCli" value="${client.adr_cli}">
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