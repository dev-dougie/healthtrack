<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <header>
        <%@include file = "menu.jsp" %>
        <%@include file = "header.jsp" %>
    </header>

    <style>
        .corpo-planos {
            background-color: #222;

        }

        .display-4,
        .lead {
            color: white;
        }
    </style>


    <body class="corpo-planos">
        <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center"><br><br>
            <h1 class="display-4">Planos</h1>
            <p class="lead">Acesse onde estiver. Cancele quando quiser.</p>
        </div>

        <div class="container">
            <div class="card-deck mb-3 text-center">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Free</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">R$0<small class="text-muted"> / mes</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>I - Acompanhamento de IMC</li>
                            <li>II - Listagem de exercicios</li>
                            <li>III - Conexao com amigos</li><br><br>
                        </ul>
                        <a href="cadastro-usuario.jsp" class="btn btn-lg btn-block btn-primary" role="button"
                            aria-pressed="true">CADASTRE-SE</a>
                    </div>
                </div>
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Bike</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">R$9 <small class="text-muted">/ mes</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>I - Geo-localizacao</li>
                            <li>II - Tipos de terreno</li>
                            <li>III - Bicicletarias proximas</li>
                            <li>IV - Desconto em alugueis de bicicletas</li>
                        </ul>
                        <a href="#" class="btn btn-lg btn-block btn-primary" role="button"
                            aria-pressed="true">ASSINE</a>
                    </div>
                </div>
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Running</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">R$7 <small class="text-muted">/ mes</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>I - Encontro de corredores</li>
                            <li>II - Premios ao alcançar metas</li>
                            <li>III - Free Pass em maratonas regionais</li>
                            <li>IV - Cardio Features</li>
                        </ul>
                        <a href="#" class="btn btn-lg btn-block btn-primary" role="button"
                            aria-pressed="true">ASSINE</a>
                    </div>
                </div>
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Skate board</h4>
                    </div>
                    <div class="card-body">
                        <h1 class="card-title pricing-card-title">R$5 <small class="text-muted">/ mes</small></h1>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li>I - Localizacao de pistas</li>
                            <li>II - Dicas para manobras</li>
                            <li>III - Consulta dos melhores tipos de shapes</li>
                            <li>IV - Vans partner</li>
                        </ul>
                        <a href="#" class="btn btn-lg btn-block btn-primary" role="button"
                            aria-pressed="true">ASSINE</a>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="card-deck mb-3 text-center">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Surf</h4>
                        </div>
                        <div class="card-body">
                            <h1 class="card-title pricing-card-title">R$6<small class="text-muted"> / mes</small></h1>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li>I - Resumo de praias com melhores ondas</li>
                                <li>II - Desconto em diarias de hoteis litoraneos</li>
                                <li>III - Consulta de melhores tipos de prancha</li>
                                <li>IV - Concorra a um ingresso gratuito para o WSL Qualifying Series</li>
                            </ul>
                            <a href="assinatura.html" class="btn btn-lg btn-block btn-primary" role="button"
                                aria-pressed="true">ASSINE</a>
                        </div>
                    </div>
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Triatlhon</h4>
                        </div>
                        <div class="card-body">
                            <h1 class="card-title pricing-card-title">R$12<small class="text-muted"> / mes</small></h1>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li>I - Recurso de medicao para resistencia pulmonar</li>
                                <li>II - Acompanhamento de Personal Trainner</li>
                                <li>III - Cardio Features</li><br><br>
                            </ul>
                            <a href="#" class="btn btn-lg btn-block btn-primary" role="button"
                                aria-pressed="true">ASSINE</a>
                        </div>
                    </div>
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Premium Experience</h4>
                        </div>
                        <div class="card-body">
                            <h1 class="card-title pricing-card-title">R$18 <small class="text-muted">/mes</small></h1>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li>I - Todos os beneficios do Health Track</li>
                                <li>II - Acompanhamento de nutricionista</li>
                                <li>III - Promocoes na compra de itens esportivos em lojas parceiras</li>
                                <li>IV - Acesso a internet gratuita em parques/pracas</li>
                            </ul>
                            <a href="#" class="btn btn-lg btn-block btn-primary" role="button"
                                aria-pressed="true">ASSINE</a>
                        </div>
                    </div>
                </div>
    </body>

</html>