<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>add client</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="container">
<div class="row">
    <div class="col-md-6 mx-auto mt-5">
        <form action="client?action=ajouter" method="POST" >
            <div class="mb-3">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" name="nomCli">
            </div>

            <div class="mb-3">
                <label class="form-label">telephone</label>
                <input type="text" class="form-control" name="teleCli">
            </div>
            <div class="mb-3">
                <label class="form-label">adresse</label>
                <input type="text" class="form-control" name="adrCli">
            </div>
            <div class="d-grid gap-2 ">
                <button type="submit" class="btn btn-primary "><i class="fas fa-save"></i> Enregistrer</button>
            </div>   
        </form>
    </div>
</div>
</div>
</body>
</html>