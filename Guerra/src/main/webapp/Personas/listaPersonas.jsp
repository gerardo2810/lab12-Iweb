<%@ page import="com.example.webapphr1_2023.Beans.Location" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean type="java.util.ArrayList<com.example.guerra.Beans.Personas>" scope="request" id="personasList"/>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../includes/bootstrap_header.jsp"/>
    <title>Listar Personas</title>
</head>
<body>
<div class='container'>

    <h1 class='mb-3'>Lista de Personas</h1>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="<%= request.getContextPath()%>">Home</a></li>
            <li class="breadcrumb-item active">Locations</li>
        </ol>
    </nav>
    <a class="btn btn-primary mb-3" href="<%=request.getContextPath()%>/PersonasServlet?action=formCrear">Crear
        Location</a>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>nombre</th>
            <th>genero</th>
            <th>Consumo alimento</th>
            <th>Moral</th>
            <th>Tiempo en la colonia</th>
            <th>Fuerza</th>
            <th>Produccion de alimento</th>

        </tr>
        <%
            for (Personas per : personasList) {
        %>
        <tr>
            <td><%=per.getIdPersonas()%>
            </td>
            <td><%=per.getNombre()%>
            </td>
            <td><%=per.getGenero()%>
            </td>
            <td><%=per.getConsumo()%>
            </td>
            <td><%= per.getMoral()%>
            </td>
            <td><%= per.getTiempoColonia()%>
            </td>
            <td><%= per.getProduce()%>

            <td>
                <a class="btn btn-primary"
                   href="<%=request.getContextPath()%>/PersonasServlet?action=editar&id=<%=per.getIdPersonas()%>">
                    <i class="bi bi-pencil-square"></i>
                </a>
            </td>
            <td>
                <a class="btn btn-danger"
                   href="<%=request.getContextPath()%>/PersonasServlet?action=borrar&id=<%=per.getIdPersonas()%>">
                    <i class="bi bi-trash3"></i>
                </a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<jsp:include page="../includes/bootstrap_footer.jsp"/>
</body>
</html>


