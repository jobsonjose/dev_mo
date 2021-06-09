package com.manager.order.managerorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manager.order.managerorder.model.Estoque;

public interface EstoqueRepository extends CrudRepository<Estoque, Long>{
	
	@Query("SELECT e FROM Estoque e WHERE grupo_id = ?1")
	public List<Estoque> findListGroup(Long idGrupo);
}
