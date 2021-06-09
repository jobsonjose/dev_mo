package com.manager.order.managerorder.dto;

import java.util.List;

public class EstoqueProdutoListDTO {
	private Long idEstoque;
	private String nome;
	private int	total_produtos;
	private Long grupo;
	private List<EstoqueProdutoDTO> listEstoqueProduto;
	
	public Long getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTotal_produtos() {
		return total_produtos;
	}
	public void setTotal_produtos(int total_produtos) {
		this.total_produtos = total_produtos;
	}
	public Long getGrupo() {
		return grupo;
	}
	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}
	public List<EstoqueProdutoDTO> getListEstoqueProduto() {
		return listEstoqueProduto;
	}
	public void setListEstoqueProduto(List<EstoqueProdutoDTO> listEstoqueProduto) {
		this.listEstoqueProduto = listEstoqueProduto;
	}
	
}
