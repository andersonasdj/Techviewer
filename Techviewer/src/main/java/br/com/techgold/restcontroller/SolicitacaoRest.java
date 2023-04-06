package br.com.techgold.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techgold.dto.SolicitacaoDTO;
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
	public List<SolicitacaoDTO> listarSolicitacoes(){
		List<Solicitacao> solList = new ArrayList<Solicitacao>();
		solList = repository.listarNaoFinalizados();
		List<SolicitacaoDTO> listaDTO = new ArrayList<>();
		
		for (Solicitacao solicitacao : solList) {
			SolicitacaoDTO dto = new SolicitacaoDTO(solicitacao);
			listaDTO.add(dto);
		}
		return listaDTO;
	}
	
	@GetMapping("funcionariosAtivos")
	public List<Funcionario> listarFuncionariosAtivos(){
		List solList = new ArrayList<Funcionario>();
		solList = repositoryFuncionarioRepository.listarAtivos();
		return solList;
	}
	
	@GetMapping("funcionariosInativos")
	public List<Funcionario> listarFuncionariosInativos(){
		List solList = new ArrayList<Funcionario>();
		solList = repositoryFuncionarioRepository.listarInativos();
		return solList;
	}
	
}
