package com.valterfi.bolao.domain.util;

import java.util.List;

import com.valterfi.bolao.domain.Classificacao;

public class ClassificacaoUtil {
	
	private ClassificacaoUtil() {
		
	}
	
	public static Classificacao get(String nome, List<Classificacao> classificacaoList) {
		for(Classificacao classificacao : classificacaoList) {
			if(nome.trim().equals(classificacao.getNome().trim())) {
				return classificacao;
			}
		}
		return null;
	}

}
