package com.manager.order.managerorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manager.order.managerorder.model.Estoque;
import com.manager.order.managerorder.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idGrupo}", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Estoque estoque, @PathVariable("idGrupo") Long idGrupo){
		return new ResponseEntity<>(service.save(estoque, idGrupo), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{idEstoque}/{idGrupo}", method=RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Estoque estoque, @PathVariable("idEstoque") Long idEstoque,
			@PathVariable("idGrupo") Long idGrupo){
		return new ResponseEntity<>(service.update(estoque, idEstoque, idGrupo), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findId(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
}
