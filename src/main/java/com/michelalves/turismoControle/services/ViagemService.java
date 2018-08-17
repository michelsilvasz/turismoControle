package com.michelalves.turismoControle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelalves.turismoControle.domain.Viagem;
import com.michelalves.turismoControle.repositories.ViagemRepository;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository repo;
	
	public Viagem buscar(Integer id) {
		Viagem obj = repo.findOne(id);
		return obj;
	}
}
