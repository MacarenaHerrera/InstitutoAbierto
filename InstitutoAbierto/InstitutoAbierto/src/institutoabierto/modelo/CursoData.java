/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Maqui's
 */
public class CursoData {
   private Connection connection = null;
private Conexion conexion;

    public CursoData(Conexion conexion) {
        try {
            this.conexion=conexion;
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CursoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
//Ingresa un curso
    public void resgitrarCurso (Curso curso){
        try {
        String sql = "INSERT INTO curso (nombreCurso, descripcion, costo, cupoMax , id_persona) VALUES ( ? , ? , ? , ? , ? );";
        
            try (PreparedStatement statement = connection.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, curso.getNombreCurso());
                statement.setString(2, curso.getDescripcion());
                statement.setDouble(3, curso.getCosto());
                statement.setInt(4, curso.getCupoMax());
                
               statement.setInt(5, curso.getPersona().getId_persona());
                
                statement.executeUpdate();
                
                ResultSet resultset = statement.getGeneratedKeys();
                
                if (resultset.next()) {
                    curso.setId_curso (resultset.getInt(1));
                } else {
                    System.out.println("No se puede obtener el id de curso");
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un curso: "+ ex.getMessage());
        }
    }
    //BORRA UN CURSO A PARTIR DE SU ID
    public void borrarCurso(int id_curso){
    try {
            
            String sql = "DELETE FROM curso WHERE id_curso =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_curso);
                       
            statement.executeUpdate();
                        
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar un curso: " + ex.getMessage());
        }
            
    }
    
    //OBTIENE UNA LISTA DE TODOS LOS CURSOS YA INRESADOS
    public List <Curso> listaCursos() {
        List <Curso> cursos = new ArrayList <Curso>();
        
        try {
           String sql = "SELECT * FROM curso;";
           
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();
           Curso curso;
           while(resultSet.next()){
               curso = new Curso();
              curso.setId_curso(resultSet.getInt("id_curso"));
              curso.setNombreCurso(resultSet.getString("nombreCurso"));
              curso.setDescripcion(resultSet.getString("descripcion"));
              curso.setCosto(resultSet.getDouble("costo"));
              curso.setCupoMax(resultSet.getInt("cupoMax"));  
              
              cursos.add(curso);
           }
      
            statement.close();  
           } catch (SQLException ex) {
                   System.out.println("Error al obtener los cursos: " + ex.getMessage());
                   }
    
            return cursos;
           
              }
    
    //ACTUALIZA UN CURSO
    public void actualizarCurso(Curso curso){
    
        try {
            
            String sql = "UPDATE curso SET nombreCurso = ?, descripcion = ? , costo = ?,  cupoMax = ?  WHERE id_curso = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
                statement.setString(1, curso.getNombreCurso());
                statement.setString(2, curso.getDescripcion());
                statement.setDouble(3, curso.getCosto());
               statement.setInt(4, curso.getCupoMax());
               //statement.setInt (5, curso.getPersona().getId_persona());
               statement.setInt(5, curso.getId_curso());
               
               statement.executeUpdate();
                      
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un curso: " + ex.getMessage());
        }
    
    } 
    //BUSCA UN CURSO A PARTIR DEL NOMBRE
    public Curso buscarCurso(String nombreCurso){
    Curso curso =null;
    try {
            
            String sql = "SELECT * FROM curso WHERE nombreCurso =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nombreCurso);
                       
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                curso = new Curso();
                curso.setId_curso(resultSet.getInt("id_curso"));
                curso.setNombreCurso(resultSet.getString("nombreCurso"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                curso.setCosto(resultSet.getDouble("costo"));
                curso.setCupoMax(resultSet.getInt("cupoMax"));
                
                Persona persona = buscarPersonaxId(resultSet.getInt("id_persona"));
                curso.setPersona (persona);
                
            }      
            statement.close();
         
         
        } catch (SQLException ex) {
            System.out.println("Error al buscar un curso: " + ex.getMessage());
        }
        
        return curso;
    }
    public Curso buscarCursoxId(int id_curso){
    Curso curso =null;
    try {
            
            String sql = "SELECT * FROM curso WHERE id_curso =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_curso);
                       
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                curso = new Curso();
                curso.setId_curso(resultSet.getInt("id_curso"));
                curso.setNombreCurso(resultSet.getString("nombreCurso"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                curso.setCosto(resultSet.getDouble("costo"));
                curso.setCupoMax(resultSet.getInt("cupoMax"));
                
                Persona persona = buscarPersonaxId(resultSet.getInt("id_persona"));
                curso.setPersona (persona);
                
            }      
            statement.close();
         
         
        } catch (SQLException ex) {
            System.out.println("Error al buscar un curso: " + ex.getMessage());
        }
        
        return curso;
    }
    public List <Curso> obtenerCostoxCurso(String nombreCurso){
        List <Curso> costoCurso = new ArrayList <Curso> ();

        try {
            String sql = "SELECT  costo FROM curso WHERE nombreCurso = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombreCurso);
            
            ResultSet resultSet = statement.executeQuery();
            
            Curso curso;
            
            while(resultSet.next()){
                curso = new Curso();
                curso.setNombreCurso(resultSet.getString("nombreCurso"));
                
                curso.setCosto(resultSet.getDouble("costo"));
                
                            
                costoCurso.add(curso);
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener los costos: " + ex.getMessage());
        }
       return costoCurso; 
    }  
    public Persona buscarPersonaxId(int id_persona){
        PersonaData personadata = new PersonaData(conexion);
        return personadata.buscarPersonaxId(id_persona);
    }
   /* public double costoCurso (Curso curso){
        return curso.getCosto();
    }
*/
}
