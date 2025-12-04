package com.redia.redia.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CicloViewController {

    /*---Devuelve el formulario de index de cuentas---*/
	@GetMapping("/")
	public String indexCuentaView() {
		return "indexC";
	}
    
}