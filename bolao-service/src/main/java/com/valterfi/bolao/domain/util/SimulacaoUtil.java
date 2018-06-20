package com.valterfi.bolao.domain.util;

import java.util.ArrayList;
import java.util.List;

import com.valterfi.bolao.domain.Jogador;
import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Simulacao;
import com.valterfi.bolao.domain.SimulacaoForm;

public class SimulacaoUtil {
	
	private SimulacaoUtil() {
		
	}
	
	public static Simulacao mapper(SimulacaoForm simulacaoForm, Simulacao simulacao) {
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador1(), Placar.palpitar(simulacaoForm.getJogador1Gols1(), simulacaoForm.getJogador1Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador2(), Placar.palpitar(simulacaoForm.getJogador2Gols1(), simulacaoForm.getJogador2Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador3(), Placar.palpitar(simulacaoForm.getJogador3Gols1(), simulacaoForm.getJogador3Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador4(), Placar.palpitar(simulacaoForm.getJogador4Gols1(), simulacaoForm.getJogador4Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador5(), Placar.palpitar(simulacaoForm.getJogador5Gols1(), simulacaoForm.getJogador5Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador6(), Placar.palpitar(simulacaoForm.getJogador6Gols1(), simulacaoForm.getJogador6Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador7(), Placar.palpitar(simulacaoForm.getJogador7Gols1(), simulacaoForm.getJogador7Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador8(), Placar.palpitar(simulacaoForm.getJogador8Gols1(), simulacaoForm.getJogador8Gols2())));
        
        simulacao.setJogadores(jogadores);
        simulacao.setPeso(simulacaoForm.getPeso());
		
		return simulacao;
	}

}
