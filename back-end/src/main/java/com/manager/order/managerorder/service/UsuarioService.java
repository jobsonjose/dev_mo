package com.manager.order.managerorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.dto.UsuarioDTO;
import com.manager.order.managerorder.model.Grupo;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.GrupoRepository;
import com.manager.order.managerorder.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	private GrupoRepository grupoDAO;
	
	public Usuario save(Usuario usuario, Long idGrupo) {
		Grupo grupo = grupoDAO.findById(idGrupo).get();
		usuario.setGrupo(grupo);
		
		return usuarioDAO.save(usuario);
	}
	
	public Usuario update(Usuario usuario, Long idUsuario, Long idGrupo) {
		Usuario usu = usuarioDAO.findById(idUsuario).get();
		Grupo grupo = grupoDAO.findById(idGrupo).get();
		
		usu.setCpf(usuario.getCpf());
		usu.setEmail(usuario.getEmail());
		usu.setGrupo(grupo);
		usu.setNome(usuario.getNome());
		usu.setSenha(usuario.getSenha());
		
		return usuarioDAO.save(usu);
	}
	
	public UsuarioDTO login(String email, String senha) {
		Usuario usu = usuarioDAO.login(email, senha);
		UsuarioDTO usuDTO = new UsuarioDTO();
		usuDTO.setId(usu.getId());
		usuDTO.setNome(usu.getNome());
		usuDTO.setCpf(usu.getCpf());
		usuDTO.setEmail(usu.getEmail());
		usuDTO.setIdGrupo(usu.getGrupo().getId());
		
		return usuDTO;
	}
	
	public Iterable<Usuario> findAll(){
		return usuarioDAO.findAll();
	}
	
	public Usuario findById(Long id) {
		return usuarioDAO.findById(id).get();
	}
}
