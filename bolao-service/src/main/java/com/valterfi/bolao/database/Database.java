package com.valterfi.bolao.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.valterfi.bolao.domain.Simulacao;

@Scope(value = "singleton")
@Component
public class Database implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3233157779258993078L;
	
	private Map<Integer, Simulacao> data = new HashMap<Integer, Simulacao>();

	public Map<Integer, Simulacao> getData() {
		return data;
	}

	public void setData(Map<Integer, Simulacao> data) {
		this.data = data;
	}

}
