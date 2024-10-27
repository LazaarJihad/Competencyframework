<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('1.webp');
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #4E79A1;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .signup-link {
            text-align: center;
            font-size: 14px;
        }
        .signup-link a {
            color: #007bff;
            text-decoration: none;
        }
        .signup-link a:hover {
            text-decoration: underline;
        }
        .success-message {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Connexion</h2>
        <form action="ConnexionServlet" method="post">
            <input type="text" name="username" placeholder="Nom d'utilisateur" required>
            <input type="password" name="password" placeholder="Mot de passe" required>
            <button type="submit">Se connecter</button>
        </form>
        <div class="signup-link">
            <p>Nouvel utilisateur ? <a href="inscription.jsp">Créer un compte</a></p>
        </div>
        <div class="success-message">
     <% if (request.getParameter("error") != null && request.getParameter("error").equals("loginerror")) { %>
          <p>Login ou mot de passe incorrect.</p>
    <% } %>
   </div>
   </div>
    
</body>
</html>
