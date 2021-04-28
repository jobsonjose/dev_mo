package com.manager.order.managerorder.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.manager.order.managerorder.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
	public Usuario login(String email, String senha);
}
