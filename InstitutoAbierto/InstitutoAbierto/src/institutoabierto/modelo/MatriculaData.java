
package institutoabierto.modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MatriculaData {
    private Connection connection = null;
    private Conexion conexion;
     

    public MatriculaData (Conexion conexion) {
        try {
            this.conexion=conexion;
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
                //statement.setCalendar(1 , Calendar.getInstance(matricula.getFecha()));
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
                statement.close();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrarMatricula(int id_matricula){
        try {
             String sql = "DELETE FROM matricula WHERE id_matricula =?;";
           
             
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, id_matricula);
                               
                statement.executeUpdate();
                statement.close(); 
            
        } catch (SQLException ex) {    
            System.out.println("Error al eliminar matricula: " + ex.getMessage());
        }
    }
    
   public List<Matricula> listaMatriculas(){
        List<Matricula> matriculas = new ArrayList<Matricula>();

        try {
            String sql = "SELECT * FROM matricula;";
            
            PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
            
            Matricula matricula;
            while(resultSet.next()){
                matricula = new Matricula();
                matricula.setId_matricula(resultSet.getInt("id_matricula"));
                matricula.setFecha(resultSet.getDate("fecha").toLocalDate());
                matricula.setCosto(resultSet.getDouble("costo"));
               
                 Persona  
                    persona=buscarPersonaxId(resultSet.getInt("id_persona"));
                    matricula.setPersona(persona);
              
                Curso 
                    curso=buscarCursoxId(resultSet.getInt("id_curso"));
                    matricula.setCurso(curso);

                matriculas.add(matricula);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las matriculas: " + ex.getMessage());
        }
        
        return matriculas;    
    }
         
   //obtenerMatriculasXPersona() 
   
  public List <Matricula> obtenerMatriculaxPersona(int id_persona){
        List <Matricula> matriculas = new ArrayList <> ();

        try {
            String sql = "SELECT  * FROM matricula WHERE id_persona = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id_persona);
            
            ResultSet resultSet = statement.executeQuery();
            
            Matricula matricula;
            
            while(resultSet.next()){
                matricula = new Matricula();
                matricula.setId_matricula(resultSet.getInt("id_matricula"));
                matricula.setFecha(resultSet.getDate("fecha").toLocalDate());
                matricula.setCosto(resultSet.getDouble("costo"));
            
                Curso 
                    curso=buscarCursoxId(resultSet.getInt("id_curso"));
                    matricula.setCurso(curso);
            Persona  
                persona=buscarPersonaxId(resultSet.getInt("id_persona"));
                matricula.setPersona(persona);
              
            
                
                matriculas.add(matricula);
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener las matriculas: " + ex.getMessage());
        }
       return matriculas; 
    }   
  public List <Matricula> obtenerMatriculaxCurso(int id_curso){
        List <Matricula> matriculas = new ArrayList <Matricula> ();

        try {
            String sql = "SELECT  * FROM matricula WHERE id_curso = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id_curso);
            
            ResultSet resultSet = statement.executeQuery();
            
            Matricula matricula;
            
            while(resultSet.next()){
                matricula = new Matricula();
                matricula.setId_matricula(resultSet.getInt("id_matricula"));
                matricula.setFecha(resultSet.getDate("fecha").toLocalDate());
                matricula.setCosto(resultSet.getDouble("costo"));
            
                Curso 
                    curso=buscarCursoxId(resultSet.getInt("id_curso"));
                    matricula.setCurso(curso);    
            Persona  
                persona=buscarPersonaxId(resultSet.getInt("id_persona"));
                matricula.setPersona(persona);
              
                matriculas.add(matricula);
                
            }      
            statement.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener las matriculas: " + ex.getMessage());
        }
       return matriculas; 
    }  
  
  /*
   public List<Curso> obtenerMatriculaNoCursadas(int id_curso){
        List<Curso> cursos = new ArrayList<Curso>();

        try {
                 String sql = "Select * from curso where id not in "
                    + "(select id_curso from cursada where id_persona =?);";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_curso);
            
            ResultSet resultSet = statement.executeQuery();
            Curso curso;
            while(resultSet.next()){
                curso = new Curso();
                curso.setId_curso(resultSet.getInt("id_curso"));
                curso.setNombreCurso(resultSet.getString("nombrecurso"));
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
  */
  
/*public void actualizarMatricula(Matricula matricula){
    
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

    */        
    public Persona buscarPersona(int dni){
    
        PersonaData personadata=new PersonaData(conexion);
        return personadata.buscarPersona(dni);
    }
    
    public Curso buscarCurso(String nombreCurso){
    
        CursoData cursodata=new CursoData(conexion);
        return cursodata.buscarCurso(nombreCurso);
    }

    public Persona buscarPersonaxId(int id_persona) {
        PersonaData personadata = new PersonaData (conexion);
        return personadata.buscarPersonaxId(id_persona);
    }

    public Curso buscarCursoxId(int id_curso) {
       CursoData cursodata=new CursoData(conexion);
        return cursodata.buscarCursoxId(id_curso);
    }
}



