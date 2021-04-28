package com.manager.order.managerorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.model.Pedido;
import com.manager.order.managerorder.model.Produto;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.PedidoRepository;
import com.manager.order.managerorder.repository.ProdutoRepository;
import com.manager.order.managerorder.repository.UsuarioRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoDAO;
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	private ProdutoRepository produtoDAO;
	
	public Iterable<Pedido> findAll(){
		return pedidoDAO.findAll();
	}
	
	public Pedido findById(Long id) {
		return pedidoDAO.findById(id).get();
	}
	
	public Pedido save(Pedido pedido, Long idUsuario, Long idProduto) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		Produto produto = produtoDAO.findById(idProduto).get();
		produto.getPedidos().add(pedido);
		pedido.getProduto().add(produto);
		
		pedido.setUsuario(usuario);
		
		return pedidoDAO.save(pedido);
	}
	
	public Pedido update(Pedido pedido, Long idPedido, Long idUsuario, Long idProduto) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		Produto produto = produtoDAO.findById(idProduto).get();
		Pedido ped = pedidoDAO.findById(idPedido).get();
		
		produto.getPedidos().add(ped);
		ped.getProduto().add(produto);
		
		ped.setUsuario(usuario);
		ped.setDataEntrega(pedido.getDataEntrega());
		ped.setDataInicial(pedido.getDataInicial());
		ped.setDescricao(pedido.getDescricao());
		ped.setNome(pedido.getNome());
		
		return pedidoDAO.save(ped);
	}
}
