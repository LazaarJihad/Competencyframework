<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@page import="ma.ac.esi.referentielCompetences.model.Skill"%>
<%@page import="ma.ac.esi.referentielCompetences.model.SkillDAO"%>
<%@page import="java.util.List"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ajouter une compÃ©tence</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<style>
.container {
margin-top: 20px;
}
#successAlert {
 position: fixed;
 top: 20%;
 left: 50%;
 transform: translateX(-50%);
 z-index: 1050;
 display: none; /* Cachée par défaut */
 }

</style>
</head>
<body>
    <div class="container">
    <div class="alert alert-success" role="alert" id="successAlert" style="display: none;">
          <% if (request.getAttribute("message") != null) { %>
                <%= request.getAttribute("message") %>
          <% } %>
    </div>
    <h2>Ajouter une competence</h2>
    <form action="SkillServlet" method="POST">
    <div class="form-group">
    <label for="name">Nom de la competence:</label>
    <input type="text" class="form-control" id="name" name="name"required>
  </div>
    <div class="form-group">
    <label for="description">Description:</label>
    <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
  </div>
  <div class="form-group">
     <label for="domain">Domaine:</label>
     <input type="text" class="form-control" id="domain" name="domain" required>
  </div>
   <div class="form-group">
   <label for="level">Niveau:</label>
   <select class="form-control" id="level" name="level" required>
       <option value="">Selectionnez un niveau</option>
       <option value="DÃ©butant">Debutant</option>
       <option value="IntermÃ©diaire">Intermediaire</option>
       <option value="AvancÃ©">Avance</option>
   </select>
   </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
  </form>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script>
       $(document).ready(function() {

        <% if (request.getAttribute("message") != null) { %>
        // Affiche l'alerte
      $('#successAlert').show();
       // Masque l'alerte après 2 secondes (2000 millisecondes)
        setTimeout(function() {
     $('#successAlert').fadeOut('slow');
       }, 2000); // 2 secondes
      <% } %>
 });
 </script>
 <div class="mt-5">
 <h3>Liste des compétences</h3>
 <table class="table">
 <thead class="thead-light">
 <tr>
 <th>Nom</th>
 <th>Description</th>
 <th>Domaine</th>
 <th>Niveau</th>
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
 <td>
<div class="d-flex">
<a href="editSkill.jsp?id=${s.id}" class="btn btn-primary btn-sm"
style="margin-right: 10px;" role="button"><i class="fas fa-edit"></i>
Éditer</a>
<a href="deleteSkillServlet?id=${s.id}" class="btn btn-danger btn-sm"
role="button"><i class="fas fa-trash-alt"></i> Supprimer</a>
 </div>
 </td>
 </tr>
 </c:forEach>
 </c:when>
 <c:otherwise>
 <tr>
 <td colspan="5">Aucune compétence trouvée.</td>
 </tr>
 </c:otherwise>
 </c:choose>
</tbody>
 </table>
</div>
<body>
</html>