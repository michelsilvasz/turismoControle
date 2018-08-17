package com.michelalves.turismoControle.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.michelalves.turismoControle.domain.Passageiro;
import com.michelalves.turismoControle.services.PassageiroService;

@RestController
@RequestMapping(value="/passageiros")
public class PassageiroResource {
	
	@Autowired
	private PassageiroService service;
	
	@RequestMapping(value ="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Passageiro obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
