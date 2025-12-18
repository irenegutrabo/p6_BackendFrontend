package com.redia.redia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redia.redia.Model.Ciclo;
import com.redia.redia.Model.CicloService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CicloController {
    @Autowired
    private CicloService cicloService;

    // Devuelve todos los ciclos
    @GetMapping("/ciclo")  //consumes = (mediaType.APPLICATION_JSON)
    public List<Ciclo> getAllCiclos(){
        return cicloService.getAllCiclos();
    }

    // Crear un nuevo ciclo
    @PostMapping("/ciclo")
    public ResponseEntity<?> saveCuenta(Ciclo ciclo, HttpServletResponse response){  //? para no especificar un tipo específico
        try{
            cicloService.addCiclo(ciclo);
            response.sendRedirect("/listCiclo");
            return ResponseEntity.ok().body("El ciclo se ha añadido");
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error creando el ciclo: " + e.getMessage());        
        }
    }

    // Actualizar ciclo
    @PutMapping("/ciclo")
    public ResponseEntity<?> updateCiclo (@ModelAttribute Ciclo ciclo, HttpServletResponse response){
        try{
            cicloService.updateCiclo(ciclo);
            response.sendRedirect("/listCiclo");
            return ResponseEntity.ok().body("El ciclo se ha actualizado");
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error actualizando el ciclo: " + e.getMessage());        
        }
    }

    // Eliminar Ciclo 
    @DeleteMapping("/ciclo/{Id}")
    public ResponseEntity<?> deleteCiclo (@PathVariable("Id") Long Id, HttpServletResponse response){
        try{
            cicloService.removeCicloID(Id);
            response.sendRedirect("/listCiclo");
            return ResponseEntity.ok().body("El ciclo se ha eliminado");
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error eliminando el ciclo: " + e.getMessage());        
        }
    }
}
