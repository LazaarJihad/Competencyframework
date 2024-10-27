<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profils Associés</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa; /* Couleur de fond */
            color: #212529; 
             background-image: url('5.jpg');
        }
        .container {
            margin-top: 50px;
        }
        h2 {
            color: #007bff; /* Couleur du titre */
            margin-bottom: 30px; /* Marge inférieure */
        }
        th {
            font-weight: bold; /* Texte en gras */
        }
        td {
            vertical-align: middle; /* Alignement vertical au centre */
        }
        .table {
            background-color: #fff; /* Fond de la table */
            border-radius: 10px; /* Coins arrondis */
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Ombre légère */
        }
        .thead-light th {
            background-color: #f8f9fa; /* Fond de l'en-tête de la table */
        }
        .error-message {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Profils Associés à la Compétence</h2>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th>Nom</th>
                    <th>Salaire</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="profile" items="${associatedProfiles}">
                    <tr>
                        <td>${profile.nomprofile}</td>
                        <td>${profile.salaire}</td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     <div class="error-message">
    <% if (request.getAttribute("errorMessage") != null) { %>
        <%= request.getAttribute("errorMessage") %>
    <% } %>
    </div>
    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
