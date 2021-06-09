package com.manager.order.managerorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manager.order.managerorder.model.PedidoProduto;

public interface PedidoProdutoRepository extends CrudRepository<PedidoProduto, Long>{
	
	@Query("SELECT pp FROM PedidoProduto pp WHERE pedido_id = ?1")
	public List<PedidoProduto> findByIdPedido(Long idPedido);
}
