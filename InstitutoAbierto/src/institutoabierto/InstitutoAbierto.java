/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoabierto;

import institutoabierto.modelo.Conexion;
import institutoabierto.modelo.Curso;
import institutoabierto.modelo.CursoData;
import institutoabierto.modelo.Persona;
import institutoabierto.modelo.PersonaData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maqui's
 */
public class InstitutoAbierto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion;
            conexion = new Conexion
                         ("jdbc:mysql://localhost/instituto_abierto", "root", "");
           /* PersonaData personadata = new PersonaData (conexion);
            
            Persona persona1 = new Persona ("Macarena Herrera", 38750019, 154749854);
            personadata.inscribirPersona(persona1);
            System.out.println("El id del nombre es: " + persona1.getId_persona());*/
            CursoData cursodata=new CursoData(conexion);
            Curso curso1=new Curso ("matematica","esta bueno",150,20,1);
            cursodata.altaCurso(curso1);
            System.out.println("El id del nombre es: " + curso1.getId_curso());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstitutoAbierto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
