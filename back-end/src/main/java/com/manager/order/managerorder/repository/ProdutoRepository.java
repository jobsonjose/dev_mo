package com.manager.order.managerorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manager.order.managerorder.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	@Query("SELECT p FROM Produto p WHERE estoque_id = ?1")
	public List<Produto> findAllProduto(Long idEstoque);
}
