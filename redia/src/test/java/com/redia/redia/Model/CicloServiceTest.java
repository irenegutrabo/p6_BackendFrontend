package com.redia.redia.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.jpa.repository.JpaRepository;

@ExtendWith(MockitoExtension.class)
public class CicloServiceTest {
    
    @Mock
    //JpaRepository<Ciclo, Long> repositoryCiclo;
    private CicloRepository repositoryCiclo;

    @InjectMocks
    private CicloService cicloService;

    @Test
    @DisplayName("Comprueba que se pueden obtener todos los ciclos")
    public void getAllCiclos_noCiclos_obtieneListaVacia() {
        // Arrange

        // Act
        List<Ciclo> result = cicloService.getAllCiclos();
        int sizeOobtained = result.size();
        // Assert
        assertEquals(0, sizeOobtained);
        verify(repositoryCiclo).findAll();
    }

    @Test
    @DisplayName("Comprueba que devuelve los ciclos por id")
    public void getCiclo_cicloExistente_obtieneCiclo() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        when(repositoryCiclo.findById(1L)).thenReturn(java.util.Optional.of(ciclo));

        // Act
        Ciclo result = cicloService.getCiclo(1L);

        // Assert
        assertEquals(ciclo, result);
        verify(repositoryCiclo).findById(1L);
    }
    
    @Test
    @DisplayName("Comprueba que devuelve mas de un ciclo")
    public void getAllCiclos_variosCiclos_obtieneListaNoVacia() {
        // Arrange
        Ciclo ciclo1 = new Ciclo();
        Ciclo ciclo2 = new Ciclo();
        when(repositoryCiclo.findAll()).thenReturn(Arrays.asList(ciclo1, ciclo2));

        // Act
        List<Ciclo> result = cicloService.getAllCiclos();
        int sizeOobtained = result.size();

        // Assert
        assertEquals(2, sizeOobtained);
        verify(repositoryCiclo).findAll();
    }
    

    @Test
    @DisplayName("Comprueba que se puede obtener un ciclo por id")
    public void getCiclo_cicloExistente_cicloObtenido() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        when(repositoryCiclo.findById(1L)).thenReturn(java.util.Optional.of(ciclo));
        // Act
        Ciclo result = cicloService.getCiclo(1L);

        // Assert
        assertEquals(ciclo, result);
        verify(repositoryCiclo).findById(1L);
    }

    @Test
    @DisplayName("Comprueba que se puede añadir un ciclo")
    public void addCiclo_cicloNuevo_cicloAñadido() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        ciclo.setId(1L);
        when(repositoryCiclo.saveAndFlush(ciclo)).thenReturn(ciclo);

        // Act
        Ciclo result = cicloService.addCiclo(ciclo);
        long idObtained = result.getId();
        // Assert
        assertEquals(ciclo, result);
        assertEquals(1L, idObtained);
        verify(repositoryCiclo).saveAndFlush(ciclo);
    }

    @Test
    @DisplayName("Comprueba que se puede actualizar un ciclo")
    public void updateCiclo_cicloExistente_cicloActualizado() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        ciclo.setId(1L);
        when(repositoryCiclo.findById(1L)).thenReturn(java.util.Optional.of(ciclo));
        when(repositoryCiclo.save(ciclo)).thenReturn(ciclo);

        // Act
        ciclo.setFaseActual("Ovulación");
        Ciclo cicloResultado = cicloService.updateCiclo(ciclo);

        // Assert
        assertEquals(cicloResultado, ciclo);
        verify(repositoryCiclo).findById(1L);
        verify(repositoryCiclo).save(ciclo);
    }

    @Test
    @DisplayName("Comprueba que no se puede actualizar un ciclo que no existe")
    public void updateCiclo_cicloNoExistente_lanzaExcepcion() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        ciclo.setId(1L);
        when(repositoryCiclo.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cicloService.updateCiclo(ciclo);
        });

        verify(repositoryCiclo).findById(1L);
        verify(repositoryCiclo, never()).save(ciclo);
    }
    
    @Test
    @DisplayName("Comprueba que se elimina el ciclo correctamente pasando el objeto ciclo")
    public void deleteCiclo_objetoCiclo_llamadaAlRepositorio() {
        // Arrange: Creamos el objeto que vamos a pasar
        Ciclo ciclo = new Ciclo();
        ciclo.setId(1L);
        ciclo.setFaseActual("Folicular");

        // Act: Llamamos al método exacto de tu Service
        cicloService.deleteCiclo(ciclo);

        // Assert: Verificamos que el Service realmente le pasó el objeto al Repository
        verify(repositoryCiclo).delete(ciclo);
    }

    @Test
    @DisplayName("Comprueba que no se puede eliminar un ciclo a traves del objeto ciclo si el id es null")
    public void removeCiclo_cicloIdNull_lanzaExcepcion() {
        // Arrange
        Ciclo ciclo = new Ciclo();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cicloService.removeCiclo(ciclo);
        });
        verify(repositoryCiclo, never()).delete(ciclo);
    }

    @Test
    @DisplayName("Comprueba que no se puede eliminar un ciclo a traves del objeto ciclo que no existe")
    public void removeCiclo_cicloNoExistente_lanzaExcepcion() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        ciclo.setId(1L);
        when(repositoryCiclo.existsById(1L)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cicloService.removeCiclo(ciclo);
        });

        verify(repositoryCiclo).existsById(1L);
        verify(repositoryCiclo, never()).delete(ciclo);
    }

    @Test
    @DisplayName("Comprueba que se puede eliminar un ciclo a traves del objeto ciclo")
    public void removeCiclo_cicloExistente_cicloEliminado() {
        // Arrange
        Ciclo ciclo = new Ciclo();
        ciclo.setId(1L);
        when(repositoryCiclo.existsById(1L)).thenReturn(true);

        // Act
        cicloService.removeCiclo(ciclo);

        // Assert
        verify(repositoryCiclo).existsById(1L);
        verify(repositoryCiclo).delete(ciclo);
    }

    @Test
    @DisplayName("Comprueba que no se puede eliminar un ciclo por id si el id es null")
    public void removeCicloID_idNull_lanzaExcepcion() {
        // Arrange
        Long id = null;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cicloService.removeCicloID(id);
        });

        verify(repositoryCiclo, never()).deleteById(id);
    }

    @Test
    @DisplayName("Comprueba que no se puede eliminar un ciclo por id si no existe")
    public void removeCicloID_cicloNoExistente_lanzaExcepcion() {
        // Arrange
        Long id = 1L;
        when(repositoryCiclo.existsById(id)).thenReturn(false);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            cicloService.removeCicloID(id);
        });

        verify(repositoryCiclo).existsById(id);
        verify(repositoryCiclo, never()).deleteById(id);
    }

    @Test
    @DisplayName("Comprueba que se puede eliminar un ciclo por id")
    public void removeCicloID_cicloExistente_cicloEliminado() {
        // Arrange
        Long id = 1L;
        when(repositoryCiclo.existsById(id)).thenReturn(true);
        // Act
        cicloService.removeCicloID(id);

        // Assert
        verify(repositoryCiclo).existsById(id);
        verify(repositoryCiclo).deleteById(id);
    }

}
