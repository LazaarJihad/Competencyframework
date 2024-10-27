<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter une compétence</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Couleur de fond */
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #007bff; /* Couleur du titre */
            margin-bottom: 30px;
            text-align: center;
        }
        label {
            font-weight: bold;
        }
        textarea.form-control {
            resize: vertical; /* Permet de redimensionner verticalement */
        }
        button[type="submit"] {
            background-color: #007bff; /* Couleur de fond du bouton */
            border: none;
        }
        button[type="submit"]:hover {
            background-color: #0056b3; /* Couleur de fond du bouton au survol */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Ajouter une compétence</h2>
        <form action="SkillServlet" method="POST">
            <div class="form-group">
                <label for="name">Nom de la compétence:</label>
                <input type="text" class="form-control" id="name" name="name" required>
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
                <label for="categorie">categorie</label>
                <input type="text" class="form-control" id="categorie" name="categorie" required>
            </div>
            <div class="form-group">
                <label for="level">Niveau:</label>
                <select class="form-control" id="level" name="level" required>
                    <option value="">Sélectionnez un niveau</option>
                    <option value="Débutant">Débutant</option>
                    <option value="Intermédiaire">Intermédiaire</option>
                    <option value="Avancé">Avancé</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>
    </div>
</body>
</html>
