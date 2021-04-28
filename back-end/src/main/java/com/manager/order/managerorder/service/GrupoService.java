package com.manager.order.managerorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.model.Grupo;
import com.manager.order.managerorder.repository.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoRepository grupoDAO;
	
	public Iterable<Grupo> findAll(){
		return grupoDAO.findAll();
	}
	
	public Grupo findById(Long id) {
		return grupoDAO.findById(id).get();
	}
	
	public Grupo save(Grupo grupo) {
		return grupoDAO.save(grupo);
	}
	
	public Grupo update(Grupo grupo, Long idGrupo) {
		Grupo gru = grupoDAO.findById(idGrupo).get();
		gru.setNome(grupo.getNome());
		gru.setQtTotalUser(grupo.getQtTotalUser());
		
		return grupoDAO.save(gru);
	}
}
