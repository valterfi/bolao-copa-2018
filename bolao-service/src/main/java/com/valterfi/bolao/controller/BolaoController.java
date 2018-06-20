package com.valterfi.bolao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.valterfi.bolao.dao.DataBaseDAO;
import com.valterfi.bolao.domain.Classificacao;
import com.valterfi.bolao.domain.ClassificacaoJson;
import com.valterfi.bolao.domain.Jogador;
import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Simulacao;
import com.valterfi.bolao.domain.SimulacaoForm;
import com.valterfi.bolao.domain.util.JogadorUtil;
import com.valterfi.bolao.domain.util.SimulacaoUtil;
import com.valterfi.bolao.service.BolaoService;

@Controller
@SessionAttributes("simulacao")
public class BolaoController {
	
	@Autowired
	private DataBaseDAO dataBaseDAO;
	
	@Autowired
	private BolaoService bolaoService;
	
	@ModelAttribute
    public Simulacao simulacao() {
        return new Simulacao(1, Placar.palpitar(null, null), JogadorUtil.criarJogadores());
    }
	
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/criar")
    public String criar(@ModelAttribute Simulacao simulacao, Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	model.addAttribute("simulacao", simulacao);
        model.addAttribute("name", name);
        return "criar";
    }
    
    @PostMapping("/form")
    public String formPost(@ModelAttribute Simulacao simulacao, @Valid SimulacaoForm simulacaoForm, BindingResult bindingResult, Model model) {
        model.addAttribute("simulacao", SimulacaoUtil.mapper(simulacaoForm, simulacao));
        Integer id = dataBaseDAO.add(simulacao);
        return "redirect:/simular/"+ id +"";
    }
    
    @GetMapping("/simular/{id}")
    public String simular(Model model, @PathVariable("id") Integer id) {
    	Simulacao simulacao = dataBaseDAO.get(id);
    	bolaoService.calcularPontos(simulacao);
     	model.addAttribute("simulacao", simulacao);
    	model.addAttribute("id", id);
        return "simular";
    }
    
    @GetMapping(path = "/classificacao/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ClassificacaoJson> getClassificacao(@PathVariable("id") Integer id) {
    	Simulacao simulacao = dataBaseDAO.get(id);
    	List<Classificacao> classificacaoList = bolaoService.retornaClassificacaoAtual(simulacao);
    	ClassificacaoJson json = new ClassificacaoJson(classificacaoList);
    	return new ResponseEntity<ClassificacaoJson>(json, HttpStatus.OK);
    }
}