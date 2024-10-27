<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des compétences</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
       body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa; /* Couleur de fond par défaut */
   background-image: url('OIP.jpg');
}


        .container {
            margin-top: 50px;
        }
        h3 {
            color: #007bff;
        }
        th, td {
            vertical-align: middle;
            
             color: #fff; /* Couleur du texte des cellules */

        }
        .btn-primary, .btn-danger, .btn-info {
            color: #fff;
            border-radius: 20px;
            transition: background-color 0.3s ease;
            margin-left: 80px;
        }
        .btn-primary:hover, .btn-danger:hover, .btn-info:hover {
            color: #fff;
        }
        .btn-primary {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-info {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-group {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="mt-3 text-right"> <!-- Alignement des boutons à droite -->
        <a href="editerinformation.jsp" class="btn btn-warning btn-modern"><i class="fas fa-user-edit"></i> Modifier</a>
        <a href="connexion.jsp" class="btn btn-danger btn-modern"><i class="fas fa-sign-out-alt"></i> Déconnexion</a>
        
    </div>
            <h3>Liste des compétences</h3>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Domaine</th>
                        <th>Niveau</th>
                        <th>Catégorie</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="skillsTableBody">
                    <c:choose>
                        <c:when test="${not empty items}">
                            <c:forEach var="s" items="${items}">
                                <tr>
                                    <td>${s.name}</td>
                                    <td>${s.description}</td>
                                    <td>${s.domain}</td>                                                                                                 
                                    <td>${s.level}</td>
                                    <td>${s.categorie}</td>
                                    <td>
                                      <div class="d-flex">
                                           <a href="Editer.jsp?id=${s.id}" class="btn btn-primary btn-sm" role="button"><i class="fas fa-edit"></i> Éditer</a>
                                            <a href="supprimerServlet?id=${s.id}" class="btn btn-danger btn-sm" role="button"><i class="fas fa-trash-alt"></i> Supprimer</a>
                                      </div>
                                    </td>                                   
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="6">Aucune compétence trouvée.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
         
       <a href="AjouterCompetence.jsp" class="btn btn-primary" style="background-color: #007bff;">Ajouter une compétence</a>
       <a href="AjouterProfile.jsp" class="btn btn-primary" style="background-color: #28a745;">Ajouter un profile</a>
      <a href="ProfileServlet" class="btn btn-info" style="background-color: #ffc107;">Gérer les profils</a>
      <a href="AssociateSkillsToProfileServlet" class="btn btn-info" style="background-color: #dc3545;">Associer les compétences aux profils</a>
       
    </div>
</body>
</html>
