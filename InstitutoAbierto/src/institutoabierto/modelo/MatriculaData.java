
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
import javax.swing.table.DefaultTableModel;


public class MatriculaData {
    private Connection connection = null;
    private Conexion conexion;
     

    public MatriculaData (Conexion conexion) {
        try {
            connection = conexion.getConexion(); 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
 
    public void registrarMatricula (Matricula matricula){
        try {
        String sql = "INSERT INTO matricula (fecha , costo, id_persona, id_curso) VALUES ( ? , ?, ? , ? );";
        
            try (PreparedStatement statement = connection.prepareStatement (sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setDate(1 , Date.valueOf(matricula.getFecha()));
                statement.setDouble (2 , matricula.getCosto());
                statement.setInt(3,matricula.getPersona().getId_persona());
                statement.setInt(4, matricula.getCurso().getId_curso());
                
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
    public void borrarMatricula(int id_persona,int id_curso){
        try {
             String sql = "DELETE FROM matricula WHERE id_persona =?, and id_curso = ? ;";
           
             
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, id_persona);
                statement.setInt(2, id_curso);
                
                statement.executeUpdate();
                statement.close(); 
            
        } catch (SQLException ex) {    
            System.out.println("Error al eliminar matricula: " + ex.getMessage());
        }
    }
    //FALTA CONSULTAR LAS CLAVES FORÁNEAS DE LA MATRÍCULA: ID_PERSONA e ID_CURSO.
   public DefaultTableModel obtenerMatricula() {      
DefaultTableModel listaMatriculas;
           String[] titulosM = {"id_matricula", "fecha",  "costo"};
           String[] datosM = new String [3];

            listaMatriculas = new DefaultTableModel  (null, titulosM);
            
        try {
            String sql = "SELECT * FROM matricula;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                datosM [0] = resultSet.getString("id_matricula");
                datosM [1] = resultSet.getString("fecha");
                datosM [2] = resultSet.getString("costo");
                listaMatriculas.addRow(datosM);
            }
                statement.close();
            } catch (SQLException ex) {
                    System.out.println("Error al obtener las matriculas: " + ex.getMessage());
                    }
            return listaMatriculas;
               }

   
   //obtenerMatriculasXPersona() ARROJA LOS MISMOS DATOS QUE OBTENER MATRICULA?
   
   public DefaultTableModel obtenerMatriculasXPersona(){
        DefaultTableModel matriculasXPersona;
        String [] titulosMXP = {"id_matricula", "fecha", "costo"};
        String [] datosMXP = new String [3];

        matriculasXPersona = new DefaultTableModel (null, titulosMXP);
        try {
            String sql = "SELECT  * FROM matricula";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
             while(resultSet.next()){
               datosMXP [0] = resultSet.getString("id_matricula");
               datosMXP [1] = resultSet.getString("fecha");
               datosMXP [2] = resultSet.getString("costo");
               matriculasXPersona.findColumn(sql);
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener las matriculas: " + ex.getMessage());
        }
       return matriculasXPersona; 
    }    
        
    public DefaultTableModel obtenerCursosMatriculados(){
       DefaultTableModel cursosMatriculados;
       String [] titulosMC = {"id_curso", "nombreCurso", "descripcion", "costo", "cupoMax"};
       String [] datosMC = new String [5];
       
       cursosMatriculados = new DefaultTableModel (null, titulosMC);
       try {
           String sql = "SELECT * FROM curso;";
           
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();
           while(resultSet.next()){
               datosMC [0] = resultSet.getString("id_curso");
               datosMC [1] = resultSet.getString("nombreCurso");
               datosMC [2] = resultSet.getString("descripcion");
               datosMC [3] = resultSet.getString("costo");
               datosMC [4] = resultSet.getString("cupoMax");
               cursosMatriculados.addRow(datosMC);
           }
               statement.close();  
           } catch (SQLException ex) {
                   System.out.println("Error al obtener los cursos: " + ex.getMessage());
                   }
   return cursosMatriculados;
   }
   
     
public void actualizarMatricula(Matricula matricula){
    
        try {
            
            String sql = "UPDATE matricula SET fecha = ?, costo = ? WHERE id_matricula = ?;";

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

            
    public Persona buscarPersona(int dni){
    
        PersonaData personadata=new PersonaData(conexion);
        return personadata.buscarPersona(dni);
    }
    
    public Curso buscarCurso(int id_curso){
    
        CursoData cursodata=new CursoData(conexion);
        return cursodata.buscarCurso(id_curso);
    }
}



