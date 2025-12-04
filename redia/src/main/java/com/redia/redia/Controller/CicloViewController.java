package com.redia.redia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.redia.redia.Model.Ciclo;
import com.redia.redia.Model.CicloService;

@Controller
public class CicloViewController {

    @Autowired
    private CicloService cicloService;

    /*---Devuelve el formulario de index de ciclos---*/
	@GetMapping("/")
	public String indexCicloView() {
		return "indexCiclo";
	}

    /*---Devuelve el formulario para anyadir un nuevo ciclo con un ciclo vacio---*/
	@GetMapping("/addCiclo")
	public String addCicloView(Model model) {
		model.addAttribute("ciclo", new Ciclo());
		return "addCiclo";
	}

    /*---Devuelve el formulario para listar los ciclos del sistema---*/
	@GetMapping("/listCiclo")
	public String listCicloView(Model model) {
		model.addAttribute("ciclos", cicloService.getAllCiclos());
		return "listCiclo";
	}

    /*---Devuelve el formulario para editar una ciclo---*/
	@GetMapping("/editCiclo/{id}")
	public String editCicloView(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ciclo", cicloService.getCiclo(id));
		return "updateCiclo";
	}




    
    
}