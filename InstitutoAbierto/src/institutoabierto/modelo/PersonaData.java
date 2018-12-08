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
public class PersonaData {
    private Connection connection = null;

    public PersonaData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inscribirPersona (Persona persona){
        try {
        String sql = "INSERT INTO persona (nombrePersona, dni, celular) VALUES ( ? , ? , ? );";
        
            try (PreparedStatement statement = connection.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, persona.getNombrePersona());
                statement.setInt(2, persona.getDni());
                statement.setInt(3, persona.getCelular());
                
                statement.executeUpdate();
                
                ResultSet resultset = statement.getGeneratedKeys();
                
                if (resultset.next()) {
                    persona.setId_persona(resultset.getInt(1));
                } else {
                    System.out.println("No se puede obtener el id de persona");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarPersona(int id_persona){
    try {
            
            String sql = "DELETE FROM persona WHERE id_persona =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_persona);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un persona: " + ex.getMessage());
        }
        
    
    }
    public DefaultTableModel obtenerPersona(){
        DefaultTableModel listaPersonas;
        
        String[] titulosP = {"id_persona", "nombre", "dni", "celular"};
        String[] datosP = new String [4];
        
        listaPersonas = new DefaultTableModel  (null, titulosP);
            try{
           String sql = "SELECT * FROM persona;";
           
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();
           while(resultSet.next()){
               datosP [0] = resultSet.getString("id_persona");
               datosP [1] = resultSet.getString("nombre");
               datosP [2] = resultSet.getString("dni");
               datosP [3] = resultSet.getString("celular");
               
               listaPersonas.addRow(datosP);
           }
        statement.close();  
           } catch (SQLException ex) {
                   System.out.println("Error al obtener los cursos: " + ex.getMessage());
                   }
            return listaPersonas;
    }
  
    public void actualizarPersona(Persona persona){
    
        try {
            
            String sql = "UPDATE alumno SET nombrePersona = ?, dni = ? , celular =? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, persona.getNombrePersona());
            statement.setInt(2, persona.getDni());
            statement.setInt(3,persona.getCelular());
            statement.setInt(4, persona.getId_persona());
            statement.executeUpdate();
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
    
    }
    public Persona buscarPersona(int id_persona){
    Persona persona=null;
    try {
            
            String sql = "SELECT * FROM persona WHERE id_persona =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id_persona);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                persona = new Persona();
                persona.setId_persona(resultSet.getInt("id_persona"));
                persona.setNombrePersona(resultSet.getString("nombrePersona"));
                persona.setDni(resultSet.getInt("dni"));
                persona.setCelular(resultSet.getInt("celular"));

                
            }      
            statement.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un alumno: " + ex.getMessage());
        }
        
        return persona;
    }
    
}


