package institutoabierto.modelo;


public class Curso {
    private int id_curso=-1;
    private String nombreCurso;
    private String descripcion;
    private double costo;
    private int cupoMax;
    private Persona persona;
    
    public Curso(int id_curso, String nombreCurso, String descripcion, double costo, int cupoMax, Persona persona) {
        this.id_curso = id_curso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cupoMax = cupoMax;
        this.persona = persona;
    }

    public Curso(String nombreCurso, String descripcion, double costo, int cupoMax, Persona persona) {
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cupoMax = cupoMax;
        this.persona = persona;
    }
     public Curso(int id_curso, String nombreCurso, String descripcion, double costo, int cupoMax) {
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cupoMax = cupoMax;
        this.id_curso = id_curso;
            }
    
    public Curso(){
       
    }
    
    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String toString(){
        return id_curso+"-"+nombreCurso;
    }

}
    
    
