<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@include file = "header.jsp" %>
    <title>Cadastro</title>
    <%@include file = "header.jsp" %>
</head>
<%@include file = "menu.jsp" %><br><br><br>
<body>
    <div id="main" class="container-fluid">
        <h3 class="page-header">Dados do usuário<svg class="bi bi-person-fill" width="1em" height="1em"
                viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                    d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
            </svg></h3>
            
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
        <form class="needs-validation" method = "POST" action = "cadastro-usuario">
            <hr />
            <div class="row">
                <div class="form-group col-md-4">
                    <label for="name">
                        Nome completo</label>
                    <input type="text" class="form-control" name="name" id="name" required>
                </div>


                <div class="form-group col-md-4">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" name="cpf" id="cpf"  maxlength = "14" required>
                </div>

                <div class="form-group col-md-3">
                    <label for="username"><svg class="bi bi-at" width="1em" height="1em" viewBox="0 0 16 16" fill="blue"
                            xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M13.106 7.222c0-2.967-2.249-5.032-5.482-5.032-3.35 0-5.646 2.318-5.646 5.702 0 3.493 2.235 5.708 5.762 5.708.862 0 1.689-.123 2.304-.335v-.862c-.43.199-1.354.328-2.29.328-2.926 0-4.813-1.88-4.813-4.798 0-2.844 1.921-4.881 4.594-4.881 2.735 0 4.608 1.688 4.608 4.156 0 1.682-.554 2.769-1.416 2.769-.492 0-.772-.28-.772-.76V5.206H8.923v.834h-.11c-.266-.595-.881-.964-1.6-.964-1.4 0-2.378 1.162-2.378 2.823 0 1.737.957 2.906 2.379 2.906.8 0 1.415-.39 1.709-1.087h.11c.081.67.703 1.148 1.503 1.148 1.572 0 2.57-1.415 2.57-3.643zm-7.177.704c0-1.197.54-1.907 1.456-1.907.93 0 1.524.738 1.524 1.907S8.308 9.84 7.371 9.84c-.895 0-1.442-.725-1.442-1.914z" />
                        </svg>Username</label>

                    <input type="text" class="form-control" name="nickname" id="nickname" placeholder="@userht"
                        required>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-5">
                    <label for="email">Email <svg class="bi bi-envelope-fill" width="1em" height="1em"
                            viewBox="0 0 16 16" fill="purple" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M.05 3.555A2 2 0 0 1 2 2h12a2 2 0 0 1 1.95 1.555L8 8.414.05 3.555zM0 4.697v7.104l5.803-3.558L0 4.697zM6.761 8.83l-6.57 4.027A2 2 0 0 0 2 14h12a2 2 0 0 0 1.808-1.144l-6.57-4.027L8 9.586l-1.239-.757zm3.436-.586L16 11.801V4.697l-5.803 3.546z" />
                        </svg></label>
                    <input type="email" class="form-control" name="email" id="email"
                        placeholder="Digite seu melhor email" required>
                </div>

                <div class="form-group col-md-3">
                    <label for="password">Senha <svg class="bi bi-lock-fill" width="1em" height="1em"
                            viewBox="0 0 16 16" fill="gold" xmlns="http://www.w3.org/2000/svg">
                            <rect width="11" height="9" x="2.5" y="7" rx="2" />
                            <path fill-rule="evenodd" d="M4.5 4a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z" />
                        </svg></label>
                    <input type="password" class="form-control" name="password" id="senha"
                        placeholder="Mínimo: 6 caracteres" required>
                </div>
                <div class="form-group col-md-3">
                    <label for="conf-password">Confirmar Senha <svg class="bi bi-shield-lock-fill" width="1em"
                            height="1em" viewBox="0 0 16 16" fill="gold" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M5.187 1.025C6.23.749 7.337.5 8 .5c.662 0 1.77.249 2.813.525a61.09 61.09 0 0 1 2.772.815c.528.168.926.623 1.003 1.184.573 4.197-.756 7.307-2.367 9.365a11.191 11.191 0 0 1-2.418 2.3 6.942 6.942 0 0 1-1.007.586c-.27.124-.558.225-.796.225s-.526-.101-.796-.225a6.908 6.908 0 0 1-1.007-.586 11.192 11.192 0 0 1-2.417-2.3C2.167 10.331.839 7.221 1.412 3.024A1.454 1.454 0 0 1 2.415 1.84a61.11 61.11 0 0 1 2.772-.815zm3.328 6.884a1.5 1.5 0 1 0-1.06-.011.5.5 0 0 0-.044.136l-.333 2a.5.5 0 0 0 .493.582h.835a.5.5 0 0 0 .493-.585l-.347-2a.5.5 0 0 0-.037-.122z" />
                        </svg></label>
                    <input type="password" class="form-control" name="conf-password" id="confsenha" required>
                </div>
                <div class="form-group col-md-3">
                    <label for="telefone">Telefone <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-telephone-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  					<path fill-rule="evenodd" d="M2.267.98a1.636 1.636 0 0 1 2.448.152l1.681 2.162c.309.396.418.913.296 1.4l-.513 2.053a.636.636 0 0 0 .167.604L8.65 9.654a.636.636 0 0 0 .604.167l2.052-.513a1.636 1.636 0 0 1 1.401.296l2.162 1.681c.777.604.849 1.753.153 2.448l-.97.97c-.693.693-1.73.998-2.697.658a17.47 17.47 0 0 1-6.571-4.144A17.47 17.47 0 0 1 .639 4.646c-.34-.967-.035-2.004.658-2.698l.97-.969z"/>
					</svg></label>

                    <input type="text" class="form-control" name="telefone" id="telefone" placeholder="Digite apenas números"
                        required>
                </div>
                <div class="form-group col-md-6">
                    <label for="address">Endereço <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
  <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
</svg></label>

                    <input type="text" class="form-control" name="address" id=""address"" placeholder="Ex: Rua das Flores, 123 - Jardim Paulistano - SP"
                        required>
                </div>
            </div>
            <hr />

            <h3 class="page-main">Informações adicionais <svg class="bi bi-file-text" width="1em" height="1em"
                    viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd"
                        d="M4 1h8a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1H4z" />
                    <path fill-rule="evenodd"
                        d="M4.5 10.5A.5.5 0 0 1 5 10h3a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zm0-2A.5.5 0 0 1 5 8h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zm0-2A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5zm0-2A.5.5 0 0 1 5 4h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z" />
                </svg></h3>
            <div class="row">
                <div class="form-group col-md-2">
                    <label for="weight">Peso <svg class="bi bi-layers" width="1em" height="1em" viewBox="0 0 16 16"
                            fill="brown" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                d="M3.188 8L.264 9.559a.5.5 0 0 0 0 .882l7.5 4a.5.5 0 0 0 .47 0l7.5-4a.5.5 0 0 0 0-.882L12.813 8l-1.063.567L14.438 10 8 13.433 1.562 10 4.25 8.567 3.187 8z" />
                            <path fill-rule="evenodd"
                                d="M7.765 1.559a.5.5 0 0 1 .47 0l7.5 4a.5.5 0 0 1 0 .882l-7.5 4a.5.5 0 0 1-.47 0l-7.5-4a.5.5 0 0 1 0-.882l7.5-4zM1.563 6L8 9.433 14.438 6 8 2.567 1.562 6z" />
                        </svg></label>
                    <input type="decimal" class="form-control" name="weight" id="peso" placeholder="Ex: 60.5" required>
                </div>

                <div class="form-group col-md-2">
                    <label for="height">Altura</label>
                    <input type="decimal" class="form-control" name="height" id="height" placeholder="Ex: 1.80"
                        required>
                </div>
                <div class="form-group col-md-2">
                    <label for="data-nascimento">Data de Nascimento</label>
                    <input type="text" class="form-control" name="data-nascimento" id="data-nascimento" placeholder="" required>
                </div>
                <div class="form-group col-md-2">
                    <label for="exampleFormControlSelect1">Sexo</label>
                    <select class="form-control" name="gender" id="gender" required>
                        <option value="M">Masculino</option>
                        <option value="F">Feminino</option>
                    </select>
                </div>
            </div>
            <hr />

            <div id="actions" class="row">
                <div class="form-group col-md-2">
                	<button type="submit" class="btn btn-success">Salvar</button>
                    <a href="index.jsp" class="btn btn-danger">Cancelar</a> 
                </div>
            </div>
            </form>
    </div>
    <hr />
    <a href="https://pt-br.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110"
        class="btn btn-default" type="submit"><img src="resources/Imagens/facebook.png" widht="20" height="20"></a>
    <a href="https://accounts.google.com/signin/v2/identifier?service=g4np&passive=1209600&continue=https%3A%2F%2Fwww.google.com%2Fnonprofits%2Faccount%2Fhome%3Fhl%3Dpt-BR&followup=https%3A%2F%2Fwww.google.com%2Fnonprofits%2Faccount%2Fhome%3Fhl%3Dpt-BR&hl=pt-BR&flowName=GlifWebSignIn&flowEntry=ServiceLogin"
        class="btn btn-default" type="submit"><img src="resources/Imagens/google.png" widht="20" height="20"></a>
    </form>

</body>

</html>