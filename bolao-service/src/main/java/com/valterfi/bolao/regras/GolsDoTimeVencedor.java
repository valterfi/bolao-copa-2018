package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.enums.TipoPonto;

public class GolsDoTimeVencedor implements Regra {

	public Pontos executar(Placar correto, Placar chute, int peso) {
		
		if(!chute.naoPalpitou() && !correto.isEmpate() && !chute.isEmpate()) {
			
			if(correto.isTime1Vencedor() && chute.isTime1Vencedor()) {
				if(correto.getGols1() == chute.getGols1()) {
					return new Pontos((18*peso), TipoPonto.GV);
				}
			}
			
			if(correto.isTime2Vencedor() && chute.isTime2Vencedor()) {
				if(correto.getGols2() == chute.getGols2()) {
					return new Pontos((18*peso), TipoPonto.GV);
				}
			}
			
		}
		
		return Pontos.ZERO;
	}
	

}
