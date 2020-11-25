/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import ModeloDAO.AlumnoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Robot
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {
    AlumnoDAO dao;

   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion=request.getParameter("accion");
        List<Alumno>alumnos=new ArrayList<>();//iniciliazando la lista -instancia
        switch(accion){//ejecutamos el switch
            case "listar":
                dao = new AlumnoDAO();//para ejecutar el codigo de Persona DAO
                alumnos = dao.getAlumnos();//esto agregara todo los objetos de la BD
                request.setAttribute("Alumnos", alumnos);//preparamos para eviar al index
                request.getRequestDispatcher("index.jsp").forward(request, response);//movernos al index segun el teacher :v
                break;
                
            case "agregar":
                request.getRequestDispatcher("Agregar.jsp").forward(request, response);
                break;
                
            case "Nuevo":
                int r=0;
                String nombre=request.getParameter("txtNombre");
                String apellido=request.getParameter("txtApellido");
                int nota1=Integer.parseInt(request.getParameter("txtNota1"));
                int nota2=Integer.parseInt(request.getParameter("txtNota2")) ;
                float not1=nota1;//convirtiendo en float
                float not2=nota2;//convirtiendo en float
                float promedio=(not1+not2)/2;//operacion promedio
                Alumno a=new Alumno();
                a.setNombre(nombre);
                a.setApellido(apellido);
                a.setNota1(nota1);
                a.setNota2(nota2);
                a.setPromedio(promedio);//enviar promedio
                r=dao.add(a);
                if(r!=0){
                    request.setAttribute("Mensaje", "Se agrego con exito");
                    request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
                }else{
                    request.setAttribute("Mensaje", "Error al guradar con la BD");
                    request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
                }
            case "editar":
                int id=Integer.valueOf(request.getParameter("id"));
                Alumno alumno=dao.getId(id);
                request.setAttribute("alumno", alumno);
                request.getRequestDispatcher("Editar.jsp").forward(request, response);
                break;
            case "Actualizar":
                int new_r=0;
                String newnombre=request.getParameter("txtNombre");
                String newapellido=request.getParameter("txtApellido");
                int newnota1=Integer.parseInt(request.getParameter("txtNota1"));
                int newnota2=Integer.parseInt(request.getParameter("txtNota2"));
                int id1=Integer.valueOf(request.getParameter("txtId"));
                float nnot1=newnota1;//convirtiendo en float
                float nnot2=newnota2;
                float newpro=(nnot1+nnot2)/2;//operacion nuevo promedio
              
                Alumno alum=new Alumno();
                alum.setNombre(newnombre);
                alum.setApellido(newapellido);
                alum.setNota1(newnota1);
                alum.setNota2(newnota2);
                alum.setPromedio(newpro);//enviar nuevo promedio
                alum.setId(id1);              
                new_r=dao.update(alum);

                if(new_r!=0){
                    request.setAttribute("Mensaje", "Se actualizo con exito");
                    request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
                }else{
                    request.setAttribute("Mensaje", "Error al actualizar con la BD");
                    request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
                }     
            case "eliminar":
                int idalumno=Integer.valueOf(request.getParameter("id"));
                int res=dao.delete(idalumno);
                if(res!=0){
                    request.setAttribute("Mensaje", "Se elimino con exito");
                    request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
                }else{
                    request.setAttribute("Mensaje", "Error al eliminar en la BD");
                    request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
                }     
        }
         
    }
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
