package com.manager.order.managerorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.model.Estoque;
import com.manager.order.managerorder.model.Grupo;
import com.manager.order.managerorder.repository.EstoqueRepository;
import com.manager.order.managerorder.repository.GrupoRepository;


@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueDAO;
	
	@Autowired
	private GrupoRepository grupoDAO;
	
	public Iterable<Estoque> findAll(){
		return estoqueDAO.findAll();
	}
	
	public Estoque findById(Long id) {
		return estoqueDAO.findById(id).get();
	}
	
	public Estoque save(Estoque estoque, Long idGrupo) {
		Grupo grupo = grupoDAO.findById(idGrupo).get();
		estoque.setGrupo(grupo);
		
		return estoqueDAO.save(estoque);
	}
	
	public Estoque update(Estoque estoque, Long idEstoque,Long idGrupo) {
		Grupo grupo = grupoDAO.findById(idGrupo).get();
		Estoque est = estoqueDAO.findById(idGrupo).get();
		
		est.setName(estoque.getNome());
		est.setTotalProduto(estoque.getTotalProduto());
		est.setGrupo(grupo);
		
		return estoqueDAO.save(est);
	}

}
