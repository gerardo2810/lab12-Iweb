<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.guerra.Beans.Personas" %>
<%@ page import="com.example.guerra.Beans.Profesiones" %>
<%@ page import="com.example.guerra.Beans.Generos" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean scope="request" id="listaGeneros" type="java.util.ArrayList<com.example.guerra.Beans.Generos>"/>
<jsp:useBean id="listaProfesiones" type="java.util.ArrayList<com.example.guerra.Beans.Profesiones>"
             scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <title>Nuevo empleado</title>
        <jsp:include page="../includes/headCss.jsp"></jsp:include>
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="emp"/>
            </jsp:include>
            <div class="row mb-4">
                <div class="col"></div>
                <div class="col-md-6">
                    <h1 class='mb-3'>Nueva persona</h1>
                    <hr>
                    <form method="POST" action="PersonasServlet">
                        <div class="mb-3">
                            <label class="form-label" for="nombre">Nombre</label>
                            <input type="text" class="form-control form-control-sm" id="nombre" name="nombre">
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="job_id">Job ID</label>
                            <select name="job_id" id="job_id" class="form-select">
                                <% for (Generos genero : listaGeneros) {%>
                                <option value="<%=genero.getGeneroId()%>"><%=genero.getGeneroNombre()%>
                                </option>
                                <% }%>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="profesion_id">Job ID</label>
                            <select name="profesion_id" id="profesion_id" class="form-select">
                                <% for (Profesiones profesion : listaProfesiones) {%>
                                <option value="<%=profesion.getProfesionid()%>"><%=profesion.getProfesionNombre()%>
                                </option>
                                <% }%>
                            </select>
                        </div>

                        <a href="<%= request.getContextPath()%>/PersonasServlet" class="btn btn-danger">Cancelar</a>
                        <input type="submit" value="Guardar" class="btn btn-primary"/>
                    </form>
                </div>
                <div class="col"></div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
