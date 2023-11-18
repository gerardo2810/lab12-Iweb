<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/x-icon" href="assets/logo_guerra.svg" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registro</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
    />
</head>
<body class="bg-info d-flex justify-content-center align-items-center vh-100">
<div
        class="bg-white p-3 rounded-5 text-secondary shadow"
        style="width: 25rem"
>
    <div class="d-flex justify-content-center">
        <img
                src="assets/guerra.svg"
                alt="login-icon"
                style="height: 7rem"
        />
    </div>
    <div class="text-center fs-1 fw-bold">Era de Civilizaciones</div>
    <div class="fs-6 fw-bold">Por favor registrate como nuevo jugador</div>
    <div class="mt-3">Coloca tu nombre:</div>
    <div class="input-group mt-1">
        <input class="form-control bg-light" type="text" placeholder="Nombre"/>
    </div>
    <div class="mt-2">Coloca tu edad:</div>
    <div class="input-group mt-1">
        <input class="form-control bg-light" type="number" placeholder="Edad"/>
    </div>
    <div class="mt-2">Coloca tu correo:</div>
    <div class="input-group mt-1">
        <input class="form-control bg-light" type="email" placeholder="Correo"/>
    </div>
    <div class="mt-2">Coloca tu Usuario:</div>
    <div class="input-group mt-1">
            <input class="form-control bg-light" type="text" placeholder="Usuario"/>
    </div>
    <div class="mt-2">Coloca tu Contraseña:</div>
    <div class="input-group mt-1">
        <input class="form-control bg-light" type="password" placeholder="Contraseña"/>
    </div>
    <div class="btn btn-info text-white w-50 mt-2 fw-semibold shadow-sm position-relative">
        Regístrate
    </div>
    <a href="<%=request.getContextPath()%>/LoginServlet?action=iniciosesion" class="ml-5 text-decoration-none text-info fw-semibold"> Volver</a>
</div>
</body>
</html>