package br.com.techgold.dto;

public class ResumoSolicitacoesDTO {

	private int total;
	private int abertas;
	private int agendadas;
	private int emAndamento;
	private int aguardando;
	private int vips;
	private int altas;
	private int criticos;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAbertas() {
		return abertas;
	}

	public void setAbertas(int abertas) {
		this.abertas = abertas;
	}

	public int getAgendadas() {
		return agendadas;
	}

	public void setAgendadas(int agendadas) {
		this.agendadas = agendadas;
	}

	public int getEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(int emAndamento) {
		this.emAndamento = emAndamento;
	}

	public int getAguardando() {
		return aguardando;
	}

	public void setAguardando(int aguardando) {
		this.aguardando = aguardando;
	}

	public int getVips() {
		return vips;
	}

	public void setVips(int vips) {
		this.vips = vips;
	}

	public int getAltas() {
		return altas;
	}

	public void setAltas(int altas) {
		this.altas = altas;
	}
	
	public int getCriticos() {
		return criticos;
	}
	
	public void setCriticos(int criticos) {
		this.criticos = criticos;
	}
}
