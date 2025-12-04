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

    /*---Devuelve el formulario de index de cuentas---*/
	@GetMapping("/")
	public String indexCicloView() {
		return "indexCiclo";
	}

    /*---Devuelve el formulario para anyadir una nueva cuenta con una cuenta vacia---*/
	@GetMapping("/addCiclo")
	public String addCicloView(Model model) {
		model.addAttribute("ciclo", new Ciclo());
		return "addCiclo";
	}

    /*---Devuelve el formulario para listar las cuentas del sistema---*/
	@GetMapping("/listCiclo")
	public String listCicloView(Model model) {
		
		model.addAttribute("ciclos", cicloService.getAllCiclos());
		
		return "listCiclo";
	}

    /*---Devuelve el formulario para editar una Cuenta---*/
	@GetMapping("/editCiclo/{id}")
	public String editCicloView(@PathVariable("id") Long id, Model model) {

		model.addAttribute("ciclo", cicloService.getCiclo(id));
		return "updateCiclo";
	}




    
    
}