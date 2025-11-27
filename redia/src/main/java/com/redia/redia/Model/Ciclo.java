package com.redia.redia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Ciclo {
    @Id 
    private Long id;
    private int Duracion;
    private DateTime FechaInicio;
    private DateTime FechaFinal;
    private String FaseActual;
    private String EstadoConexion;
    private String Sintomas;
    private String Observaciones;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getDuracion() {
        return Duracion;
    }
    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public DateTime getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(DateTime FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public DateTime getFechaFinal() {
        return FechaFinal;
    }
    public void setFechaFinal(DateTime FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    

}
