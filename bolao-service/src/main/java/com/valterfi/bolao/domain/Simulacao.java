package com.valterfi.bolao.domain;

import java.util.List;

import com.valterfi.bolao.domain.util.JogadorUtil;

public class Simulacao {
	
	private int peso = 1;
	
	private Placar correto;
	
	private List<Jogador> jogadores = JogadorUtil.criarJogadores();

	public Simulacao(int peso, Placar correto, List<Jogador> jogadores) {
		super();
		this.peso = peso;
		this.correto = correto;
		this.jogadores = jogadores;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Placar getCorreto() {
		return correto;
	}

	public void setCorreto(Placar correto) {
		this.correto = correto;
	}

	public List<Jogador> getJogadores() {
		if(jogadores == null) {
			return JogadorUtil.criarJogadores();
		}
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
