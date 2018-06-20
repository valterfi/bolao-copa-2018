package com.valterfi.bolao.service;

import java.util.ArrayList;
import java.util.List;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.regras.Regra;

public class Contexto {
	
	private Placar correto;
	
	private Placar chute;
	
	private List<Regra> regras = new ArrayList<Regra>();

	public Contexto(Placar correto, Placar chute, List<Regra> regras) {
		this.correto = correto;
		this.chute = chute;
		this.regras = regras;
	}
	
	public Pontos calcularRodada(int peso) {
		Pontos calculo = Pontos.ZERO;
		
		for(Regra regra : this.regras) {
			Pontos calculoAtual = regra.executar(this.correto, this.chute, peso);
			if(calculo.compareTo(calculoAtual) < 0 ){
				calculo = calculoAtual;
			}
		}
		return calculo;
	}

}
