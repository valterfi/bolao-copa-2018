package com.valterfi.bolao;

import org.junit.Assert;
import org.junit.Test;

import com.valterfi.bolao.domain.Placar;

public class BolaoSiteTest {
	
	@Test
	public void exemploPontuacao1() {
		
		Placar correto = new Placar(2, 0);
		int peso = 1;
		
		int resultado1 = chutar(Placar.palpitar(2, 0), correto, peso);
		Assert.assertTrue(resultado1 == 25);
		
		int resultado2 = chutar(Placar.palpitar(2, 1), correto, peso);
		Assert.assertTrue(resultado2 == 18);
		
		int resultado3 = chutar(Placar.palpitar(3, 1), correto, peso);
		Assert.assertTrue(resultado3 == 15);
		
		int resultado4 = chutar(Placar.palpitar(1, 0), correto, peso);
		Assert.assertTrue(resultado4 == 12);
		
		int resultado5 = chutar(Placar.palpitar(4, 1), correto, peso);
		Assert.assertTrue(resultado5 == 10);
		
		int resultado6 = chutar(Placar.palpitar(0, 0), correto, peso);
		Assert.assertTrue(resultado6 == 4);
		
		int resultado7 = chutar(Placar.palpitar(2, 3), correto, peso);
		Assert.assertTrue(resultado7 == 0);
		
	}
	
	@Test
	public void exemploPontuacao2() {
		
		Placar correto = new Placar(1, 2);
		int peso = 1;
		
		int resultado1 = chutar(Placar.palpitar(1, 2), correto, peso);
		Assert.assertTrue(resultado1 == 25);
		
		int resultado2 = chutar(Placar.palpitar(0, 2), correto, peso);
		Assert.assertTrue(resultado2 == 18);
		
		int resultado3 = chutar(Placar.palpitar(2, 3), correto, peso);
		Assert.assertTrue(resultado3 == 15);
		
		int resultado4 = chutar(Placar.palpitar(1, 3), correto, peso);
		Assert.assertTrue(resultado4 == 12);
		
		int resultado5 = chutar(Placar.palpitar(0, 4), correto, peso);
		Assert.assertTrue(resultado5 == 10);
		
		int resultado6 = chutar(Placar.palpitar(2, 2), correto, peso);
		Assert.assertTrue(resultado6 == 4);
		
		int resultado7 = chutar(Placar.palpitar(1, 0), correto, peso);
		Assert.assertTrue(resultado7 == 0);
		
	}
	
	@Test
	public void exemploPontuacao3() {
		
		Placar correto = new Placar(1, 1);
		int peso = 1;
		
		int resultado1 = chutar(Placar.palpitar(1, 1), correto, peso);
		Assert.assertTrue(resultado1 == 25);
		
		int resultado2 = chutar(Placar.palpitar(3, 3), correto, peso);
		Assert.assertTrue(resultado2 == 15);
		
		int resultado3 = chutar(Placar.palpitar(1, 0), correto, peso);
		Assert.assertTrue(resultado3 == 0);
		
		int resultado4 = chutar(Placar.palpitar(1, 2), correto, peso);
		Assert.assertTrue(resultado4 == 0);
		
		int resultado5 = chutar(Placar.palpitar(3, 1), correto, peso);
		Assert.assertTrue(resultado5 == 0);
		
	}

	private int chutar(Placar chute, Placar correto, int peso) {
		Bolao bolao = new Bolao();
		int resultado = bolao.calcularPontos(correto, chute, peso);
		return resultado;
	}

}
