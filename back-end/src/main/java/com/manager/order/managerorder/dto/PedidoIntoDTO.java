package com.manager.order.managerorder.dto;

import java.util.Date;
import java.util.List;

public class PedidoIntoDTO {
	private String titulo;
	private String descricao;
	private String tipoPedido;
	private Date dataCriacao;
	private Date dataEntrega;
	private Long usuario_id;
	private Long estoque_id;
	private List<ProdutoPedidoIntoDTO> listproduto;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public Long getEstoque_id() {
		return estoque_id;
	}
	public void setEstoque_id(Long estoque_id) {
		this.estoque_id = estoque_id;
	}
	public String getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	public List<ProdutoPedidoIntoDTO> getListproduto() {
		return listproduto;
	}
	public void setListproduto(List<ProdutoPedidoIntoDTO> listproduto) {
		this.listproduto = listproduto;
	}
	
}
