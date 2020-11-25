<%-- 
    Document   : Editar
    Created on : 23-nov-2020, 16:15:30
    Author     : Robot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="mystyle.css" rel="stylesheet">
        <title>Editar</title>
    </head>
    <body>
        <form action="controlador" method="POST"><%--formulador--%>
            <div class="header">
                <header>Editar Alumno</header>
            </div>
            <table class="tabla" border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Nota1</th>
                    <th>Nota2</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="txtId" value="${alumno.id}" readonly="readonly"/></td>
                    <td><input type="text" name="txtNombre" value="${alumno.nombre}"/></td>
                    <td><input type="text" name="txtApellido" value="${alumno.apellido}"/></td>
                    <td><input type="text" name="txtNota1" value="${alumno.nota1}"/></td>
                    <td><input type="text" name="txtNota2" value="${alumno.nota2}"/></td>
                    <td>
                        <input class="boton" type="submit" value="Actualizar" name="accion" />
                        <a class="link" href="controlador?accion=listar">Volver</a>
                    </td>
                </tr>
            </tbody>
            </table>
        </form>
    </body>
</html>
