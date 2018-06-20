package com.valterfi.bolao.service;

import java.util.ArrayList;
import java.util.List;

import com.valterfi.bolao.domain.Placar;
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
	
	public int calcularRodada(int peso) {
		int calculo = 0;
		
		for(Regra regra : this.regras) {
			int calculoAtual = regra.executar(this.correto, this.chute, peso);
			if(calculo < calculoAtual) {
				calculo = calculoAtual;
			}
		}
		return calculo;
	}

}
