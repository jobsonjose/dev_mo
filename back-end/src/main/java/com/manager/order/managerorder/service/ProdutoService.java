package com.manager.order.managerorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.model.Categoria;
import com.manager.order.managerorder.model.Estoque;
import com.manager.order.managerorder.model.Produto;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.CategoriaRepository;
import com.manager.order.managerorder.repository.EstoqueRepository;
import com.manager.order.managerorder.repository.ProdutoRepository;
import com.manager.order.managerorder.repository.UsuarioRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoDAO;
	
	@Autowired
	private EstoqueRepository estoqueDAO;
	
	@Autowired
	private CategoriaRepository categoriaDAO;
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	public Produto save(Produto produto, Long idEstoque, Long idCategoria, Long idUsuario) {
		Estoque estoque = estoqueDAO.findById(idEstoque).get();
		Categoria categoria = categoriaDAO.findById(idCategoria).get();
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		
		produto.setCategoria(categoria);
		produto.setEstoque(estoque);
		produto.setUsuario(usuario);
		
		return produtoDAO.save(produto);
	}
	
	public Produto update(Produto produto, Long idProduto, Long idEstoque, Long idCategoria, Long idUsuario) {
		Estoque estoque = estoqueDAO.findById(idEstoque).get();
		Categoria categoria = categoriaDAO.findById(idCategoria).get();
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		Produto prod = produtoDAO.findById(idProduto).get();
		
		prod.setNome(produto.getNome());
		prod.setValor(produto.getValor());
		prod.setDescricao(produto.getDescricao());
		prod.setCategoria(categoria);
		prod.setEstoque(estoque);
		prod.setUsuario(usuario);
		
		return produtoDAO.save(prod);
	}
	
	public Produto findById(Long id) {
		return produtoDAO.findById(id).get();
	}
	
	public Iterable<Produto> findAll(){
		return produtoDAO.findAll();
	}
}
