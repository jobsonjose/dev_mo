package com.manager.order.managerorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manager.order.managerorder.model.Categoria;
import com.manager.order.managerorder.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Categoria categoria){
		return new ResponseEntity<>(service.save(categoria), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{idCategoria}/{idUsuario}", method=RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable("idCategoria") Long idCategoria,
			@PathVariable("idUsuario") Long idUsuario){
		return new ResponseEntity<>(service.update(categoria, idCategoria, idUsuario), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
}
