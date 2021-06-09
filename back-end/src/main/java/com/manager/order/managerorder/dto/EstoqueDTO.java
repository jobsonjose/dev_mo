package com.manager.order.managerorder.dto;

public class EstoqueDTO {
	private Long idEstoque;
	private String nome;
	private int totalProduto;
	private Long idGrupo;
	
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
	public int getTotalProduto() {
		return totalProduto;
	}
	public void setTotalProduto(int totalProduto) {
		this.totalProduto = totalProduto;
	}
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	
}
