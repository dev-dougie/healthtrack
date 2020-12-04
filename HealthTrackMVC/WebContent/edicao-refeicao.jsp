<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <%@include file = "header.jsp" %>
    <link href="resources/css/dashboard.css" rel="stylesheet">
    <title>Refeições</title>
</head>

<body>
    <div class="container-fluid">
        <%@include file = "searchbar.jsp"%>
        <%@include file = "aside.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
            <div>
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 ">
                    <h1 class="h2">REFEIÇÕES <svg width="1em" height="1.0625em" viewBox="0 0 16 17" class="bi bi-cup-straw"
                                    fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                        d="M13.964 1.18a.5.5 0 0 1-.278.65l-2.255.902-.462 2.08c.375.096.714.216.971.368.228.135.56.396.56.82 0 .046-.004.09-.011.132l-.955 9.068a1.28 1.28 0 0 1-.524.93c-.488.34-1.494.87-3.01.87-1.516 0-2.522-.53-3.01-.87a1.28 1.28 0 0 1-.524-.93L3.51 6.132A.78.78 0 0 1 3.5 6c0-.424.332-.685.56-.82.262-.154.607-.276.99-.372C5.824 4.614 6.867 4.5 8 4.5c.712 0 1.389.045 1.985.127l.527-2.37a.5.5 0 0 1 .302-.355l2.5-1a.5.5 0 0 1 .65.279zM9.768 5.608A13.991 13.991 0 0 0 8 5.5c-1.076 0-2.033.11-2.707.278A3.284 3.284 0 0 0 4.645 6c.146.073.362.15.648.222C5.967 6.39 6.924 6.5 8 6.5c.571 0 1.109-.03 1.588-.085l.18-.808zm.292 1.756a5.513 5.513 0 0 0 1.325-.297l-.845 8.03c-.013.12-.06.185-.102.214-.357.249-1.167.69-2.438.69-1.27 0-2.08-.441-2.438-.69-.041-.029-.09-.094-.102-.214l-.845-8.03c.137.046.283.088.435.126.774.194 1.817.308 2.95.308.742 0 1.445-.049 2.06-.137zm-5.593-1.48s.003.002.005.006l-.005-.006zm7.066 0l-.005.006a.026.026 0 0 1 .005-.006zM11.354 6a3.282 3.282 0 0 1-.703.235l.1-.446c.264.069.464.142.603.211z" />
                         </svg>
                    </h1>
                </div>
                <h2>Edicão de Refeição</h2>
                <c:if test="${not empty msg}">
                    <div class="alert alert-success">
                        ${msg}
                    </div>
                </c:if>
                <c:if test="${not empty erro}">
                    <div class="alert alert-danger">
                        ${erro}
                    </div>
                </c:if>
                <form method="POST" action="refeicao">
                    <input type="hidden" value="editar" name="acao">
                    <input type="hidden" value="${refeicao.id_refeicao}" name="codigo">
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <label for="meal-date">Data de Ingestão</label>
                            <input type="text" class="form-control" name="meal-date" id="meal-date">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="meal-description">Descrição</label>
                            <input type="text" class="form-control" name="meal-description" id="description"
                                maxlength="25" value = "${refeicao.descricao}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="food">Alimento Ingerido (Cadastro em 'Alimento' necessário)</label>
                            <select id="food" name="food" class="form-control">
                                <option value="0">Selecione</option>
                                <c:forEach items="${alimentos}" var="a">
                                    <option value="${a.idAlimento}">${a.nome}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                    </div>
                    <button type="submit" class="btn btn-success">ATUALIZAR</button>
                    <a href = "refeicao?acao=listar" class="btn btn-danger">CANCELAR</a>
                </form>
                <hr/>
            </div>
        </main>
    </div>
</body>

</html>