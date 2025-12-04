package com.redia.redia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.redia.redia.Model.CicloService;


@Controller
public class PageViewController {
    @Autowired
    private CicloService cicloService;

    @GetMapping("/ciclo/{id}")
    public String indexCicloView(@PathVariable("id") Long id, Model model){ 
        model.addAttribute("id", cicloService.getCiclo(id).getId()); 
        model.addAttribute("Duración", cicloService.getCiclo(id).getDuracion());
        model.addAttribute("FechaInicio", cicloService.getCiclo(id).getFechaInicio());
        model.addAttribute("FechaFinal", cicloService.getCiclo(id).getFechaFinal());    
        model.addAttribute("FaseActual", cicloService.getCiclo(id).getFaseActual());
        model.addAttribute("EstadoConexion", cicloService.getCiclo(id).getEstadoConexion());        
        model.addAttribute("Sintomas", cicloService.getCiclo(id).getSintomas());    
        model.addAttribute("Observaciones", cicloService.getCiclo(id).getObservaciones());      
        return "ciclo";
    }
}

