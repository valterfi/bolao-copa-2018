package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;

public class SaldoDeGols implements Regra {

	public int executar(Placar correto, Placar chute, int peso) {
		
		if(!chute.naoPalpitou()) {
			
			int saldoCorreto = (correto.getGols1() - correto.getGols2());
			int saldoChute = (chute.getGols1() - chute.getGols2());
			
			if(saldoCorreto == saldoChute) {
				return (15*peso);
			}
			
		}
		
		return 0;
	}

}
