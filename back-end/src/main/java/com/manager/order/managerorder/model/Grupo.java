package com.manager.order.managerorder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Grupo extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3492463278294911796L;
	private String nome;
	private int qtTotalUser;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
	private List<Usuario> usuarios;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
	private List<Estoque> estoques;
	
	public int getQtTotalUser() {
		return qtTotalUser;
	}
	public void setQtTotalUser(int qtTotalUser) {
		this.qtTotalUser = qtTotalUser;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
