package com.valterfi.bolao.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.valterfi.bolao.dao.DataBaseDAO;
import com.valterfi.bolao.domain.Jogador;
import com.valterfi.bolao.domain.Placar;
import com.valterfi.bolao.domain.Simulacao;
import com.valterfi.bolao.domain.SimulacaoForm;
import com.valterfi.bolao.domain.util.JogadorUtil;

@Controller
@SessionAttributes("simulacao")
public class BolaoController {
	
	@Autowired
	private DataBaseDAO dataBaseDAO;
	
	@ModelAttribute
    public Simulacao simulacao() {
        return new Simulacao(1, Placar.palpitar(null, null), JogadorUtil.criarJogadores());
    }
	
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@ModelAttribute Simulacao simulacao, Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	model.addAttribute("simulacao", simulacao);
        model.addAttribute("name", name);
        return "hello";
    }
    
    @PostMapping("/form")
    public String formPost(@ModelAttribute Simulacao simulacao, @Valid SimulacaoForm simulacaoForm, BindingResult bindingResult, Model model) {
        
        List<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador1(), Placar.palpitar(simulacaoForm.getJogador1Gols1(), simulacaoForm.getJogador1Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador2(), Placar.palpitar(simulacaoForm.getJogador2Gols1(), simulacaoForm.getJogador2Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador3(), Placar.palpitar(simulacaoForm.getJogador3Gols1(), simulacaoForm.getJogador3Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador4(), Placar.palpitar(simulacaoForm.getJogador4Gols1(), simulacaoForm.getJogador4Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador5(), Placar.palpitar(simulacaoForm.getJogador5Gols1(), simulacaoForm.getJogador5Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador6(), Placar.palpitar(simulacaoForm.getJogador6Gols1(), simulacaoForm.getJogador6Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador7(), Placar.palpitar(simulacaoForm.getJogador7Gols1(), simulacaoForm.getJogador7Gols2())));
        jogadores.add(new Jogador(simulacaoForm.getNomeJogador8(), Placar.palpitar(simulacaoForm.getJogador8Gols1(), simulacaoForm.getJogador8Gols2())));
        
        simulacao.setJogadores(jogadores);
        //simulacao.setCorreto(correto);
        simulacao.setPeso(simulacaoForm.getPeso());
        
        model.addAttribute("simulacao", simulacao);
        
        dataBaseDAO.add(simulacao);
        
        return "hello";
    }
}