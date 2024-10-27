<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste de Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #212529;
            background-image: url('5.jpg');
        }
        .container {
            margin-top: 50px;
        }
        h3 {
            color: #007bff;
        }
        th, td {
            vertical-align: middle;
        }
        .btn-primary, .btn-danger {
            color: #fff;
            border-radius: 20px;
            transition: background-color 0.3s ease;
        }
        .btn-primary:hover, .btn-danger:hover {
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
        .btn-group {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="mt-5">
            <h3>Liste des profiles</h3>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>Nom du Profile</th>
                        <th>Salaire</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody id="skillsTableBody">
                    <c:choose>
                        <c:when test="${not empty items}">
                            <c:forEach var="p" items="${items}">
                                <tr>
                                    <td>${p.nomprofile}</td>
                                    <td>${p.salaire}</td>
                                    <td>
                                      <div class="d-flex">
                                           <a href="EditerProfile.jsp?IdProfile=${p.idProfile}" class="btn btn-primary btn-sm" role="button"><i class="fas fa-edit"></i> Éditer</a>
                                            <a href="SupprimerProfileServlet?IdProfile=${p.idProfile}" class="btn btn-danger btn-sm" role="button"><i class="fas fa-trash-alt"></i> Supprimer</a>
                                      </div>
                                    </td>                                   
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="3">Aucun profile trouvé.</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
