<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Éditer une compétence</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Éditer une compétence</h2>
        <form action="EditerSkillServlet" method="POST">
            <input type="hidden" name="id" value="${param.id}">
            
            <div class="form-group"> 
                <label for="name">Nom de la compétence:</label>
                <input type="text" class="form-control" id="name" name="name" value="${skill.name}" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" name="description" rows="3" required>${skill.description}</textarea>
            </div>
            <div class="form-group">
                <label for="domain">Domaine:</label>
                <input type="text" class="form-control" id="domain" name="domain" value="${skill.domain}" required>
            </div>
            <div class="form-group">
                <label for="categorie">Catégorie:</label>
                <input type="text" class="form-control" id="categorie" name="categorie" value="${skill.categorie}" required>
            </div>
            <div class="form-group">
                <label for="level">Niveau:</label>
                <select class="form-control" id="level" name="level" required>
                    <option value="Débutant" ${skill.level == 'Débutant' ? 'selected' : ''}>Débutant</option>
                    <option value="Intermédiaire" ${skill.level == 'Intermédiaire' ? 'selected' : ''}>Intermédiaire</option>
                    <option value="Avancé" ${skill.level == 'Avancé' ? 'selected' : ''}>Avancé</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form>
    </div>
</body>
</html>
