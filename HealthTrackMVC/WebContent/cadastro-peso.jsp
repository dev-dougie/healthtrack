<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="ISO-8859-1">
    <%@include file = "header.jsp" %>
    <link href="resources/css/dashboard.css" rel="stylesheet">
    <title>Pesagens</title>
</head>

<body>
    <div class="container-fluid">
        <%@include file = "searchbar.jsp" %>
        <%@include file = "aside.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                <h1 class="h2">PESAGEM <svg class="bi bi-clipboard" width="1em" height="1em" viewBox="0 0 16 16"
                        fill="green" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                            d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z" />
                        <path fill-rule="evenodd"
                            d="M9.5 1h-3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z" />
                    </svg>
                </h1>
            </div>

            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="cadastro-peso.jsp" role="tab"
                        aria-controls="home">Adicionar</a>
            </ul>

            <h2>Inclusão de Peso</h2>
            <!-- Inserindo mensagem de sucesso ao cadastrar peso -->
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if>
            <c:if test="${not empty erro}">
                <div class="alert alert-danger">
                    ${erro}
                </div>
            </c:if>

            <div>
                <form action="peso" method="post">
                    <input type="hidden" value="cadastrar" name="acao">
                    <div class="form-row align-items-center">
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="peso">Novo Peso: </label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text"><svg class="bi bi-file-plus" width="1em" height="1em"
                                            viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M9 1H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V8h-1v5a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V3a1 1 0 0 1 1-1h5V1z" />
                                            <path fill-rule="evenodd"
                                                d="M13.5 1a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1H13V1.5a.5.5 0 0 1 .5-.5z" />
                                            <path fill-rule="evenodd"
                                                d="M13 3.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0v-2z" />
                                        </svg></div>
                                </div>
                                <input type="text" class="form-control" id="peso" name="peso"
                                    placeholder="Nova Pesagem">
                            </div>
                        </div>
                        <div class="col-sm-3 my-1">
                            <label class="sr-only" for="data-pesagem">Data Pesagem: </label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="data-pesagem" name="data-peso"
                                    placeholder="Data da Pesagem">
                            </div>
                        </div>
                        <div class="col-auto my-1">
                            <div class="col-auto my-1">
                                <button type="submit" class="btn btn-success">ADICIONAR</button>
                                <button type="reset" class="btn btn-danger">CANCELAR</button>
                            </div>
                        </div>
                    </div>
                </form>
                <hr/>
            </div>
        </main>
</body>


</html>