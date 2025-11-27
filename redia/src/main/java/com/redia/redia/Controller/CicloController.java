package com.redia.redia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public List<Ciclo> getAllCiclos(){
        return cicloService.getAllCiclos();
    }

    @PostMapping("/ciclo")
    public ResponseEntity<?> addCiclo (@RequestBody Ciclo c){  //? para no especificar un tipo específico
        try{
            cicloService.addCiclo(c);
            return ResponseEntity.ok().body("El ciclo se ha añadido");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("El ciclo ya existe");
        }
    }

    //Actualizar ciclo
    @PostMapping("/ciclo")
    public ResponseEntity<?> actualizarCiclo (@RequestBody Ciclo c){
        try{
            cicloService.actualizarCiclo(id, c);
            return ResponseEntity.ok().body("El ciclo se ha actualizado");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("El ciclo no existe");
        }
    }


    // Eliminar Ciclo por Id
    @DeleteMapping("/ciclo{id}")
    public ResponseEntity<?> eliminarCiclo (@RequestBody Long id){
        try{
            cicloService.eliminarCiclo(id);
            return ResponseEntity.ok().body("El ciclo se ha eliminado");
        } catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("El ciclo no existe");
        }
    }

    

}
