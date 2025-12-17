package com.redia.redia.Model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.redia.redia.Model.Ciclo;

                      
public class CicloTest {
    private Ciclo ciclo;

    @BeforeEach
    public void setUp() {
        ciclo = new Ciclo();
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de id Ciclo")
    public void id_getId_Correcto() {
        // Test implementation here
        //arrange
        long id = 1;
        ciclo.setId(id);

        //act
        long id_obtenido = ciclo.getId();
        
        //assert
        assertEquals(id, id_obtenido);
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de duracion Ciclo")
    public void Duracion_getDuracion_Correcto() {
        // Test implementation here
        //arrange
        int duracion = 28;
        ciclo.setDuracion(duracion);

        //act
        int duracion_obtenida = ciclo.getDuracion();
        
        //assert
        assertEquals(duracion, duracion_obtenida);
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de fecha inicio Ciclo")
    public void FechaInicio_getFechaInicio_Correcto() {
        // Test implementation here
        //arrange
        LocalDate fechaInicio = LocalDate.of(2024, 1, 1);
        ciclo.setFechaInicio(fechaInicio);

        //act
        LocalDate fechaInicio_obtenida = ciclo.getFechaInicio();
        
        //assert
        assertEquals(fechaInicio, fechaInicio_obtenida);
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de fecha final Ciclo")
    public void FechaFinal_getFechaFinal_Correcto() {
        // Test implementation here
        //arrange
        LocalDate fechaFinal = LocalDate.of(2024, 1, 29);
        ciclo.setFechaFinal(fechaFinal);

        //act
        LocalDate fechaFinal_obtenida = ciclo.getFechaFinal();
        
        //assert
        assertEquals(fechaFinal, fechaFinal_obtenida);
    }


    @Test
    @DisplayName("Comprobamos el funcionamiento de fase actual Ciclo")
    public void FaseActual_getFaseActual_Correcto() {
        // Test implementation here
        //arrange
        String faseActual = "fase1";
        ciclo.setFaseActual(faseActual);

        //act
        String faseActual_obtenida = ciclo.getFaseActual();
        
        //assert
        assertEquals(faseActual, faseActual_obtenida);
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de estado conexion Ciclo")
    public void EstadoConexion_getEstadoConexion_Correcto() { 
        // Test implementation here
        //arrange
        String estadoConexion = "conectado";
        ciclo.setEstadoConexion(estadoConexion);

        //act
        String estadoConexion_obtenida = ciclo.getEstadoConexion();
        
        //assert
        assertEquals(estadoConexion, estadoConexion_obtenida);
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de sintomas Ciclo")
    public void Sintomas_getSintomas_Correcto() {
        // Test implementation here
        //arrange
        String sintomas = "dolor de cabeza";
        ciclo.setSintomas(sintomas);

        //act
        String sintomas_obtenidos = ciclo.getSintomas();
        
        //assert
        assertEquals(sintomas, sintomas_obtenidos);
    }

    @Test
    @DisplayName("Comprobamos el funcionamiento de observaciones Ciclo")    
    public void Observaciones_getObservaciones_Correcto() {
        // Test implementation here
        //arrange
        String observaciones = "ninguna";
        ciclo.setObservaciones(observaciones);

        //act
        String observaciones_obtenidas = ciclo.getObservaciones();
        
        //assert
        assertEquals(observaciones, observaciones_obtenidas);
    }
}