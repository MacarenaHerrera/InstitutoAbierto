package institutoabierto.modelo;


public class Curso {
    private int id_curso;
    private String nombreCurso;
    private String descripcion;
    private double costo;
    private int cupoMax;
    private int id_persona;
    public Curso(int id_curso, String nombreCurso, String descripcion, double costo, int cupoMax,  int id_persona) {
        this.id_curso = id_curso;
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cupoMax = cupoMax;
        this.id_persona=id_persona;
    }

    public Curso(String nombreCurso, String descripcion, double costo, int cupoMax,int id_persona) {
        this.nombreCurso = nombreCurso;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cupoMax = cupoMax;
        this.id_persona=id_persona;
    }
     public Curso(){
       id_curso=-1;
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

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona=id_persona;
    }

  
    
    
}
