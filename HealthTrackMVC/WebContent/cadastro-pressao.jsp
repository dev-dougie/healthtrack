<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Pressão Arterial</title>
    <%@include file = "header.jsp" %>
    <link href="resources/css/dashboard.css" rel="stylesheet">
</head>

<body>
    <div id="main" class="container-fluid">
        <%@include file = "searchbar.jsp"%>
        <%@include file = "aside.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                <h1 class="h2">PRESSÃO ARTERIAL <svg class="bi bi-heart-fill" width="1em" height="1em"
                        viewBox="0 0 16 16" fill="red" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                            d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z" />
                    </svg>
                </h1>
            </div>

            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="cadastro-pressao.jsp" role="tab"
                        aria-controls="home">Adicionar</a>
                </li>
            </ul>

            <h2>Inclusão de Pressão</h2>
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
            <form method="POST" action="pressao">
                <input type="hidden" value="cadastrar" name="acao">
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="data-afericao">Data de Aferição</label>
                        <input type="text" class="form-control" name="data-afericao" id="data-afericao">
                    </div>

                    <div class="form-group col-md-2">
                        <label for="pres-sistolica">Pressão sistólica</label>
                        <input type="text" class="form-control" name="pres-sistolica" id="pres-sistolica">
                    </div>

                    <div class="form-group col-md-2">
                        <label for="pres-diastolica">Pressão diastólica</label>
                        <input type="number" class="form-control" name="pres-diastolica" id="pres-diastolica">
                    </div>
                </div>
                <div class="form-group">
                </div>
                <button type="submit" class="btn btn-success">ADICIONAR</button>
                <button type="reset" class="btn btn-danger">CANCELAR</button>
            </form>
            <hr/>
        </main>
    </div>
</body>

</html>