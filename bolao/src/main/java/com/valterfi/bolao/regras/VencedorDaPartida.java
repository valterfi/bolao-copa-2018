package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;

public class VencedorDaPartida implements Regra {

	public int executar(Placar correto, Placar chute, int peso) {

		if(!chute.naoPalpitou()) {
			
			if(correto.isTime1Vencedor() && chute.isTime1Vencedor()) {
				return (10*peso);
			}
			
			if(correto.isTime2Vencedor() && chute.isTime2Vencedor()) {
				return (10*peso);
			}
			
		}
		
		return 0;
	}

}
