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
        return RepositoryCiclo.getReferenceById(id);
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
    public void updateCiclo(Ciclo c){
        Ciclo cicloExistente = RepositoryCiclo.findById(c.getId()).orElseThrow(() -> new RuntimeException("Ciclo no encontrado"));
        cicloExistente.setDuracion(c.getDuracion());
        cicloExistente.setFechaInicio(c.getFechaInicio());
        cicloExistente.setFechaFinal(c.getFechaFinal());
        cicloExistente.setFaseActual(c.getFaseActual());
        cicloExistente.setEstadoConexion(c.getEstadoConexion());
        cicloExistente.setSintomas(c.getSintomas());
        cicloExistente.setObservaciones(c.getObservaciones());
        RepositoryCiclo.save(cicloExistente);
    }

    public void removeCiclo(Ciclo ciclo) {
        RepositoryCiclo.delete(ciclo);
    }

    public void removeCicloID(Long id) {
        RepositoryCiclo.deleteById(id);
    }

    public Object getAllCiclos(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getAllCuentas'");
    }
}
