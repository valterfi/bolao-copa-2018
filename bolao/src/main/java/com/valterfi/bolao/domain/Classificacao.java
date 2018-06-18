package com.valterfi.bolao.domain;

import java.io.Serializable;

public class Classificacao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -198267332256239533L;
	

	private String nome = "";
	
	private int total = 0;
	
	private int acertouPlacar = 0;
	
	private int golsVencedor = 0;
	
	private int saldoGols = 0;
	
	private int golsPerdedor = 0;
	
	private int acertouVencedor = 0;
	
	private int empateGarantido = 0;
	
	public Classificacao(String nome, int total, int acertouPlacar, int golsVencedor, int saldoGols, int golsPerdedor, int acertouVencedor, int empateGarantido) {
		super();
		this.nome = nome;
		this.total = total;
		this.acertouPlacar = acertouPlacar;
		this.golsVencedor = golsVencedor;
		this.saldoGols = saldoGols;
		this.golsPerdedor = golsPerdedor;
		this.acertouVencedor = acertouVencedor;
		this.empateGarantido = empateGarantido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAcertouPlacar() {
		return acertouPlacar;
	}

	public void setAcertouPlacar(int acertouPlacar) {
		this.acertouPlacar = acertouPlacar;
	}

	public int getGolsVencedor() {
		return golsVencedor;
	}

	public void setGolsVencedor(int golsVencedor) {
		this.golsVencedor = golsVencedor;
	}

	public int getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}

	public int getGolsPerdedor() {
		return golsPerdedor;
	}

	public void setGolsPerdedor(int golsPerdedor) {
		this.golsPerdedor = golsPerdedor;
	}

	public int getAcertouVencedor() {
		return acertouVencedor;
	}

	public void setAcertouVencedor(int acertouVencedor) {
		this.acertouVencedor = acertouVencedor;
	}

	public int getEmpateGarantido() {
		return empateGarantido;
	}

	public void setEmpateGarantido(int empateGarantido) {
		this.empateGarantido = empateGarantido;
	}

	@Override
	public String toString() {
		return "Classificacao [nome=" + nome + ", total=" + total + ", acertouPlacar=" + acertouPlacar
				+ ", golsVencedor=" + golsVencedor + ", saldoGols=" + saldoGols + ", golsPerdedor=" + golsPerdedor
				+ ", acertouVencedor=" + acertouVencedor + ", empateGarantido=" + empateGarantido + "]";
	}
	

}
