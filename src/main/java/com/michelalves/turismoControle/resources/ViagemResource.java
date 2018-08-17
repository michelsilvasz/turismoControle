package com.michelalves.turismoControle.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.michelalves.turismoControle.domain.Viagem;
import com.michelalves.turismoControle.services.ViagemService;

@RestController
@RequestMapping(value="/viagens")
public class ViagemResource {
	
	@Autowired
	private ViagemService service;
	
	@RequestMapping(value ="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Viagem obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
