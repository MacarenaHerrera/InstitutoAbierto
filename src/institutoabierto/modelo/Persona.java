package institutoabierto.modelo;


public class Persona {
    private int id_persona=-1;
    private String nombrePersona;
    private int dni;
    private int celular;
    
    public Persona(int id_persona, String nombrePersona, int dni, int celular) {
        this.id_persona = id_persona;
        this.nombrePersona = nombrePersona;
        this.dni = dni;
        this.celular = celular;
    }

    public Persona(String nombrePersona, int dni, int celular) {
        this.nombrePersona = nombrePersona;
        this.dni = dni;
        this.celular = celular;
    }

    public Persona() {
      
    }
    
    
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
    
    @Override
    public String toString(){
        return id_persona +"-"+ nombrePersona; 
 }
}
