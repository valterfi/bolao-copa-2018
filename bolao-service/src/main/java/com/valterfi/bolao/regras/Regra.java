package com.valterfi.bolao.regras;

import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;

public interface Regra {
	
	Pontos executar(Placar correto, Placar chute, int peso);

}
