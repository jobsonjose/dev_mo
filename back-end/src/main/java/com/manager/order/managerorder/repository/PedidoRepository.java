package com.manager.order.managerorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manager.order.managerorder.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{
	
	@Query("SELECT p FROM Pedido p WHERE usuario_id = ?1")
	public List<Pedido> listPedidoUsuario(Long idUsuario);
}
