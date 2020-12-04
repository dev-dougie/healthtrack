<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE-edge, chrome=1">
    <%@include file = "header.jsp" %>
    <title>Menu File</title>
</head>

<style>
    #brand {
        text-decoration: none;
        color: white;
    }
</style>

<body>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" style="background-color: #e3f2fd;">
        <a class="navbar-brand" id="brand">Health Track</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li>
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sobre.jsp">Quem Somos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="planos.jsp">Assine</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contato.jsp">Contate-nos</a>
                </li>
            </ul>

            <form class="form-inline mt-4 mt-md-0">
                <a href="https://www.instagram.com/" class="nav-link"><img src="resources/Imagens/ig.png" width="20"
                        height="20"></a>
                <a href="https://www.facebook.com/" class="nav-link"><img src="resources/Imagens/facebook.png"
                        width="20" height="20"></a>
            </form>

            <form class="form-inline mt-2 mt-md-0">
                <a href="login.jsp" class="btn btn-outline-success my-2 my-sm-0" role="button" aria-pressed="true"
                    id="login"><svg class="bi bi-person-fill" width="2em" height="2em" viewBox="0 0 16 16"
                        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                            d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                    </svg>Login</a>
            </form>
        </div>
    </nav>
</body>

</html>