package com.manager.order.managerorder.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	private String tipoPedido;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataEntrega;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "estoque_id")
	private Estoque estoque;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<PedidoProduto> pedidoproduto;
	
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
	public String getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	
	public Estoque getEstoque() {
		return this.estoque;
	}
}
