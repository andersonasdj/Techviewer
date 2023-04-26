package br.com.techgold.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techgold.dto.ResumoSolicitacoesDTO;
import br.com.techgold.dto.SolicitacaoDTO;
import br.com.techgold.model.Funcionario;
import br.com.techgold.model.Solicitacao;
import br.com.techgold.repository.FuncionarioRepository;
import br.com.techgold.repository.SolicitacaoRepository;

@RestController
public class SolicitacaoRest {

	private static Solicitacao atualizada;

	@Autowired
	SolicitacaoRepository repository;

	@Autowired
	FuncionarioRepository repositoryFuncionarioRepository;

	@GetMapping("solicitacaorest")
	public List<SolicitacaoDTO> listarSolicitacoes() {
		List<Solicitacao> solList = new ArrayList<Solicitacao>();
		solList = repository.listarNaoFinalizados();
		List<SolicitacaoDTO> listaDTO = new ArrayList<>();

		for (Solicitacao solicitacao : solList) {
			SolicitacaoDTO dto = new SolicitacaoDTO(solicitacao);

			if (dto.getStatus().equals("Aberto") && dto.getPrioridade().equals("Alta")
					|| dto.getPrioridade().equals("Media") || dto.getPrioridade().equals("Crítico")) {
				listaDTO.add(dto);
			}
		}
		return listaDTO;
	}

	@GetMapping("solicitacoesresumo")
	public ResumoSolicitacoesDTO resumoolicitacoes() {
		List<Solicitacao> solList = new ArrayList<Solicitacao>();
		solList = repository.listarNaoFinalizados();
		ResumoSolicitacoesDTO resumo = new ResumoSolicitacoesDTO();
		int abertos = 0, agendado = 0, andamento = 0, aguardando = 0, vip = 0, altas = 0, criticos = 0;
		for (Solicitacao solicitacao : solList) {
			SolicitacaoDTO dto = new SolicitacaoDTO(solicitacao);

			if (dto.getStatus().equals("Aberto")) {
				abertos++;
				resumo.setAbertas(abertos);
			} else if (dto.getStatus().equals("Aguardando")) {
				aguardando++;
				resumo.setAguardando(aguardando);
			} else if (dto.getStatus().equals("Em andamento")) {
				andamento++;
				resumo.setEmAndamento(andamento);
			} else if (dto.getStatus().equals("Agendado")) {
				agendado++;
				resumo.setAgendadas(agendado);
			}
			if (dto.getVip().equals("VIP")) {
				vip++;
				resumo.setVips(vip);
			}
			if (dto.getPrioridade().equals("Alta")) {
				altas++;
				resumo.setAltas(altas);
			}
			if (dto.getPrioridade().equals("Crítico")) {
				criticos++;
				resumo.setCriticos(criticos);
			}

		}
		resumo.setTotal(solList.size());
		return resumo;
	}

	@GetMapping("houveupdate")
	public boolean ultimoUpdate() {
		Solicitacao solicitacaoBuscada = repository.listarUltimoUpdate();
		if (solicitacaoBuscada.equals(atualizada)) {
			return false;

		} else {
			atualizada = solicitacaoBuscada;
			return true;
		}
	}

	/*
	 * @GetMapping("ultimoupdate") public SolicitacaoDTO ultimoUpdate() {
	 * Solicitacao solicitacaoBuscada = repository.listarUltimoUpdate();
	 * 
	 * if( solicitacaoBuscada.equals(atualizada)) {
	 * System.out.println("São iguais"); }else {
	 * System.out.println("são diferentes"); atualizada = solicitacaoBuscada; }
	 * 
	 * SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO(atualizada);
	 * 
	 * return solicitacaoDTO; }
	 */

	@GetMapping("funcionariosAtivos")
	public List<Funcionario> listarFuncionariosAtivos() {
		List solList = new ArrayList<Funcionario>();
		solList = repositoryFuncionarioRepository.listarAtivos();
		return solList;
	}

	@GetMapping("funcionariosInativos")
	public List<Funcionario> listarFuncionariosInativos() {
		List solList = new ArrayList<Funcionario>();
		solList = repositoryFuncionarioRepository.listarInativos();
		return solList;
	}

}
