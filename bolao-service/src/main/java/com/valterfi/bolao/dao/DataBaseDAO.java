package com.valterfi.bolao.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valterfi.bolao.database.Database;
import com.valterfi.bolao.domain.Simulacao;

@Repository
public class DataBaseDAO {
	
	@Autowired
	private Database database;
	
	public Simulacao add(Simulacao simulacao) {
		
		Map<Integer, Simulacao> datas = database.getData();
		if(datas.isEmpty()) {
			datas.put(1, simulacao);
		} else {
			datas.put(datas.size()+1, simulacao);
		}
		
		return simulacao;
	}
	
	public Simulacao get(Integer id) {
		return database.getData().get(id);
	}

}
