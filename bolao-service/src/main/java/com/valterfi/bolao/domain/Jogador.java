package com.valterfi.bolao.domain;

public class Jogador {
	
	private String nome;
	 
	private Placar chute;
	
	private int pontos = 0;

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

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	

}
