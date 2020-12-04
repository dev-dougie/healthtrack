<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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

            <h2>Atualização de Pressão</h2>

            <form method="POST" action="pressao">
                <input type="hidden" value="editar" name="acao">
                <input type="hidden" value="${pressao.idPressao}" name="codigo">
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="data-afericao">Data de Aferição</label>
                        <input type="text" class="form-control" name="data-afericao" id="data-afericao" placeholder = "Data de aferição">
                    </div>

                    <div class="form-group col-md-2">
                        <label for="pres-sistolica">Pressão sistólica</label>
                        <input type="text" class="form-control" name="pres-sistolica" id="pres-sistolica"
                            value="${pressao.sistolica}">
                    </div>

                    <div class="form-group col-md-2">
                        <label for="pres-diastolica">Pressão diastólica</label>
                        <input type="number" class="form-control" name="pres-diastolica" id="pres-diastolica"
                            value="${pressao.diastolica}">
                    </div>
                </div>
                <div class="form-group">
                </div>
                <button type="submit" class="btn btn-success">ATUALIZAR</button>
                <a href="pressao?acao=listar" class="btn btn-danger">CANCELAR</a>
            </form>
            <hr/>
        </main>
    </div>
</body>

</html>