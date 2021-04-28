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

import com.manager.order.managerorder.model.Produto;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idCategoria}/{idEstoque}/{idUsuario}", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Produto produto, @PathVariable("idCategoria") Long idCategoria,
			@PathVariable("idEstoque") Long idEstoque,
			@PathVariable("idUsuario") Long idUsuario){
		return new ResponseEntity<>(service.save(produto, idEstoque, idCategoria, idUsuario), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{idProduto}/{idCategoria}/{idEstoque}/{idUsuario}", method=RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Produto produto, @PathVariable("idProduto") Long idProduto,
			@PathVariable("idCategoria") Long idCategoria,
			@PathVariable("idEstoque") Long idEstoque,
			@PathVariable("idUsuario") Long idUsuario){
		return new ResponseEntity<>(service.update(produto, idProduto, idEstoque, idCategoria, idUsuario), HttpStatus.OK);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
}
