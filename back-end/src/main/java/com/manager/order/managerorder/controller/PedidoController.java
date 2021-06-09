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

import com.manager.order.managerorder.dto.PedidoIntoDTO;
import com.manager.order.managerorder.model.Grupo;
import com.manager.order.managerorder.model.Pedido;
import com.manager.order.managerorder.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idUsuario}", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody PedidoIntoDTO pedido, @PathVariable("idUsuario") Long idUsuario){
		return new ResponseEntity<>(service.save(pedido, idUsuario), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{idPedido}/{idUsuario}/{idProduto}", method=RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable("idPedido") Long idPedido, @PathVariable("idUsuario") Long idUsuario,
			@PathVariable("idProduto") Long idProduto){
		return new ResponseEntity<>(service.update(pedido, idPedido, idUsuario, idProduto), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/{idUsuario}")
	public ResponseEntity<?> listProdutoPedido(@PathVariable("idUsuario") Long id){
		return new ResponseEntity<>(service.listProdutoPedido(id), HttpStatus.OK);
	}
}
