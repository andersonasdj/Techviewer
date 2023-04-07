package br.com.techgold.dto;

import br.com.techgold.model.Solicitacao;

public class SolicitacaoDTO {

	private Long id;
	private String dataAbertura;
	private String cliente;
	private String vip;
	private String funcionario;
	private String solicitante;
	private String usuario;
	private String prioridade;
	private String descricaoProblema;
	private String resolucao;
	private String status;

	public SolicitacaoDTO(Solicitacao solicitacao) {
		this.id = solicitacao.getId();
		this.dataAbertura = solicitacao.getDataAbertura().getTime().toString();
		this.cliente = solicitacao.getCliente().getNome();
		if (solicitacao.getFuncionario() != null) {
			this.funcionario = solicitacao.getFuncionario().getNome();
		} else {
			this.funcionario = "Não Atribuido";
		}
		if (solicitacao.getCliente().isVip()) {
			this.vip = "VIP";
		}else {
			this.vip = " ";
		}

		this.solicitante = solicitacao.getSolicitante();
		this.usuario = solicitacao.getUsuario();
		this.prioridade = solicitacao.getPrioridade();
		this.descricaoProblema = solicitacao.getDescricaoProblema();
		this.resolucao = solicitacao.getResolucao();
		this.status = solicitacao.getStatus();
	}

	public Long getId() {
		return id;
	}
	
	public String getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
