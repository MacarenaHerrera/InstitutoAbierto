package institutoabierto.modelo;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maqui's
 */
public class Matricula {
    private int id_matricula=-1;
    private LocalDate fecha;
    private double costo;
    private Persona persona;
    private Curso curso;

    public Matricula(int id_matricula, LocalDate fecha, double costo,Persona persona,Curso curso ) {
        this.id_matricula = id_matricula;
        this.fecha = fecha;
        this.costo = costo;
        this.persona=persona;
        this.curso=curso;
    }

    public Matricula(LocalDate fecha, double costo) {
        this.fecha = fecha;
        this.costo = costo;
    }
public Matricula(){

}
    public int getId_matricula() {
        return id_matricula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCosto() {
        return costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setPersona(Persona persona) {
        this.persona=persona;
    }

    public void setCurso(Curso curso) {
        this.curso=curso;
    }

   
    

}
