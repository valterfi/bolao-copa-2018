package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;

public interface Regra {
	
	int executar(Placar correto, Placar chute, int peso);

}
