package com.valterfi.bolao.domain;

import java.util.List;

import com.valterfi.bolao.domain.util.JogadorUtil;

public class Simulacao {
	
	private int peso = 1;
	
	private Placar chute;
	
	private List<Jogador> jogadores = JogadorUtil.criarJogadores();

	public Simulacao(int peso, Placar chute, List<Jogador> jogadores) {
		super();
		this.peso = peso;
		this.chute = chute;
		this.jogadores = jogadores;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Placar getChute() {
		return chute;
	}

	public void setChute(Placar chute) {
		this.chute = chute;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
