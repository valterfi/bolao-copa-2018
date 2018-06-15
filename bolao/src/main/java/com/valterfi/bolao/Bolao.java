package com.valterfi.bolao;

import java.util.ArrayList;
import java.util.List;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.regras.Empate;
import com.valterfi.bolao.regras.GolsDoTimePerdedor;
import com.valterfi.bolao.regras.GolsDoTimeVencedor;
import com.valterfi.bolao.regras.PlacarExato;
import com.valterfi.bolao.regras.Regra;
import com.valterfi.bolao.regras.SaldoDeGols;
import com.valterfi.bolao.regras.VencedorDaPartida;

public class Bolao {
	
	public int calcularPontos(Placar correto, Placar chute, int peso) {
		
		List<Regra> regras = new ArrayList<Regra>();
		regras.add(new PlacarExato());
		regras.add(new GolsDoTimeVencedor());
		regras.add(new SaldoDeGols());
		regras.add(new GolsDoTimePerdedor());
		regras.add(new VencedorDaPartida());
		regras.add(new Empate());
		
		Contexto contexto = new Contexto(correto, chute, regras);
		return contexto.calcularRodada(peso);
		
	}

}
