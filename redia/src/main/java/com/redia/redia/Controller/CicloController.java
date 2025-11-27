package com.redia.redia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redia.redia.Model.Ciclo;
import com.redia.redia.Model.CicloService;

@RestController
public class CicloController {
    @Autowired
    private CicloService cicloService;

    // Devuelve todos los cascos
    @GetMapping("/ciclo")  //consumes = (mediaType.APPLICATION_JSON)
    public List<Ciclo> getAllTelemetrias(){
        return cicloService.getAlTelemetrias();
    }

    @PostMapping("/telemetria")
    public ResponseEntity<?> addTelemetria (@RequestBody Telemetria t){  //? para no especificar un tipo específico
        try{
            telemetriaService.addTelemetria(t);
            return ResponseEntity.ok().body("La telemetría se ha añadido");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("La telemetría ya existe");
        }
    }

    // Eliminar casco por Id
    @DeleteMapping("/ciclo{id}")
    public ResponseEntity 

    

}
