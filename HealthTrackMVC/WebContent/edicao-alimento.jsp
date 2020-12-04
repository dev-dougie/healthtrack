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
    <title>Edição de Alimento</title>
</head>

<body>
    <div class="container-fluid">
        <%@include file = "searchbar.jsp" %>
        <%@include file = "aside.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                <h1 class="h2">ALIMENTO  <svg class="bi bi-egg-fried" width="1em" height="1em" viewBox="0 0 16 16" fill="orange"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M13.665 6.113a1 1 0 0 1-.667-.977L13 5a4 4 0 0 0-6.483-3.136 1 1 0 0 1-.8.2 4 4 0 0 0-3.693 6.61 1 1 0 0 1 .2 1 4 4 0 0 0 6.67 4.087 1 1 0 0 1 1.262-.152 2.5 2.5 0 0 0 3.715-2.905 1 1 0 0 1 .341-1.113 2.001 2.001 0 0 0-.547-3.478zM14 5c0 .057 0 .113-.003.17a3.001 3.001 0 0 1 .822 5.216 3.5 3.5 0 0 1-5.201 4.065 5 5 0 0 1-8.336-5.109A5 5 0 0 1 5.896 1.08 5 5 0 0 1 14 5z" />
                                    <circle cx="8" cy="8" r="3" />
                                </svg>
                </h1>
            </div>


            <h2>Edição de Alimento</h2>
            <div>
                <form action="alimento" method="post">
                    <input type="hidden" value="editar" name="acao">
                    <input type="hidden" value="${alimento.idAlimento}" name="codigo">
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" name="nome" id="nome" value="${alimento.nome}">
                        </div>
                        <div class="form-group col-md-2">
                            <label for="calorias">Calorias</label>
                            <input type="number" class="form-control" name="calorias" id="calorias"
                                value="${alimento.kcal}">
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="infos-nutricionais">Informações Nutricionais</label>
                            <textarea class="form-control" name="infos-nutricionais" id="infos-nutricionais"
                                maxlength="45" value="${alimento.info_nutricionais}"></textarea>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="descricao">Descrição</label>
                            <textarea class="form-control" name="descricao" id="descricao" maxlength="20"
                                value="${alimento.descricao}"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                    </div>
                    <button type="submit" class="btn btn-success">ATUALIZAR</button>
                    <a href="alimento?acao=listar" class="btn btn-danger">CANCELAR</a>
                </form>
                <hr/>
            </div>
        </main>
    </div>
</body>
</html>