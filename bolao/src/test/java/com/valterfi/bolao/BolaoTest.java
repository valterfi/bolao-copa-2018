package com.valterfi.bolao;

import org.junit.Test;

import com.valterfi.bolao.domain.Placar;

public class BolaoTest {
	
	/**
	 * Russia vs Arabia Saudita
	 */
	@Test
	public void calcularPontosRodada1RussiaArabiaSauditaTest() {
		
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
	
	/**
	 * Egito vs Uruguai
	 */
	@Test
	public void calcularPontosRodada1EgitoUruguaiTest() {
		
		Placar correto = new Placar(0, 1);
		int peso = 11;
		
		calcularPontosPorJogador(correto, Placar.palpitar(1,2), peso, "Oton");
		calcularPontosPorJogador(correto, Placar.palpitar(1,2), peso, "Pedro Paiva");
		calcularPontosPorJogador(correto, Placar.palpitar(1,3), peso, "Ed");
		calcularPontosPorJogador(correto, Placar.palpitar(0,2), peso, "Nicolas");
		calcularPontosPorJogador(correto, Placar.palpitar(1,2), peso, "Do Vale");
		calcularPontosPorJogador(correto, Placar.palpitar(0,2), peso, "Teixeira");
		calcularPontosPorJogador(correto, Placar.palpitar(2,0), peso, "Robson");
		calcularPontosPorJogador(correto, Placar.palpitar(1,3), peso, "Valterfi");
		
	}
	
	/**
	 * Marrocos vs Ira
	 */
	@Test
	public void calcularPontosRodada1MarrocosIraTest() {
		
		Placar correto = new Placar(0, 1);
		int peso = 11;
		
		calcularPontosPorJogador(correto, Placar.palpitar(0,0), peso, "Oton");
		calcularPontosPorJogador(correto, Placar.palpitar(1,1), peso, "Pedro Paiva");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Ed");
		calcularPontosPorJogador(correto, Placar.palpitar(1,0), peso, "Nicolas");
		calcularPontosPorJogador(correto, Placar.palpitar(1,1), peso, "Do Vale");
		calcularPontosPorJogador(correto, Placar.palpitar(1,1), peso, "Teixeira");
		calcularPontosPorJogador(correto, Placar.palpitar(0,0), peso, "Robson");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Valterfi");
		
	}
	
	/**
	 * Portugal vs Espanha
	 */
	@Test
	public void calcularPontosRodada1PortugalEspanhaTest() {
		
		Placar correto = new Placar(3, 3);
		int peso = 11;
		
		calcularPontosPorJogador(correto, Placar.palpitar(1,2), peso, "Oton");
		calcularPontosPorJogador(correto, Placar.palpitar(1,1), peso, "Pedro Paiva");
		calcularPontosPorJogador(correto, Placar.palpitar(0,1), peso, "Ed");
		calcularPontosPorJogador(correto, Placar.palpitar(1,1), peso, "Nicolas");
		calcularPontosPorJogador(correto, Placar.palpitar(1,0), peso, "Do Vale");
		calcularPontosPorJogador(correto, Placar.palpitar(2,1), peso, "Teixeira");
		calcularPontosPorJogador(correto, Placar.palpitar(3,1), peso, "Robson");
		calcularPontosPorJogador(correto, Placar.palpitar(2,4), peso, "Valterfi");
		
	}

	private void calcularPontosPorJogador(Placar correto, Placar chute, int peso, String nome) {
		Bolao bolao = new Bolao();
		int saida = bolao.calcularPontos(correto, chute, peso);
		System.out.println("Rodada 1 " + nome + ": " + chute.getGols1() + " x " + chute.getGols2() + " = " + saida + " pontos");
	}

}
