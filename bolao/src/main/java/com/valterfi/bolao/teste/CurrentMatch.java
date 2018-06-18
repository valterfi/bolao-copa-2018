package com.valterfi.bolao.teste;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.json.Example;

public class CurrentMatch {
	
	public static void main(String[] args) {
		
		CurrentMatch currentMatch = new CurrentMatch();
		Placar placar = currentMatch.getPlacar();
		System.out.println(placar);
	}

	public Placar getPlacar() {

		HttpURLConnection connection = null;
		BufferedReader reader = null;
		String json = null;
		try {
			URL resetEndpoint = new URL("http://worldcup.sfg.io/matches/current");
			connection = (HttpURLConnection) resetEndpoint.openConnection();
			// Set request method to GET as required from the API
			connection.setRequestMethod("GET");

			// Read the response
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				jsonSb.append(line);
			}
			json = jsonSb.toString();
			
			if(StringUtils.isNoneEmpty(json)) {
				// Converts JSON string to Java object
				ObjectMapper mapper = new ObjectMapper();
				// Converts to an array of Book
				Example[] examples = mapper.readValue(json, Example[].class);
				if(examples.length == 1) {
					Example resultadoAtual = examples[0];
					String time1 = resultadoAtual.getHomeTeam().getCountry();
					String time2 = resultadoAtual.getAwayTeam().getCountry();
					Integer gols1 = resultadoAtual.getHomeTeam().getGoals();
					Integer gols2 = resultadoAtual.getAwayTeam().getGoals();
					return new Placar(time1, time2, gols1, gols2);
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
