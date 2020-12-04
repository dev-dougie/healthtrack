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
    <title>Alimentos</title>
</head>

<body>
    <div class="container-fluid">
        <%@include file = "searchbar.jsp" %>
        <%@include file = "aside.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                <h1 class="h2">ALIMENTOS <svg class="bi bi-egg-fried" width="1em" height="1em" viewBox="0 0 16 16" fill="orange"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M13.665 6.113a1 1 0 0 1-.667-.977L13 5a4 4 0 0 0-6.483-3.136 1 1 0 0 1-.8.2 4 4 0 0 0-3.693 6.61 1 1 0 0 1 .2 1 4 4 0 0 0 6.67 4.087 1 1 0 0 1 1.262-.152 2.5 2.5 0 0 0 3.715-2.905 1 1 0 0 1 .341-1.113 2.001 2.001 0 0 0-.547-3.478zM14 5c0 .057 0 .113-.003.17a3.001 3.001 0 0 1 .822 5.216 3.5 3.5 0 0 1-5.201 4.065 5 5 0 0 1-8.336-5.109A5 5 0 0 1 5.896 1.08 5 5 0 0 1 14 5z" />
                                    <circle cx="8" cy="8" r="3" />
                                </svg>
                </h1>
            </div>

            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="alimento?acao=listar" role="tab"
                        aria-controls="profile">Lista</a>
                </li>
            </ul>

            <h2>Lista de Alimentos</h2>
            <c:if test="${not empty msg }">
                <div class="alert alert-success">${msg}</div>
            </c:if>
            <c:if test="${not empty erro }">
                <div class="alert alert-danger">${erro}</div>
            </c:if>
            <table class="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Nome do Alimento</th>
                        <th>Qtd. Calórica</th>
                        <th>Informações Nutricionais</th>
                        <th>Descrição</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${alimentos}" var="a">
                        <tr>
                            <td>${a.nome}</td>
                            <td>${a.kcal } <small>kcal</small></td>
                            <td>${a.info_nutricionais}</td>
                            <td>${a.descricao }</td>
                            <td>
                                <c:url value="alimento" var="link">
                                    <c:param name="acao" value="abrir-form-edicao" />
                                    <c:param name="codigo" value="${a.idAlimento}" />
                                </c:url>
                                <a href="${link}" class = "btn">
                                	<svg class="bi bi-pencil" width="1em"
                                    height="1em" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M11.293 1.293a1 1 0 0 1 1.414 0l2 2a1 1 0 0 1 0 1.414l-9 9a1 1 0 0 1-.39.242l-3 1a1 1 0 0 1-1.266-1.265l1-3a1 1 0 0 1 .242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z" />
                                    <path fill-rule="evenodd"
                                        d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 0 0 .5.5H4v.5a.5.5 0 0 0 .5.5H5v.5a.5.5 0 0 0 .5.5H6v-1.5a.5.5 0 0 0-.5-.5H5v-.5a.5.5 0 0 0-.5-.5H3z" />
                                	</svg>
                                </a>
                                <button type="button" class = "btn" data-toggle="modal"
                                    data-target="#excluirModal" onclick="codigoExcluir.value = ${a.idAlimento}">
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash"
                                        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path
                                            d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
                                        <path fill-rule="evenodd"
                                            d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
                                    </svg>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </main>


        <!-- Modal -->
        <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir o alimento?
                    </div>
                    <div class="modal-footer">
                        <form action="alimento" method="POST">
                            <input type="hidden" name="acao" value="excluir">
                            <input type="hidden" name="codigo" id="codigoExcluir">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-danger">Excluir</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</body>

</html>