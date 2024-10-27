<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Éditer un profile </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Éditer un profile</h2>
        <form action="EditerProfileServlet" method="POST">
              <input type="hidden" name="IdProfile" value="${param.IdProfile}">
            <div class="form-group"> 
                <label for="name">Nom du profile:</label>
                <input type="text" class="form-control" id="nomprofile" name="nomprofile" value="${profile.nomprofile}" required>
            </div>
           
            <div class="form-group">
                <label for="domain">salaire:</label>
                <input type="text" class="form-control" id="salaire" name="salaire" value="${profile.salaire}" required>
            </div>
            
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
    </div>
</body>
</html>
