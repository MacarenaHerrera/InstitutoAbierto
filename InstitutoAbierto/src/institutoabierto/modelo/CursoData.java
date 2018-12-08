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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Maqui's
 */
public class CursoData {
   private Connection connection = null;

    public CursoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(CursoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void altaCurso (Curso curso){
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
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
    public DefaultTableModel obtenerCurso() {
      
           DefaultTableModel listaCursos;
           String[] titulos = {"id_curso", "nombreCurso", "descripcion", "costo", "cupoMax"};
           String [] datos = new String [5];
           
           listaCursos = new DefaultTableModel  (null, titulos);
            try {
           String sql = "SELECT * FROM curso;";
           
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();
           while(resultSet.next()){
               datos [0] = resultSet.getString("id_curso");
               datos [1] = resultSet.getString("nombreCurso");
               datos [2] = resultSet.getString("descripcion");
               datos [3] = resultSet.getString("costo");
               datos [4] = resultSet.getString("cupoMax");
               listaCursos.addRow(datos);
           }
               statement.close();  
           } catch (SQLException ex) {
                   System.out.println("Error al obtener los cursos: " + ex.getMessage());
                   }
           
           
           return listaCursos;
           
              }
    
    public void actualizarCurso(Curso curso){
    
        try {
            
            String sql = "UPDATE curso SET nombreCurso = ?, descripcion = ? , costo =?,  cupoMax =?  WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, curso.getNombreCurso());
                statement.setString(2, curso.getDescripcion());
                statement.setDouble(3, curso.getCosto());
               statement.setInt(4, curso.getCupoMax());
               statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar un curso: " + ex.getMessage());
        }
    
    } 
    public Curso buscarCurso(int id_curso){
    Curso curso =null;
    try {
            
            String sql = "SELECT * FROM curso WHERE id_curso =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_curso);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                curso = new Curso();
                curso.setId_curso(resultSet.getInt("id_curso"));
                curso.setNombreCurso(resultSet.getString("nombrePersona"));
                curso.setDescripcion(resultSet.getString("descripcion"));
                curso.setCosto(resultSet.getDouble("costo"));
                curso.setCupoMax(resultSet.getInt("cupoMax"));
                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar un alumno: " + ex.getMessage());
        }
        
        return curso;
    }
}