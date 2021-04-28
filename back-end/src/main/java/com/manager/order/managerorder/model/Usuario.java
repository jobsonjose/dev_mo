package com.manager.order.managerorder.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6667743795864490143L;
	
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	@ManyToOne
	private Grupo grupo;
	
	@OneToMany
	private List<Produto> produtos;
	
	@OneToMany
	private List<Categoria> categorias;
	
	@OneToMany
	private List<Pedido> pedidos;
	
	public List<Pedido> getUsuarios() {
		return pedidos;
	}
	public void setUsuarios(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
}
