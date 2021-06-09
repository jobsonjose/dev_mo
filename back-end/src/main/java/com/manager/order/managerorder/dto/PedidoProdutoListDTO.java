package com.manager.order.managerorder.dto;

import java.util.Date;
import java.util.List;

public class PedidoProdutoListDTO {
	private String titulo;
	private String descricao;
	private String tipoPedido;
	private Date dataInicial;
	private List<PedidoProdutoDTO> listproduto;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
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
	public List<PedidoProdutoDTO> getListproduto() {
		return listproduto;
	}
	public void setListproduto(List<PedidoProdutoDTO> listproduto) {
		this.listproduto = listproduto;
	}
	
	
}
