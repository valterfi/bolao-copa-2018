package com.valterfi.bolao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valterfi.bolao.domain.Classificacao;
import com.valterfi.bolao.domain.Jogador;
import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Pontos;
import com.valterfi.bolao.domain.Simulacao;
import com.valterfi.bolao.domain.util.ClassificacaoUtil;
import com.valterfi.bolao.enums.TipoPonto;
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
	
	@Autowired
	private CurrentMatch currentMatch;
	
	public List<Classificacao> retornaClassificacaoAtual(Simulacao simulacao) {
		return maisBolao.retornarClassificacao();
	}
	
	public void calcularClassificacaoAtual(List<Classificacao> classificacaoList, Simulacao simulacao) {
		Placar placarAtual = getPlacarAtual();
		calcularPontos(simulacao, placarAtual);
		
		for(Jogador jogador : simulacao.getJogadores()) {
			Classificacao classificacao = ClassificacaoUtil.get(jogador.getNome(), classificacaoList);
			TipoPonto tipoPonto = jogador.getPontos().getTipoPonto();
			int pontos = jogador.getPontos().getPontos();
			if(classificacao != null) {
				switch(tipoPonto){
	            case AP:
	            	classificacao.setAcertouPlacar(classificacao.getAcertouPlacar() + pontos);
	                break;
	            case GV:
	            	classificacao.setGolsVencedor(classificacao.getAcertouVencedor() + pontos);
	                break;
	            case SG:
	                classificacao.setSaldoGols(classificacao.getSaldoGols() + pontos);
	                break;
	            case GP:
	                classificacao.setGolsPerdedor(classificacao.getGolsPerdedor() + pontos);
	                break;
	            case AV:
	                classificacao.setAcertouVencedor(classificacao.getAcertouVencedor() + pontos);
	                break;
	            case EG:
	                classificacao.setEmpateGarantido(classificacao.getEmpateGarantido() + pontos);
	                break;
	            default:
	                break;
				}
				classificacao.setTotal(classificacao.getTotal() + pontos);
			}
		}
	}
	
	public void calcularPontos(Simulacao simulacao, Placar placarAtual) {
		for(Jogador jogador : simulacao.getJogadores()) {
			Pontos pontos = calcularPontos(placarAtual, jogador.getChute(), simulacao.getPeso());
			jogador.setPontos(pontos);
		}
	}
	
	public Placar getPlacarAtual() {
		return currentMatch.getPlacarAtual();
	}
	
	private Pontos calcularPontos(Placar correto, Placar chute, int peso) {
		
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
