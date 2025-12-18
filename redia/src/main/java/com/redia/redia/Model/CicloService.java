package com.redia.redia.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CicloService {

    @Autowired
    private CicloRepository RepositoryCiclo;

    //Devolver todos los ciclos
    public List<Ciclo> getAllCiclos(){
        return RepositoryCiclo.findAll();
    }

    public Ciclo getCiclo(Long id){
        return RepositoryCiclo.findById(id).orElseThrow(() -> new IllegalArgumentException("Ciclo no encontrado" + id));

    }
    
    //Crear un nuevo ciclo
    public Ciclo addCiclo (Ciclo ciclo){
        return RepositoryCiclo.saveAndFlush(ciclo);
    }

    //Eliminar ciclo 
    public void deleteCiclo (Ciclo ciclo){
        RepositoryCiclo.delete(ciclo);
    }

    //Actualizar ciclo
    public Ciclo updateCiclo(Ciclo c){
        Ciclo cicloExistente = getCiclo(c.getId());
        cicloExistente.setDuracion(c.getDuracion());
        cicloExistente.setFechaInicio(c.getFechaInicio());
        cicloExistente.setFechaFinal(c.getFechaFinal());
        cicloExistente.setFaseActual(c.getFaseActual());
        cicloExistente.setEstadoConexion(c.getEstadoConexion());
        cicloExistente.setSintomas(c.getSintomas());
        cicloExistente.setObservaciones(c.getObservaciones());
        return RepositoryCiclo.save(cicloExistente);
    }

    public void removeCiclo(Ciclo ciclo) {
        if (!RepositoryCiclo.existsById(ciclo.getId())) {
            throw new IllegalArgumentException("Ciclo not found: " + ciclo.getId());
        }
        RepositoryCiclo.delete(ciclo);
    }

    public void removeCicloID(Long id) {
        if (!RepositoryCiclo.existsById(id)) {
            throw new IllegalArgumentException("Ciclo not found: " + id);
        }
        RepositoryCiclo.deleteById(id);
    }

    public Object getAllCiclos(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getAllCuentas'");
    }
}
