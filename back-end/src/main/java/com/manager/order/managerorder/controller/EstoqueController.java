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
	
	@GetMapping(path = "/listgroup/{idUsuario}")
	public ResponseEntity<?> findAllGroup(@PathVariable("idUsuario") Long idUsuario){
		return new ResponseEntity<>(service.findAll(idUsuario), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save/{idUsuario}", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Estoque estoque, @PathVariable("idUsuario") Long idUsuario){
		return new ResponseEntity<>(service.save(estoque, idUsuario), HttpStatus.OK);
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
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/estoqueproduto/{id}")
	public ResponseEntity<?> findAllEP(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findEstoqueWithProduto(id), HttpStatus.OK);
	}
}
