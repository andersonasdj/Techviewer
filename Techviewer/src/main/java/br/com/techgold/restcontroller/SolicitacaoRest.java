package br.com.techgold.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techgold.model.Funcionario;
import br.com.techgold.model.Solicitacao;
import br.com.techgold.repository.FuncionarioRepository;
import br.com.techgold.repository.SolicitacaoRepository;

@RestController
public class SolicitacaoRest {

	@Autowired
	SolicitacaoRepository repository;
	
	@Autowired
	FuncionarioRepository repositoryFuncionarioRepository;
	
	@GetMapping("solicitacaorest")
	public List<Solicitacao> listarSolicitacoes(){
		
		List solList = new ArrayList<Solicitacao>();
		
		solList = repository.findAll();
		
		return solList;
	}
	
	@GetMapping("solicitacaorestcliente")
	public List<Funcionario> listarFuncionarios(){
		
		List solList = new ArrayList<Funcionario>();
		
		solList = repositoryFuncionarioRepository.findAll();
		
		return solList;
	}
	
}
