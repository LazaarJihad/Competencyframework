<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modifier les informations</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Modifier les informations</h2>
        <form action="EditInformationServlet" method="post">
            <div class="form-group">
                <label for="oldUsername">Ancien nom d'utilisateur:</label>
                <input type="text" class="form-control" id="oldUsername" name="oldUsername" required>
            </div>
            <div class="form-group">
                <label for="oldPassword">Ancien mot de passe:</label>
                <input type="password" class="form-control" id="oldPassword" name="oldPassword" required>
            </div>
            <div class="form-group">
                <label for="newUsername">Nouveau nom d'utilisateur:</label>
                <input type="text" class="form-control" id="newUsername" name="newUsername" required>
            </div>
            <div class="form-group">
                <label for="newPassword">Nouveau mot de passe:</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword" required>
            </div>
            <div class="form-group">
                <label for="newEmail">Nouvelle adresse e-mail:</label>
                <input type="email" class="form-control" id="newEmail" name="newEmail" required>
            </div>
            <button type="submit" class="btn btn-primary">Enregistrer</button>
            <a href="SkillServlet" class="btn btn-secondary">revenir</a>
        </form>
        <% if (request.getParameter("error") != null && request.getParameter("error").equals("loginerror")) { %>
          <p>Login ou mot de passe incorrect.</p>
             <% } %>
    <% if (request.getParameter("success") != null && request.getParameter("success").equals("ProfileUpdated")) { %>
            <div class="alert alert-success" role="alert">
                Les informations ont été mises à jour avec succès.
            </div>
        <% } %>
    </div>
</body>
</html>
