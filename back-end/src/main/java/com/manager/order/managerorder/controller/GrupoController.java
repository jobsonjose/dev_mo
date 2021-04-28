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

import com.manager.order.managerorder.model.Grupo;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.service.GrupoService;

@RestController
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	private GrupoService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Grupo grupo){
		return new ResponseEntity<>(service.save(grupo), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{idGrupo}", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Grupo grupo, @PathVariable("idGrupo") Long idGrupo){
		return new ResponseEntity<>(service.update(grupo, idGrupo), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findId(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
}
