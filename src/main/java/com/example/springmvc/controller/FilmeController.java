package com.example.springmvc.controller;

import com.example.springmvc.model.Filme;
import com.example.springmvc.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FilmeController {

	@Autowired
	FilmeRepository filmeRep;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("filmes", filmeRep.findAll());
		return "index";
	}
	
	@GetMapping("/adicionar")
	public String filmeFormCadastro(Model model) {
		model.addAttribute("filme", new Filme());
		model.addAttribute("tipo", "cadastrar");
		return "form";
	}
	
	@GetMapping("/detalhes/{id}")
	public String detalhesFilme(@PathVariable(value="id") Integer id, Model model) {
		model.addAttribute("filme", filmeRep.findOne(id));
		return "filme-detalhes";
	}
	
	@GetMapping("/editar/{id}")
	public String filmeFormEdicao(Model model, @PathVariable(value="id") Integer id) {
		model.addAttribute("filme", filmeRep.findOne(id));
		model.addAttribute("tipo", "editar");
		return "form";
	}
	
	@PostMapping("/salvar")
	public String salvaFilme(Filme filme) {
		filmeRep.save(filme);
		return "redirect:/";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletaFilme(@PathVariable(value="id") Integer id) {
		filmeRep.delete(id);
		return "redirect:/";
	}
	
	
	
}
