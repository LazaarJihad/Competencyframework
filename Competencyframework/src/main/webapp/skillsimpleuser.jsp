<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des compétences</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        /* Styles spécifiques à la page */
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
            background-image: url('OIP.jpg');
            color: #ffffff;
            
        }
        .container {
            margin-top: 50px;
            background-color: #2378B5;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h2 {
            color: #007bff;
            font-size: 28px;
            font-weight: 700;
            margin-bottom: 20px;
        }
        .search-box {
            margin-bottom: 20px;
        }
        .table {
            border-radius: 10px;
            overflow: hidden;
            
        }
        .thead-light th {
            background-color: #007bff;
            color: #ffffff;
            font-weight: 700;
            border: none;
        }
        
        tbody tr:hover {
            background-color: #e9ecef;
        }
        .form-control {
            border-radius: 20px;
            border-color: #007bff;
            transition: border-color 0.3s;
        }
        .form-control:focus {
            border-color: #0056b3;
            box-shadow: none;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
         <div class="mt-3 text-right"> <!-- Alignement des boutons à droite -->
        <a href="editerinformation.jsp" class="btn btn-warning btn-modern"><i class="fas fa-user-edit"></i> Modifier</a>
        <a href="connexion.jsp" class="btn btn-danger btn-modern"><i class="fas fa-sign-out-alt"></i> Déconnexion</a>
        
    </div>
        <h2>Liste des compétences</h2>
        
        <div class="search-box">
            <input type="text" class="form-control" id="search" placeholder="Rechercher une compétence...">
        </div>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>niveau</th>
                    <th>Niveau</th>
                    <th>categorie</th>
                    <th>profile</th>
                    
                </tr>
            </thead>
           <tbody>
                <c:forEach var="skill" items="${skills}">
    <tr>
        <th>${skill.name}</th>
        <td>${skill.description}</td>
        <td>${skill.domain}</td>
        <td>${skill.level}</td>
        <td>${skill.categorie}</td>
        <td>
          <div class="d-flex">ii
                                   
            <a sqahref="ViewAssociatedProfilesServlet?skillId=${skill.id}" class="btn btn-danger btn-sm" role="button"><i class="fas fa-trash-alt"></i> profile</a>
           </div>
       </td> 
    </tr>
</c:forEach>
                
            </tbody>
        </table>
    </div>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // Script pour la fonction de recherche
        $(document).ready(function() {
            $('#search').on('keyup', function() {
                var value = $(this).val().toLowerCase();
                $('tbody tr').filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
</body>
</html>
