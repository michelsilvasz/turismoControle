package com.michelalves.turismoControle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelalves.turismoControle.domain.Passageiro;
import com.michelalves.turismoControle.repositories.PassageiroRepository;

@Service
public class PassageiroService {
	
	@Autowired
	private PassageiroRepository repo;
	
	public Passageiro buscar(Integer id) {
		Passageiro obj = repo.findOne(id);
		return obj;
	}
	
}
