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
    private int id_matricula;
    private LocalDate fecha;
    private double costo;
    private int id_persona;
    private int id_curso;

    public Matricula(int id_matricula, LocalDate fecha, double costo, int id_persona, int id_curso) {
        this.id_matricula = id_matricula;
        this.fecha = fecha;
        this.costo = costo;
        this.id_persona = id_persona;
        this.id_curso = id_curso;
    }

    public Matricula(LocalDate fecha, double costo) {
        this.fecha = fecha;
        this.costo = costo;
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

    public int getId_persona() {
        return id_persona;
    }

    public int getId_curso() {
        return id_curso;
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

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
    

}
