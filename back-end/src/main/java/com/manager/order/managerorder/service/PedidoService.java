package com.manager.order.managerorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.dto.PedidoIntoDTO;
import com.manager.order.managerorder.dto.PedidoProdutoDTO;
import com.manager.order.managerorder.dto.PedidoProdutoListDTO;
import com.manager.order.managerorder.dto.ProdutoPedidoIntoDTO;
import com.manager.order.managerorder.model.Estoque;
import com.manager.order.managerorder.model.EstoqueProduto;
import com.manager.order.managerorder.model.Pedido;
import com.manager.order.managerorder.model.PedidoProduto;
import com.manager.order.managerorder.model.Produto;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.EstoqueProdutoRepository;
import com.manager.order.managerorder.repository.EstoqueRepository;
import com.manager.order.managerorder.repository.PedidoProdutoRepository;
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
	
	@Autowired
	private EstoqueRepository estoqueDAO;
	
	@Autowired
	private EstoqueProdutoRepository epDAO;
	
	@Autowired
	private PedidoProdutoRepository pedidoProdutoDAO;
	
	public Iterable<Pedido> findAll(){
		return pedidoDAO.findAll();
	}
	
	public Pedido findById(Long id) {
		return pedidoDAO.findById(id).get();
	}
	
	public Pedido save(PedidoIntoDTO pedido, Long idUsuario) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		
		Pedido pedidoDAODB = new Pedido();
		pedidoDAODB.setNome(pedido.getTitulo());
		pedidoDAODB.setDescricao(pedido.getDescricao());
		pedidoDAODB.setTipoPedido(pedido.getTipoPedido());
		pedidoDAODB.setDataInicial(pedido.getDataCriacao());
		pedidoDAODB.setDataEntrega(pedido.getDataEntrega());
		pedidoDAODB.setUsuario(usuario);
		Pedido pedidoSave = pedidoDAO.save(pedidoDAODB);
		
		for(ProdutoPedidoIntoDTO prdPedidoDTO : pedido.getListproduto()) {
			PedidoProduto pp = new PedidoProduto();
			Produto produto = produtoDAO.findById(prdPedidoDTO.getIdproduto()).get();
			pp.setQuantidade(prdPedidoDTO.getQuantidade());
			pp.setProduto(produto);
			pp.setPedido(pedidoSave);
			EstoqueProduto produtoPedidoEstoque =  epDAO.findByIdProduct(pp.getProduto().getId());
			if(pedidoSave.getTipoPedido().equals("ENTRADA")) {
				produtoPedidoEstoque.setQuantidade(produtoPedidoEstoque.getQuantidade() + prdPedidoDTO.getQuantidade());
				produto.setQuantidade(produto.getQuantidade() + prdPedidoDTO.getQuantidade());
			}else {
				produtoPedidoEstoque.setQuantidade(produtoPedidoEstoque.getQuantidade() - prdPedidoDTO.getQuantidade());
				produto.setQuantidade(produto.getQuantidade() - prdPedidoDTO.getQuantidade());
			}
			
			
			produtoDAO.save(produto);
			epDAO.save(produtoPedidoEstoque);
			pedidoProdutoDAO.save(pp);
		}
		
		
		return pedidoSave;
	}
	
	public Pedido update(Pedido pedido, Long idPedido, Long idUsuario, Long idProduto) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		Produto produto = produtoDAO.findById(idProduto).get();
		Pedido ped = pedidoDAO.findById(idPedido).get();
		
		
		ped.setUsuario(usuario);
		ped.setDataEntrega(pedido.getDataEntrega());
		ped.setDataInicial(pedido.getDataInicial());
		ped.setDescricao(pedido.getDescricao());
		ped.setNome(pedido.getNome());
		
		return pedidoDAO.save(ped);
	}
	
	public List<PedidoProdutoListDTO> listProdutoPedido(Long idUsuario) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		List<Pedido> listPedido = pedidoDAO.listPedidoUsuario(usuario.getId());
		List<PedidoProdutoListDTO> listPedidoDTO = new ArrayList<PedidoProdutoListDTO>();
		for(Pedido pd : listPedido) {
			PedidoProdutoListDTO  pplDTO = new PedidoProdutoListDTO();
			pplDTO.setTitulo(pd.getNome());
			pplDTO.setDescricao(pd.getDescricao());
			pplDTO.setTipoPedido(pd.getTipoPedido());
			pplDTO.setDataInicial(new Date());
			
			List<PedidoProdutoDTO> pedidoProdutoDTO = new ArrayList<PedidoProdutoDTO>();
			List<PedidoProduto> pedidosProdutos = pedidoProdutoDAO.findByIdPedido(pd.getId());
			for(PedidoProduto pp : pedidosProdutos) {
				PedidoProdutoDTO ppDTO = new PedidoProdutoDTO();
				ppDTO.setNome(pp.getProduto().getNome());
				ppDTO.setQuantidade(pp.getQuantidade());
				ppDTO.setValor(pp.getProduto().getValor());
				
				pedidoProdutoDTO.add(ppDTO);
			}
			
			pplDTO.setListproduto(pedidoProdutoDTO);
			
			listPedidoDTO.add(pplDTO);
		}
		
		return listPedidoDTO;
	}
}
