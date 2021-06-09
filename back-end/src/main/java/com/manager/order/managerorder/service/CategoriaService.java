package com.manager.order.managerorder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.dto.CategoriaDTO;
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
	
	public List<CategoriaDTO> findAll(){
		Iterable<Categoria> categorias = categoriaDAO.findAll();
		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();
		
		for(Categoria cat : categorias) {
			CategoriaDTO catDTO = new CategoriaDTO();
			catDTO.setNome(cat.getNome());
			catDTO.setDescricao(cat.getDescricao());
			catDTO.setId(cat.getId());
			categoriasDTO.add(catDTO);
		}
		return categoriasDTO;
	}
	
	public CategoriaDTO findById(Long id) {
		Categoria cat = categoriaDAO.findById(id).get(); 
		CategoriaDTO catDTO = new CategoriaDTO();
		
		catDTO.setId(cat.getId());
		catDTO.setNome(cat.getNome());
		catDTO.setDescricao(cat.getDescricao());
		
		return catDTO;
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaDAO.save(categoria);
	}
	
	public Categoria delete(Long id) {
		Categoria categoria = categoriaDAO.findById(id).get();
		categoriaDAO.delete(categoria);
		
		return categoria;
	}
	
	public Categoria update(Categoria categoria, Long idCategoria) {
		Categoria categ = categoriaDAO.findById(idCategoria).get();
		
		categ.setNome(categoria.getNome());
		categ.setDescricao(categoria.getDescricao());
		
		return categoriaDAO.save(categ);
	}
}
