/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class MatriculaData {
    private Connection connection = null;

    public MatriculaData (Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void registrarMatricula (Matricula matricula){
        try {
        String sql = "INSERT INTO matricula (fecha , costo) VALUES ( ? , ? );";
        
            try (PreparedStatement statement = connection.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS)) {
             statement.setDate(1 , Date.valueOf(matricula.getFecha()));
             statement.setDouble (2 , matricula.getCosto());
               
                statement.executeUpdate();
                
                ResultSet resultset = statement.getGeneratedKeys();
                
                if (resultset.next()) {
                    matricula.setId_matricula(resultset.getInt(1));
                } else {
                    System.out.println("No se puede registrar la matricula");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarMatricula(int id_matricula){
    try {
            
            String sql = "DELETE FROM matricula WHERE id_matricula =? ;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_matricula);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar matricula: " + ex.getMessage());
        }
        
    
    
    }
    public List<Matricula> obtenerMatricula(){
        List<Matricula> matriculas = new ArrayList<Matricula>();

        try {
            String sql = "SELECT  * FROM matricula;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Matricula matricula;
            while(resultSet.next()){
                matricula = new Matricula();
                matricula.setId_matricula(resultSet.getInt("id"));
                matricula.setFecha(resultSet.getDate("fecha").toLocalDate());
                matricula.setCosto(resultSet.getDouble("costo"));

                matriculas.add(matricula);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las matriculas: " + ex.getMessage());
        }
        
        
        return matriculas;
    }
    public void actualizarMatricula(Matricula matricula){
    
        try {
            
            String sql = "UPDATE matricula SET fecha = ?, costo = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            statement.setDate(1 , Date.valueOf(matricula.getFecha()));
            statement.setDouble(2, matricula.getCosto());
            statement.setInt(3, matricula.getId_matricula());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar matricula: " + ex.getMessage());
        }
    
    }
}


