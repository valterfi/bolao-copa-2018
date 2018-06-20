package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.enums.TipoPonto;

public class VencedorDaPartida implements Regra {

	public Pontos executar(Placar correto, Placar chute, int peso) {

		if(!chute.naoPalpitou()) {
			
			if(correto.isTime1Vencedor() && chute.isTime1Vencedor()) {
				return new Pontos((10*peso), TipoPonto.AV);
			}
			
			if(correto.isTime2Vencedor() && chute.isTime2Vencedor()) {
				return new Pontos((10*peso), TipoPonto.AV);
			}
			
		}
		
		return Pontos.ZERO;
	}

}
