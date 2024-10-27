<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            background-image: url('1.webp');
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        button {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            transition: border-color 0.3s;
            width: 100%;
            box-sizing: border-box;
        }

        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="email"]:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            border: none;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        .login-link {
            text-align: center;
            margin-top: 10px;
        }

        .login-link a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s;
        }

        .login-link a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Inscription</h2>
        <form action="InscriptionServlet" method="post">
            <input type="text" name="username" placeholder="Nom d'utilisateur" required>
            <input type="password" name="password" placeholder="Mot de passe" required>
            <input type="email" name="email" placeholder="Adresse e-mail" required>
            <button type="submit">S'inscrire</button>
        </form>
        <div class="login-link">
            <p>Déjà un compte ? <a href="connexion.jsp">Se connecter</a></p>
        </div>
    </div>
</body>
</html>
