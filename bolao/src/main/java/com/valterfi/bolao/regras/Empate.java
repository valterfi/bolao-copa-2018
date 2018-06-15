package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;

public class Empate implements Regra {

	public int executar(Placar correto, Placar chute, int peso) {
		
		if(!chute.naoPalpitou()) {
			if(!correto.isEmpate() && chute.isEmpate()) {
				return (4*peso);
			}
		}
		
		return 0;
	}

}
