package com.wendi.DojoandNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendi.DojoandNinjas.models.Dojo;
import com.wendi.DojoandNinjas.models.Ninja;
import com.wendi.DojoandNinjas.repositories.DojoRepository;
import com.wendi.DojoandNinjas.repositories.NinjaRepository;

@Service
public class mainService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// Create dojo
	public Dojo saveDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	// Create ninja
	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//find all dojo
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	//find all ninja
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	//find one dojo
	public Dojo oneDojo(Long dojoId) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(dojoId);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
	
	
	
	
	
}
