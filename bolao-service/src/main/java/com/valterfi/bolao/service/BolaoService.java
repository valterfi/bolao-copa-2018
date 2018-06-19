package com.valterfi.bolao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valterfi.bolao.domain.Classificacao;
import com.valterfi.bolao.domain.Simulacao;

@Service
public class BolaoService {
	
	@Autowired
	private MaisBolao maisBolao;
	
	public List<Classificacao> retornaClassificacaoAtual(Simulacao simulacao) {
		return maisBolao.retornarClassificacao();
	}

}
