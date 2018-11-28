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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
}
