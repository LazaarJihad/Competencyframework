<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Associations Profil-Compétences</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            margin-bottom: 20px;
            color: #007bff;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .message {
            margin-top: 20px;
            padding: 10px;
            border-radius: 4px;
        }
        .success-message {
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            color: #155724;
        }
        .success-message {
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            color: #721c24;
        }
       
        
    </style>
</head>
</head>
</head>
<body>
    <h2>Associations Profil-Compétences</h2> 
   
    <form action="AssociateSkillsToProfileServlet" method="POST">
        <div>
            <label>Sélectionnez un profil :</label>
            <select name="nomprofile"> <!-- Utilisation de name="nomprofile" pour récupérer le nom du profil -->
                <c:forEach items="${profiles}" var="profile">
                    <option value="${profile.nomprofile}">
                        ${profile.nomprofile}
                    </option>
                </c:forEach>
            </select>
             <select name="salaire"> <!-- Utilisation de name="nomprofile" pour récupérer le nom du profil -->
                <c:forEach items="${profiles}" var="profile">
                    <option value="${profile.salaire}">
                        ${profile.salaire}
                    </option>
                </c:forEach>
            </select>
        </div>

        <label>Compétences :</label><br>
        <c:forEach items="${skills}" var="skill">
            <label>
                <input type="checkbox" name="skills" value="${skill.name},${skill.description},${skill.level},${skill.domain}">
                ${skill.name} - ${skill.description} - ${skill.level} - ${skill.domain}
            </label>
            <br>
        </c:forEach>
        <div class="success-message">
    <% if (request.getAttribute("message") != null) { %>
        <%= request.getAttribute("message") %>
    <% } %>
    </div>
            
        <button type="submit">Enregistrer</button>
    </form>
   
</body>

</html>
