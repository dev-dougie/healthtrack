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
    <title>Treinos Realizados</title>
</head>

<body>
    <div class="container-fluid">
        <%@include file = "searchbar.jsp" %>
        <%@include file = "aside.jsp"%>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                <h1 class="h2">TREINO <svg class="bi bi-emoji-sunglasses" width="1em" height="1em" viewBox="0 0 16 16"
                        fill="purple" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                            d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
                        <path fill-rule="evenodd"
                            d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM6.5 6.497V6.5h-1c0-.568.447-.947.862-1.154C6.807 5.123 7.387 5 8 5s1.193.123 1.638.346c.415.207.862.586.862 1.154h-1v-.003l-.003-.01a.213.213 0 0 0-.036-.053.86.86 0 0 0-.27-.194C8.91 6.1 8.49 6 8 6c-.491 0-.912.1-1.19.24a.86.86 0 0 0-.271.194.213.213 0 0 0-.036.054l-.003.01z" />
                        <path
                            d="M2.31 5.243A1 1 0 0 1 3.28 4H6a1 1 0 0 1 1 1v1a2 2 0 0 1-2 2h-.438a2 2 0 0 1-1.94-1.515L2.31 5.243zM9 5a1 1 0 0 1 1-1h2.72a1 1 0 0 1 .97 1.243l-.311 1.242A2 2 0 0 1 11.439 8H11a2 2 0 0 1-2-2V5z" />
                    </svg>
                </h1>
            </div>

            <h2>Edição de Treino</h2>

            <form method="POST" action="treino">
                <input type="hidden" value="editar" name="acao">
                <input type="hidden" value="${treino.idTreino}" name="codigo">
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="data-treino">Data de Realização</label>
                        <input type= "text" class="form-control" name="data-treino" id="data-treino" placeholder = "Data de realização">
                    </div>

                    <div class="form-group col-md-4">
                        <label for="tipo-exercicio">Tipo de Exercício</label>
                        <select id="tipo-exercicio" name="tipo-exercicio" class="form-control">
                            <option value="0">Selecione</option>
                            <c:forEach items="${exercicios}" var="e">
                                <option value="${e.id}">${e.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="duracao-treino">Duração (Min)</label>
                        <input type="text" class="form-control" name="duracao-treino" id="duracao-treino"
                            value="${treino.duracaoMin}">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="freq-cardiaca">Frequência Cardíaca</label>
                        <input type="text" class="form-control" name="freq-cardiaca" id="freq-cardiaca"
                            value="${treino.freqCardiaca}">
                    </div>
                    <div class="form-group col-md-2">
                        <label for="calorias-queimadas">Calorias Queimadas</label>
                        <input type="text" class="form-control" name="calorias-queimadas" id="calorias-queimadas"
                            value="${treino.kcalQueimadas}">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="descricao-treino">Descrição do treino</label>
                        <textarea class="form-control" name="observacao" id="observacao" maxlength="25"
                            value="${treino.descricao}"></textarea>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="obs-treino">Observações</label>
                        <textarea class="form-control" name="observacao" id="observacao" maxlength="100"
                            value="${treino.obs}"></textarea>
                    </div>
                </div>
                <div class="form-group">
                </div>
                <button type="submit" class="btn btn-success">ADICIONAR</button>
                <a href="treino?acao=listar" class="btn btn-danger">CANCELAR</a>
            </form>
            <hr/>
        </main>
    </div>
</body>

</html>