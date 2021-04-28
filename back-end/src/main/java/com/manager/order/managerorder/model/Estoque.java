package com.manager.order.managerorder.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Estoque extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3119154252447361125L;
	
	private String nome;
	@ManyToOne
	private Grupo grupo;
	
	private int totalProduto;
	
	@OneToMany
	private List<Produto> produtos;
	
	public String getNome() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	public int getTotalProduto() {
		return totalProduto;
	}
	public void setTotalProduto(int totalProduto) {
		this.totalProduto = totalProduto;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
