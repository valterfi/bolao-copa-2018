package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;

public class GolsDoTimeVencedor implements Regra {

	public int executar(Placar correto, Placar chute, int peso) {
		
		if(!chute.naoPalpitou() && !correto.isEmpate() && !chute.isEmpate()) {
			
			if(correto.isTime1Vencedor() && chute.isTime1Vencedor()) {
				if(correto.getGols1() == chute.getGols1()) {
					return (18*peso);
				}
			}
			
			if(correto.isTime2Vencedor() && chute.isTime2Vencedor()) {
				if(correto.getGols2() == chute.getGols2()) {
					return (18*peso);
				}
			}
			
		}
		
		return 0;
	}
	

}
