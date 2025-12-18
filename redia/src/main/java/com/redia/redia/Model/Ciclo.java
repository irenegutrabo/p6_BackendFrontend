package com.redia.redia.Model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ciclo {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;    
    public Long getId() {
        return Id;
    }
    public void setId(long id) {
        this.Id = id;
    }

    private int Duracion;
    public int getDuracion() {
        return Duracion;
    }
    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    private LocalDate FechaInicio;
    public LocalDate getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(LocalDate FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    private LocalDate FechaFinal;
    public LocalDate getFechaFinal() {
        return FechaFinal;
    }
    public void setFechaFinal(LocalDate FechaFinal) {
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
