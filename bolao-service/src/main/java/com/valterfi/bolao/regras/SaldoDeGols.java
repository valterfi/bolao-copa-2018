package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.enums.TipoPonto;

public class SaldoDeGols implements Regra {

	public Pontos executar(Placar correto, Placar chute, int peso) {
		
		if(!chute.naoPalpitou()) {
			
			int saldoCorreto = (correto.getGols1() - correto.getGols2());
			int saldoChute = (chute.getGols1() - chute.getGols2());
			
			if(saldoCorreto == saldoChute) {
				return new Pontos((15*peso), TipoPonto.SG);
			}
			
		}
		
		return Pontos.ZERO;
	}

}
