<%-- 
    Document   : index
    Created on : 20-nov-2020, 11:33:58
    Author     : Robot
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="mystyle.css" rel="stylesheet">
       <title>AlumnoPromedio</title>
    </head>
    <body>
        <h1 class="titulo">Ejercicio 001!</h1>
        

        <div class="crud">
            <a class="link" href="controlador?accion=listar">Listar</a>
            <a class="link" href="controlador?accion=agregar">Agregar Nuevo</a>
        </div>
        <table class="tabla" border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Nota1</th>
                    <th>Nota2</th>
                    <th>Promedio</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <c:forEach var="alumno" items="${Alumnos}">
            <tbody>
                <tr>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombre}</td>
                    <td>${alumno.apellido}</td>
                    <td>${alumno.nota1}</td>
                    <td>${alumno.nota2}</td>
                    <td>${alumno.promedio}</td>
                    <td>
                        <a class="link" href="controlador?accion=editar&id=${alumno.id}">Editar</a>
                        <a  class="link" href="controlador?accion=eliminar&id=${alumno.id}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
