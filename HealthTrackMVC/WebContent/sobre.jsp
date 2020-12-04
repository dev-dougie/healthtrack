<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <%@include file = "header.jsp" %>
    <link href= "resources/css/bootstrap.css" type = "text/css" rel = "stylesheet">
    <link rel = "icon" type = "Image/svg" href = "resources/Imagens/sobre.svg">
    <title>Sobre</title>
</head>

<style>
	

	.container-fluid{
		margin-top: 150px;
		color:black;
	}
	
	.container{
		display:grid;
		grid-template-columns: repeat(2, 1fr);
		grid-column-gap: 20px;
	}
	
</style>

<div class="container-fluid">

    <body class = "corpo-sobre">
        <header>
            <%@include file = "menu.jsp" %>
        </header>
        
        <main>
            <h3>O Health Track é o aplicativo ideal para pessoas que desejam fazer o acompanhamento de saúde de maneira
                simples e intuitiva.
                Nosso produto permite que as informações inseridas sejam verificadas e analisadas para que se possa
                estipular métricas (indicativos específicos escolhidos)
                ideais para o usuário, além de diversas outras funcionalidades.
                <a href="planos.jsp">Confira os nossos planos</a>, escolha o ideal para você.
            </h3>
            <hr />
            <image class="container">
                <img src="resources/Imagens/iphone.jpg" width="400" heigh="600" alt="Imagem demnostrando o app"
                    title="App Health Track" image-border="25px" figcaption="Imagem ilustrativa">
                <img src="resources/Imagens/iphone2.jpg" width="382" heigh="400" alt="Imagem demnostrando o app"
                    title="App Health Track" figcaption="Imagem ilustrativa">
            </image>
        </main>
    </body>
</div>

</html>