<%-- 
    Document   : Agregar
    Created on : 20-nov-2020, 22:25:56
    Author     : Robot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="mystyle.css" rel="stylesheet">
        <title>Agregar</title>
    </head>
    <body>
        <form action="controlador" method="POST">
            <div class="header">
                <header>Agregar Alumno</header>
            </div>
            <table class="tabla" border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Nota1</th>
                        <th>Nota2</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="txtNombre"/></td>
                    <td><input type="text" name="txtApellido"/></td>
                    <td><input type="text" name="txtNota1"/></td>
                    <td><input type="text" name="txtNota2"/></td>
                    <td>
                        <input class="boton" type="submit" value="Nuevo" name="accion" />
                        <a class="link" href="controlador?accion=listar">Volver</a>
                    </td>
                </tr>
            </tbody>
            </table>
        </form>
    </body>
</html>
