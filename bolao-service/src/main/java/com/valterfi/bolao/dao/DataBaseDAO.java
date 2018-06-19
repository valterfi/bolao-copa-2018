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
	
	public Integer add(Simulacao simulacao) {
		
		Integer id = null;
		Map<Integer, Simulacao> datas = database.getData();
		if(datas.isEmpty()) {
			id = 1;
			datas.put(id, simulacao);
		} else {
			id = datas.size()+1;
			datas.put(id, simulacao);
		}
		
		return id;
	}
	
	public Simulacao get(Integer id) {
		return database.getData().get(id);
	}

}
