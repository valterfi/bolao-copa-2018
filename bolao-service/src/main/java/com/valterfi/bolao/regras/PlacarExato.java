package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.enums.TipoPonto;

public class PlacarExato implements Regra {

	public Pontos executar(Placar correto, Placar chute, int peso) {
		if(!chute.naoPalpitou()) {
			if(correto.equals(chute)) {
				return new Pontos((25*peso), TipoPonto.AP);
			}
		}
		return Pontos.ZERO;
	}

}
