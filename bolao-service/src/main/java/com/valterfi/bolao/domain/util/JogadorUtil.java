package com.valterfi.bolao.domain.util;

import java.util.ArrayList;
import java.util.List;

import com.valterfi.bolao.domain.Jogador;
import com.valterfi.bolao.domain.Placar;

public class JogadorUtil {
	
	private JogadorUtil() {
		
	}
	
	public static List<Jogador> criarJogadores() {

		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador("Nicolas", new Placar()));
		jogadores.add(new Jogador("Valterfi", new Placar()));
		jogadores.add(new Jogador("Oton", new Placar()));
		jogadores.add(new Jogador("Pedro Paiva Alves", new Placar()));
		jogadores.add(new Jogador("João Paulo do Vale", new Placar()));
		jogadores.add(new Jogador("Pedro Teixeira de A...", new Placar()));
		jogadores.add(new Jogador("Robson", new Placar()));
		jogadores.add(new Jogador("Ed", new Placar()));
		
		return jogadores;
	}

}
