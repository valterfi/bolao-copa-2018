package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;

public class PlacarExato implements Regra {

	public int executar(Placar correto, Placar chute, int peso) {
		if(!chute.naoPalpitou()) {
			if(correto.equals(chute)) {
				return (25*peso);
			}
		}
		return 0;
	}

}
