package br.com.techgold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SolicitacaoController {

	@GetMapping("/home")
	public String solicitacaoHome() {
		
		return "templates/solicitacao.html";
	}
	
}
