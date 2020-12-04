<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@include file = "header.jsp" %>
    <title>Contato - Health Track(BR)</title>
    <link rel="icon" type="Image/png" href="resources/Imagens/contato.png">
    <link href="resources/css/bootstrap.css" type="text/css" rel="stylesheet">
</head>

<body class="ctt">
    <%@include file = "menu.jsp" %>
    <main>
        <div class="container">
        <c:if test="${not empty msg }">
        	<div class = "alert alert-succes">${msg}</div>
        </c:if>
        
         <c:if test="${not empty erro }">
        	<div class = "alert alert-alert">${erro}</div>
        </c:if>
            <form class="form-signin" method="POST" action="contato"><br><br><br>
                <fieldset class="fset-ctt">
                    <legend class="lgs">Fale conosco</legend>
                    <div class="form">
                        <label for="nome_ctt">Nome:</label>
                        <input type="text" class="form-control" name = "nome" id="nome_ctt" placeholder="Digite seu nome completo" required>
                    </div>
                    <div class="form">
                        <label class="label_ctt" for="email_ctt">Endereço de email:</label>
                        <input type="email" class="form-control" name = "email" id="email_ctt" placeholder="seuemail@exemplo.com" required>
                    </div>
                    <div class="form-group">
                        <label class="label_ctt" for="mensagem_ctt">Mensagem:</label>
                        <textarea class="form-control" id="mensagem_ctt" maxlength = "200" name = "mensagem" rows="5" cols="10"
                            placeholder="Digite aqui sua mensagem..." required></textarea>
                    </div>
                    <h1>
                        <button type="button" class="btn btn-outline-danger">Cancelar</button>
                        <button type="submit" class="btn btn-outline-success">Enviar</button>
                    </h1>
                </fieldset>
            </form>
        </div>
    </main>
</body>

</html>