package com.manager.order.managerorder.controller;

import java.util.Optional;

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

import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.UsuarioRepository;
import com.manager.order.managerorder.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(path = "/")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{idGrupo}", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Usuario usuario, @PathVariable("idGrupo") Long idGrupo){
		return new ResponseEntity<>(service.save(usuario, idGrupo), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{idUsuario}/{idGrupo}", method=RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable("idUsuario") Long idUsuario, @PathVariable("idGrupo") Long idGrupo){
		return new ResponseEntity<>(service.update(usuario, idUsuario, idGrupo), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{email}/{senha}")
	public ResponseEntity<?> findLogin(@PathVariable("email") String email, @PathVariable("senha") String senha){
		return new ResponseEntity<>(service.login(email, senha), HttpStatus.OK);
	}
}
