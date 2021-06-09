package com.manager.order.managerorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.order.managerorder.dto.EstoqueDTO;
import com.manager.order.managerorder.dto.EstoqueProdutoDTO;
import com.manager.order.managerorder.dto.EstoqueProdutoListDTO;
import com.manager.order.managerorder.model.Estoque;
import com.manager.order.managerorder.model.EstoqueProduto;
import com.manager.order.managerorder.model.Grupo;
import com.manager.order.managerorder.model.Usuario;
import com.manager.order.managerorder.repository.EstoqueProdutoRepository;
import com.manager.order.managerorder.repository.EstoqueRepository;
import com.manager.order.managerorder.repository.GrupoRepository;
import com.manager.order.managerorder.repository.UsuarioRepository;


@Service
public class EstoqueService {
	
	@Autowired
	private EstoqueRepository estoqueDAO;
	
	@Autowired
	private EstoqueProdutoRepository estoqueProdutoDAO;
	
	@Autowired
	private GrupoRepository grupoDAO;
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	public Iterable<Estoque> findAll(){
		return estoqueDAO.findAll();
	}
	
	public Estoque findById(Long id) {
		return estoqueDAO.findById(id).get();
	}
	
	public List<EstoqueDTO> findAll(Long idUsuario) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		List<Estoque> estoques = estoqueDAO.findListGroup(usuario.getGrupo().getId());
		List<EstoqueDTO> estoquesDTO = new ArrayList<EstoqueDTO>();
		
		for(Estoque estoque : estoques) {
			EstoqueDTO estoqueDTO = new EstoqueDTO();
			estoqueDTO.setIdEstoque(estoque.getId());
			estoqueDTO.setIdGrupo(estoque.getGrupo().getId());
			estoqueDTO.setNome(estoque.getNome());
			estoqueDTO.setTotalProduto(estoque.getTotalProduto());
			
			estoquesDTO.add(estoqueDTO);
		}
		
		return estoquesDTO;
	}
	
	public Estoque save(Estoque estoque, Long idUsuario) {
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		estoque.setGrupo(usuario.getGrupo());
		
		return estoqueDAO.save(estoque);
	}
	
	public Estoque update(Estoque estoque, Long idEstoque,Long idGrupo) {
		Grupo grupo = grupoDAO.findById(idGrupo).get();
		Estoque est = estoqueDAO.findById(idEstoque).get();
		
		est.setId(idEstoque);
		est.setName(estoque.getNome());
		est.setTotalProduto(estoque.getTotalProduto());
		est.setGrupo(grupo);
		
		return estoqueDAO.save(est);
	}
	
	public Estoque delete(Long id) {
		Estoque estoque = estoqueDAO.findById(id).get();
		estoqueDAO.delete(estoque);
		
		return estoque;
	}
	
	public List<EstoqueProdutoDTO> findAllEP(Long idEstoque){
		List<EstoqueProduto> listEP = estoqueProdutoDAO.findAllByIdEstoque(idEstoque);
		List<EstoqueProdutoDTO> listEPDTO = new ArrayList<EstoqueProdutoDTO>();
		
		for(EstoqueProduto ep : listEP) {
			EstoqueProdutoDTO epDTO = new EstoqueProdutoDTO();
			epDTO.setNome(ep.getProduto().getNome());
			epDTO.setQuantidade(ep.getQuantidade());
			epDTO.setDataCriacao(new Date());
			
			listEPDTO.add(epDTO);
		}
		
		return listEPDTO;
	}
	
	public List<EstoqueProdutoListDTO> findEstoqueWithProduto(Long idUsuario){
		Usuario usuario = usuarioDAO.findById(idUsuario).get();
		List<Estoque> estoques = estoqueDAO.findListGroup(usuario.getGrupo().getId());
		List<EstoqueProdutoListDTO> epDTOList =  new ArrayList<EstoqueProdutoListDTO>();
		
		for(Estoque estoque : estoques) {
			List<EstoqueProduto> estoqueProduto = estoqueProdutoDAO.findAllByIdEstoque(estoque.getId());
			EstoqueProdutoListDTO epList = new EstoqueProdutoListDTO();
			epList.setNome(estoque.getNome());
			List<EstoqueProdutoDTO> listEPDTO = new ArrayList<EstoqueProdutoDTO>();
			
			for(EstoqueProduto ep : estoqueProduto) {
				EstoqueProdutoDTO epDTO = new EstoqueProdutoDTO();
				epDTO.setNome(ep.getProduto().getNome());
				epDTO.setQuantidade(ep.getProduto().getQuantidade());
				epDTO.setDataCriacao(new Date());	
				listEPDTO.add(epDTO);
			}
			
			epList.setListEstoqueProduto(listEPDTO);
			epList.setTotal_produtos(estoqueProduto.size());
			epList.setIdEstoque(estoque.getId());
			epList.setGrupo(estoque.getGrupo().getId());
			epDTOList.add(epList);
		}
		
		return epDTOList;
	}

}
