package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.enums.TipoPonto;

public class Empate implements Regra {

	public Pontos executar(Placar correto, Placar chute, int peso) {
		
		if(!chute.naoPalpitou()) {
			if(!correto.isEmpate() && chute.isEmpate()) {
				return new Pontos((4*peso), TipoPonto.EG);
			}
		}
		
		return Pontos.ZERO;
	}

}
