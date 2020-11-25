/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Modelo.Alumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robot
 */
public class AlumnoDAO implements Interface{

    @Override
    public List<Alumno> getAlumnos(){
        List<Alumno>alumnos=new ArrayList<>();/*Listado*/
        String sql="select * from alumno";/*Sentencia SQL*/
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);/*Preparando para que se ejecute el sql*/
            ResultSet rs=ps.executeQuery();/*Para ejecutar la busqueda que queremos*/
            while(rs.next()){/*Mientras hay algo mas que usar, va guardar en la variable alumno de manera local */
            Alumno a = new Alumno();/*Objeto Instancia*/
            /*Optener cada uno de los datos con 'set'*/
            a.setId(rs.getInt(1)); /*Buscar el elemento de la columna '1'*/
            a.setNombre(rs.getString(2)); /*Buscar el elemento de la columna '2'*/
            a.setApellido(rs.getString(3)); /*Buscar el elemento de la columna '3'*/
            a.setNota1(rs.getInt(4)); /*Buscar el elemento de la columna '4'*/
            a.setNota2(rs.getInt(5));
            a.setPromedio(rs.getFloat(6));
            alumnos.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error: "+ e);/*Mostrar algun tipo de error*/
            
        }return alumnos;/*Retotna alumnos*/
    }

    @Override
    public Alumno getId(int id) {
        String sql="SELECT * FROM alumno WHERE idAlumno=?";
        Alumno alumno = new Alumno();
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setInt(1, id);/*Guardamos en la posicion 1 y va obtener de la id que pondremos en la funcion*/
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            alumno.setId(rs.getInt(1));
            alumno.setNombre(rs.getString(2)); /*Buscar el elemento de la columna '2'*/
            alumno.setApellido(rs.getString(3)); /*Buscar el elemento de la columna '3'*/
            alumno.setNota1(rs.getInt(4)); 
            alumno.setNota2(rs.getInt(5));        
            alumno.setPromedio(rs.getFloat(6)); 
            }
        } catch (Exception e) {
            System.err.println("Error: "+ e);
        }
        return alumno;
    }
    @Override
    public int add(Alumno a) {
        int resultado=0;
        String sql="INSERT INTO alumno(Nombre,Apellido,Nota1,Nota2,Promedio)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getNota1());
            ps.setInt(4, a.getNota2());
            ps.setFloat(5, a.getPromedio());
            
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error para agregar a la BD: "+ e);
        }return resultado;
    }
    @Override
    public int update(Alumno a ) {
        int resultado=0;
        String sql="UPDATE alumno SET Nombre=?,Apellido=?,Nota1=? ,Nota2=? ,Promedio=? WHERE idAlumno=?";
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getNota1());
            ps.setInt(4, a.getNota2());
            ps.setFloat(5, a.getPromedio());
            ps.setInt(6, a.getId());
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error para actulizar a la BD: "+ e);
        }return resultado;
    }
    @Override
    public int delete(int id) {
        int resultado=0;
        String sql="DELETE FROM alumno WHERE idAlumno="+id;
        try {
            PreparedStatement ps=Conexion.Conectar().prepareStatement(sql);
            resultado=ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error para eliminar a la BD: "+ e);
        }return resultado; 
    }      
}
