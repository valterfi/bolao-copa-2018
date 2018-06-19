package com.valterfi.bolao.domain;

public class Placar {
	
	private String time1;
	
	private String time2;
	
	private Integer gols1;
	
	private Integer gols2;
	
	private int pontos = 0;
	
	public static Placar palpitar(Integer gols1, Integer gols2) {
		return new Placar(gols1, gols2);
	}
	
	public Placar() {
		
	}
	
	public Placar(String time1, String time2, Integer gols1, Integer gols2) {
		this.time1 = time1;
		this.time2 = time2;
		this.gols1 = gols1;
		this.gols2 = gols2;
	}

	public Placar(Integer gols1, Integer gols2) {
		this.gols1 = gols1;
		this.gols2 = gols2;
	}

	public boolean isTime1Vencedor() {
		return this.gols1 > this.gols2;
	}
	
	public boolean isTime2Vencedor() {
		return this.gols1 < this.gols2;
	}
	
	public boolean isEmpate() {
		return this.gols1 == this.gols2;
	}
	
	public boolean naoPalpitou() {
		return (this.gols1 == null || this.gols2 == null);
	}

	public Integer getGols1() {
		return gols1;
	}

	public void setGols1(Integer gols1) {
		this.gols1 = gols1;
	}

	public Integer getGols2() {
		return gols2;
	}

	public void setGols2(Integer gols2) {
		this.gols2 = gols2;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gols1 == null) ? 0 : gols1.hashCode());
		result = prime * result + ((gols2 == null) ? 0 : gols2.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placar other = (Placar) obj;
		if (gols1 == null) {
			if (other.gols1 != null)
				return false;
		} else if (!gols1.equals(other.gols1))
			return false;
		if (gols2 == null) {
			if (other.gols2 != null)
				return false;
		} else if (!gols2.equals(other.gols2))
			return false;
		return true;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
}
