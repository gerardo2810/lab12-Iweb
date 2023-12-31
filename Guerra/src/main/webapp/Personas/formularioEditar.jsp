<%@page import="java.util.ArrayList" %>
<%@page import="com.example.guerra.Beans.Personas" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="persona" type="Personas" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Nombre</title>
        <jsp:include page="../includes/headCss.jsp"></jsp:include>
    </head>
    <body>
        <div class='container'>
            <jsp:include page="../includes/navbar.jsp">
                <jsp:param name="currentPage" value="emp"/>
            </jsp:include>
            <div class="row mb-4">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1 class='mb-3'>Editar nombre de persona</h1>
                    <hr>
                    <form method="POST" action="EmployeeServlet">
                        <input type="hidden" name="employee_id" value="<%= persona.getIdPersonas()%>"/>
                        <div class="mb-3">
                            <label class="form-label" for="first_name">First Name</label>
                            <input type="text" class="form-control form-control-sm" id="first_name" name="first_name"
                                   value="<%= persona.getNombre() == null ? "" : persona.getNombre()%>">
                        </div>

                        <a href="<%= request.getContextPath()%>/PersonasServlet" class="btn btn-danger">Cancelar</a>
                        <input type="submit" value="Guardar" class="btn btn-primary"/>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
