package com.redia.redia.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ciclo {
    @Id 
    private Long id;    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private int Duracion;
    public int getDuracion() {
        return Duracion;
    }
    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    private LocalDateTime FechaInicio;
    public LocalDateTime getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(LocalDateTime FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    private LocalDateTime FechaFinal;
    public LocalDateTime getFechaFinal() {
        return FechaFinal;
    }
    public void setFechaFinal(LocalDateTime FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    private String FaseActual;
    public String getFaseActual() {
        return FaseActual;
    }
    public void setFaseActual(String faseActual) {
        FaseActual = faseActual;
    }

    private String EstadoConexion;
    public String getEstadoConexion() {
        return EstadoConexion;
    }
    public void setEstadoConexion(String estadoConexion) {
        EstadoConexion = estadoConexion;
    }

    private String Sintomas;
    public String getSintomas() {
        return Sintomas;
    }
    public void setSintomas(String sintomas) {
        Sintomas = sintomas;
    }

    private String Observaciones;
    public String getObservaciones() {
        return Observaciones;
    }
    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }


  



    

    

}
