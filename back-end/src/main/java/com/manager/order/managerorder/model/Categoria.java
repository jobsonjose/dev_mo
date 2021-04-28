package com.manager.order.managerorder.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Categoria extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1009540926882140666L;
	
	private String nome;
	private String descricao;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany
	private List<Produto> produtos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
