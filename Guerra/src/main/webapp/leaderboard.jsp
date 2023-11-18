<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.webapphr2.Dto.EmpleadosPorDepartamentoDto" %>
<%@ page import="com.example.webapphr2.Dto.EmpleadosPorRegionDto" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="lista" type="java.util.ArrayList<com.example.webapphr2.Dto.EmpleadosPorDepartamentoDto>" scope="request"/>
<jsp:useBean id="listaEmpPorRegion" type="java.util.ArrayList<com.example.webapphr2.Dto.EmpleadosPorRegionDto>" scope="request" />
<!DOCTYPE html>
<html>
<head>
    <title>Lista empleados</title>
    <jsp:include page="./includes/headCss.jsp"></jsp:include>
</head>
<body>
<div class='container'>
    <jsp:include page="./includes/navbar.jsp">
        <jsp:param name="currentPage" value="emp"/>
    </jsp:include>
    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Leaderboard</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <table class="table">
                <thead>
                <tr>
                    <th>Ranking</th>
                    <th>Jugador</th>
                    <th>Días jugados en total</th>
                    <th>Población</th>
                    <th>Moral de la civilización</th>
                    <th>Guerras ganadas</th>
                    <th>% de victorias de guerras</th>
                    <th>Fuerza de civilizacion</th>
                    <th>Máximo número de días de un ciudadano</th>
                    <th>Producción de alimento</th>

                </tr>
                </thead>
                <tbody>
                <%
                    int i = 1;
                    for (EmpleadosPorDepartamentoDto e : lista) {
                %>
                <tr>
                    <td><%= i%>
                    </td>
                    <td><%= e.getDepartmentName()%>
                    </td>
                    <td><%= e.getCantidad()%>
                    </td>
                </tr>
                <% i++;  } %>
                </tbody>
            </table>
        </div>
    </div>


    <jsp:include page="./includes/footer.jsp"/>
</div>
</body>
</html>
