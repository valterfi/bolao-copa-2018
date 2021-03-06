package com.valterfi.bolao.domain;

public class Jogador {
	
	private String nome;
	 
	private Placar chute;
	
	private Pontos pontos = Pontos.ZERO;

	public Jogador(String nome, Placar chute) {
		super();
		this.nome = nome;
		this.chute = chute;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Placar getChute() {
		if(this.chute == null) {
			return new Placar();
		}
		return chute;
	}

	public void setChute(Placar chute) {
		this.chute = chute;
	}

	public Pontos getPontos() {
		return pontos;
	}

	public void setPontos(Pontos pontos) {
		this.pontos = pontos;
	}

}
