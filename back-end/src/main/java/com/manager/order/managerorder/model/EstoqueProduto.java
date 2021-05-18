package com.manager.order.managerorder.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class EstoqueProduto extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1596029063446248346L;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "estoque_id")
	private Estoque estoque;
	
	private int quantidade;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataCriacao;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dataModificacao;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
