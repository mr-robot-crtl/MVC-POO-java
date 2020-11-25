/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Modelo.Alumno;
import java.util.List;

/**
 *
 * @author Robot
 */
public interface Interface {
    public List<Alumno>getAlumnos();
    public Alumno getId(int id);
    public int add(Alumno a);
    public int update(Alumno a);
    public int delete(int id);

}
