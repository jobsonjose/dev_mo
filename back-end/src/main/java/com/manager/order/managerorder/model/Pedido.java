package com.manager.order.managerorder.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedido")
public class Pedido extends AbstractEntity{

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 7796016164400194438L;
	
	private String nome;
	private String descricao;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataInicial;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataEntrega;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "pedido_produto",
			joinColumns = { @JoinColumn(name = "pedido_id")},
			inverseJoinColumns = { @JoinColumn(name = "produto_id")})
	private Set<Produto> produto = new HashSet<>();
	
	public Set<Produto> getProduto() {
		return produto;
	}
	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
