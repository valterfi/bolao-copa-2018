package com.valterfi.bolao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valterfi.bolao.domain.Classificacao;
import com.valterfi.bolao.domain.Jogador;
import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Simulacao;
import com.valterfi.bolao.regras.Empate;
import com.valterfi.bolao.regras.GolsDoTimePerdedor;
import com.valterfi.bolao.regras.GolsDoTimeVencedor;
import com.valterfi.bolao.regras.PlacarExato;
import com.valterfi.bolao.regras.Regra;
import com.valterfi.bolao.regras.SaldoDeGols;
import com.valterfi.bolao.regras.VencedorDaPartida;

@Service
public class BolaoService {
	
	@Autowired
	private MaisBolao maisBolao;
	
	public List<Classificacao> retornaClassificacaoAtual(Simulacao simulacao) {
		return maisBolao.retornarClassificacao();
	}
	
	public void calcularPontos(Simulacao simulacao) {
		for(Jogador jogador : simulacao.getJogadores()) {
			jogador.setPontos(calcularPontos(Placar.palpitar(1, 0), jogador.getChute(), simulacao.getPeso()));
		}
	}
	
	private int calcularPontos(Placar correto, Placar chute, int peso) {
		
		List<Regra> regras = new ArrayList<Regra>();
		regras.add(new PlacarExato());
		regras.add(new GolsDoTimeVencedor());
		regras.add(new SaldoDeGols());
		regras.add(new GolsDoTimePerdedor());
		regras.add(new VencedorDaPartida());
		regras.add(new Empate());
		
		Contexto contexto = new Contexto(correto, chute, regras);
		return contexto.calcularRodada(peso);
		
	}

}
