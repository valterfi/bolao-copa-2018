package com.valterfi.bolao.domain;

import com.valterfi.bolao.enums.TipoPonto;

public class Pontos implements Comparable<Pontos> { 
	
	private int pontos = 0;
	
	private TipoPonto tipoPonto;
	
	public static final Pontos ZERO = new Pontos(0, TipoPonto.NONE);
			
	public Pontos(int pontos) {
		this.pontos = pontos;
	}

	public Pontos(int pontos, TipoPonto tipoPonto) {
		this.pontos = pontos;
		this.tipoPonto = tipoPonto;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public TipoPonto getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(TipoPonto tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	@Override
	public int compareTo(Pontos o) {
		Pontos outrosPontos = (Pontos) o;
		if (this.pontos < outrosPontos.getPontos()) {
            return -1;
        }
        if (this.pontos > outrosPontos.getPontos()) {
            return 1;
        }
        return 0;
	}

}
