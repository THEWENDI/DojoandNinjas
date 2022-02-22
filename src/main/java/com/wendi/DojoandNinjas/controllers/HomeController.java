package com.wendi.DojoandNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wendi.DojoandNinjas.models.Dojo;
import com.wendi.DojoandNinjas.models.Ninja;
import com.wendi.DojoandNinjas.services.mainService;

@Controller
public class HomeController {
	
	@Autowired
	private mainService mainservice;
	
	@GetMapping("/dojo/new")
	public String createDojoForm(@ModelAttribute("dojo")Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojo/new")
	public String processDojoForm(
			@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}else {
			mainservice.saveDojo(dojo);
			return"redirect:/dojo/new";
		}
	}
	
	@GetMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = mainservice.allDojos();
		model.addAttribute("dojos", dojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninja/new")
	public String processNinjaForm(
			@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = mainservice.allDojos();
			model.addAttribute("dojos", dojos);
			return "newninja.jsp";
		}else {
			mainservice.saveNinja(ninja);
			return"redirect:/ninja/new";
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showOneDojo(@PathVariable("dojoId")Long dojoId, Model model) {
		Dojo dojo = mainservice.oneDojo(dojoId);
		model.addAttribute("dojo", dojo);
		return "showonedojo.jsp";
	}
	
	
	
}
