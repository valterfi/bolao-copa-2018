package com.valterfi.bolao.domain;

public class Jogador {
	
	private String nome;
	
	private Placar chute;

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
		return chute;
	}

	public void setChute(Placar chute) {
		this.chute = chute;
	}
	
	

}
