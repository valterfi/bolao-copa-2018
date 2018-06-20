package com.valterfi.bolao.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;

import com.valterfi.bolao.domain.Classificacao;

@Service
public class MaisBolao {
	
	public List<Classificacao> retornarClassificacao() {
		 
		List<Classificacao> classificacaoList = new ArrayList<Classificacao>();
		
		List<HashMap<String, WebElement>> table = pegarTableSite();
		if(table != null) {
			
			for(int i=1; i <= table.size()-1; i++) {
			
				String nome = table.get(i).get("Nome").getText();
				int total = Integer.valueOf(table.get(i).get("Total").getAttribute("innerText"));
				int acertouPlacar = Integer.valueOf(table.get(i).get("AP").getAttribute("innerText"));
				int golsVencedor = Integer.valueOf(table.get(i).get("GV").getAttribute("innerText"));
				int saldoGols = Integer.valueOf(table.get(i).get("SG").getAttribute("innerText"));
				int golsPerdedor = Integer.valueOf(table.get(i).get("GP").getAttribute("innerText"));
				int acertouVencedor = Integer.valueOf(table.get(i).get("AV").getAttribute("innerText"));
				int empateGarantido = Integer.valueOf(table.get(i).get("EG").getAttribute("innerText"));
				
				Classificacao classificacao = new Classificacao(nome, total, acertouPlacar, golsVencedor, saldoGols, golsPerdedor, acertouVencedor, empateGarantido);
				classificacaoList.add(classificacao);
				
			}
			
		}
		
		return classificacaoList;
	}

	private List<HashMap<String, WebElement>> pegarTableSite() {

		WebDriver webDriver = null;

		// LINUX
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);

		caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] { "--web-security=false",
				"--ssl-protocol=any", "--ignore-ssl-errors=true", "--webdriver-loglevel=INFO" });

		PhantomJSDriverService service = new PhantomJSDriverService.Builder().usingPort(8080)
				.usingPhantomJSExecutable(new File("src/main/resources/phantomjs")).build();
		webDriver = new PhantomJSDriver(service, caps);
		
		// LINUX
		//File file = new File("src/main/resources/phantomjs");				
        //System.setProperty("phantomjs.binary.path", file.getAbsolutePath());	
		//webDriver = new PhantomJSDriver(caps);
		
		// WINDOWS
		/*File file = new File("src/main/resources/phantomjs-2.1.1-windows/bin/phantomjs.exe");				
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
        webDriver = new PhantomJSDriver();	*/

		webDriver.navigate().to("http://www.maisbolao.com.br/bolao/classificacao/15582/copa-dos-caldeiras");
		
		try {

		WebElement tableElement = webDriver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[3]/table"));
		System.out.println(tableElement);

		ArrayList<HashMap<String, WebElement>> table = new ArrayList<HashMap<String, WebElement>>();
		ArrayList<WebElement> rowElements = (ArrayList<WebElement>) tableElement.findElements(By.xpath(".//tr"));

		// get column names of table from table headers
		ArrayList<String> columnNames = new ArrayList<String>();
		ArrayList<WebElement> headerElements = (ArrayList<WebElement>) rowElements.get(0).findElements(By.xpath(".//th"));
		for (WebElement headerElement : headerElements) {
			columnNames.add(retornaNomeColuna(headerElement));
		}

		// iterate through all rows and add their content to table array
		for (WebElement rowElement : rowElements) {
			HashMap<String, WebElement> row = new HashMap<String, WebElement>();

			// add table cells to current row
			int columnIndex = 0;
			ArrayList<WebElement> cellElements = (ArrayList<WebElement>) rowElement.findElements(By.xpath(".//td"));
			for (WebElement cellElement : cellElements) {
				row.put(columnNames.get(columnIndex), cellElement);
				columnIndex++;
			}

			table.add(row);

		}
		
		return table;
		
		
		} catch (Exception e) {
			return null;
		}

	}
	
	private String retornaNomeColuna(WebElement headerElement) {
		return headerElement.getAttribute("innerText");
	}

}
