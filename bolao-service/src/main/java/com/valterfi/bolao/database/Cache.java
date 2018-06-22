package com.valterfi.bolao.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.valterfi.bolao.domain.Classificacao;

@Scope(value = "singleton")
@Component
public class Cache implements Serializable {

	public static final String CLASSIFICACAO_LIST = "classificacaoList";

	/**
	 * 
	 */
	private static final long serialVersionUID = -7239426590028333215L;
	
	private Map<String, List<Classificacao>> classificacaoCache = new HashMap<String, List<Classificacao>>();
	
	public Cache() {
		classificacaoCache.put(CLASSIFICACAO_LIST, new ArrayList<Classificacao>());
	}

	public Map<String, List<Classificacao>> getClassificacaoCache() {
		return classificacaoCache;
	}

	public void setClassificacaoCache(Map<String, List<Classificacao>> classificacaoCache) {
		this.classificacaoCache = classificacaoCache;
	}

}
