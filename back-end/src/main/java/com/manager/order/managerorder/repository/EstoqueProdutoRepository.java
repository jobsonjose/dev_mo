package com.manager.order.managerorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manager.order.managerorder.model.EstoqueProduto;


public interface EstoqueProdutoRepository extends CrudRepository<EstoqueProduto, Long>{
	
	@Query("SELECT ep FROM EstoqueProduto ep WHERE produto_id = ?1")
	public EstoqueProduto findByIdProduct(Long id);
	
	@Query(value = "SELECT * FROM estoque_produto WHERE estoque_id = ?1", nativeQuery = true)
	public List<EstoqueProduto> findAllByIdEstoque(Long id);
	
}
