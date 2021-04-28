package com.manager.order.managerorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.model.Categoria;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.CategoriaRepository;
import com.manager.order.managerorder.repository.UsuarioRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaDAO;
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	public Iterable<Categoria> findAll(){
		return categoriaDAO.findAll();
	}
	
	public Categoria findById(Long id) {
		return categoriaDAO.findById(id).get();
	}
	
	public Categoria save(Categoria categoria, Long idUsuario) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		categoria.setUsuario(usuario);
		
		return categoriaDAO.save(categoria);
	}
	
	public Categoria update(Categoria categoria, Long idCategoria, Long idUsuario) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		Categoria categ = categoriaDAO.findById(idCategoria).get();
		
		categ.setNome(categoria.getNome());
		categ.setDescricao(categoria.getDescricao());
		categ.setUsuario(usuario);
		
		return categoriaDAO.save(categ);
	}
}
