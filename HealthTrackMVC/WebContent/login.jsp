<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
 	<%@include file = "header.jsp" %>
    <title>Login - Health Track(BR)</title>
    <link rel="icon" type="Image/svg" href="resources/Imagens/male.svg">
    <link href="resources/css/loginstyle.css" rel="stylesheet">
</head>

<body class="text-center">
    <div class="container-fluid">
        <header class="container-fluid">
            <%@include file = "menu.jsp" %>
        </header>

        <main class="container-fluid">
         <span class="navbar-text text-danger" style="margin-top:40px" style = "backgroud-color:white" >
	        		${erro}
	  		</span>
            <div class="fieldset">
           
                <form class="form-signin" method="POST" action="login">
                    <h1 class="h3 mb-3 font-weight-normal"><svg class="bi bi-person-circle" width="72" height="72"
                            viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg"
                            alt="Ícone de login" title="Ícone de login">
                            <path
                                d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z" />
                            <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                            <path fill-rule="evenodd"
                                d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z" />
                        </svg></h1>
                    <label for="inputEmail" class="sr-only">Email</label>
                    <input type="text" name="email" class="form-control" id = "inputEmail" placeholder="Email ou username" required
                        autofocus><br>
                    <label for="inputPassword" class="sr-only">Senha</label>
                    <input type="password" name="senha" class="form-control" id = "inputSenha" placeholder="Senha" required>
                    <div class="checkbox mb-2">
                        <label>
                            <input type="checkbox" value="remember-me">Lembrar minhas credenciais.
                        </label>
                    </div>


                    <input type="submit" class="btn btn-info" value="Entrar" />
                    <a href="cadastro-usuario.jsp" class="btn btn-lg btn-link" type="link" role="link">Não possui cadastro?
                        Cadastre-se
                        agora!</a>
                    <a href="https://www.facebook.com.br/" class="btn btn-link" type="submit" role="button"
                        aria-pressed="true"><img src="resources/Imagens/facebook.png" widht="25px" height="25px"></a>
                    <a href="https://accounts.google.com/signin/v2/sl/pwd?service=accountsettings&passive=1209600&osid=1&continue=https%3A%2F%2Fmyaccount.google.com%2Fdeleteservices%3Fhl%3Dpt&followup=https%3A%2F%2Fmyaccount.google.com%2Fdeleteservices%3Fhl%3Dpt&hl=pt&emr=1&mrp=preferences&rart=ANgoxcdWxcGCfHTqoggrViIjJIQ0Ilcs5sXlMhzlBF5fnoXc9Ocd4uAgWrldeXu8kz2ET1eD3bYFN5TKxvz6aIicFK5IFX4qOA&authuser=0&csig=AF-SEnbEj933iLBlNMgl%3A1591458273&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
                        class="btn btn-link" type="submit" role="button" aria-pressed="true"><img
                            src="resources/Imagens/google.png" widht="25px" height="25px"></a>

                    <a href="#" class="btn btn-lg btn-link" type="link" role="link">Esqueci minha senha.</a>
                </form>
            </div>
        </main>

</div>
</body>

</html>