package com.manager.order.managerorder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.dto.ProdutoDTO;
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
	
	public ProdutoDTO findById(Long id) {
		Produto prod = produtoDAO.findById(id).get();
		ProdutoDTO prodDTO = new ProdutoDTO();
		prodDTO.setId(prod.getId());
		prodDTO.setNome(prod.getNome());
		prodDTO.setDescricao(prod.getDescricao());
		prodDTO.setValor(prod.getValor());
		prodDTO.setQuantidade(prod.getQuantidade());
		prodDTO.setIdUsuario(prod.getUsuario().getId());
		prodDTO.setIdCategoria(prod.getCategoria().getId());
		prodDTO.setIdEstoque(prod.getEstoque().getId());
		
		return prodDTO;
	}
	
	public List<ProdutoDTO> findAll(){
		Iterable<Produto> listProduto = produtoDAO.findAll();
		List<ProdutoDTO> listProdutoDTO = new ArrayList<ProdutoDTO>();
		
		for(Produto prod : listProduto) {
			ProdutoDTO prodDTO = new ProdutoDTO();
			prodDTO.setId(prod.getId());
			prodDTO.setNome(prod.getNome());
			prodDTO.setDescricao(prod.getDescricao());
			prodDTO.setValor(prod.getValor());
			prodDTO.setIdUsuario(prod.getUsuario().getId());
			prodDTO.setIdCategoria(prod.getCategoria().getId());
			prodDTO.setIdEstoque(prod.getEstoque().getId());
			
			listProdutoDTO.add(prodDTO);
		}
		return listProdutoDTO;
	}
	
	public Produto delete(Long id) {
		Produto produto = produtoDAO.findById(id).get();
		produtoDAO.delete(produto);
		
		return produto;
	}
}
