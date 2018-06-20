package com.valterfi.bolao.domain;

import java.util.ArrayList;
import java.util.List;

public class ClassificacaoJson {
	
	private List<Classificacao> data = new ArrayList<>();

	public ClassificacaoJson(List<Classificacao> data) {
		this.data = data;
	}

	public List<Classificacao> getData() {
		return data;
	}

	public void setData(List<Classificacao> data) {
		this.data = data;
	}
	
	

}
