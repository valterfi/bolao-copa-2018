package com.valterfi.bolao;

import org.junit.Test;

import com.valterfi.bolao.domain.Placar;

public class BolaoTest {
	
	/**
	 * Russia vs Arabia Saudita
	 */
	@Test
	public void calcularPontosRodada1Test() {
		
		Placar correto = new Placar(5, 0);
		int peso = 10;
		
		calcularPontosPorJogador(correto, Placar.palpitar(1,0), peso, "Oton");
		calcularPontosPorJogador(correto, Placar.palpitar(2,0), peso, "Pedro Paiva");
		calcularPontosPorJogador(correto, Placar.palpitar(2,0), peso, "Ed");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Nicolas");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Do Vale");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Teixeira");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Robson");
		calcularPontosPorJogador(correto, Placar.palpitar(0,1), peso, "Valterfi");
		
	}

	private void calcularPontosPorJogador(Placar correto, Placar chute, int peso, String nome) {
		Bolao bolao = new Bolao();
		int saida = bolao.calcularPontos(correto, chute, peso);
		System.out.println("Rodada 1 " + nome + ": " + chute.getGols1() + " x " + chute.getGols2() + " = " + saida + " pontos");
	}

}
