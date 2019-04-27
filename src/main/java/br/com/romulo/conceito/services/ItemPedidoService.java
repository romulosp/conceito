package br.com.romulo.conceito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.ItemPedido;
import br.com.romulo.conceito.domain.ProdutoPedidoPK;
import br.com.romulo.conceito.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private  ItemPedidoRepository itemPedidoRepository;
	
	 public ItemPedido buscarItemPedidoPorID(ProdutoPedidoPK idItemPedido){
		 Optional<ItemPedido> obj = itemPedidoRepository.findById(idItemPedido);
			return obj.orElseThrow(()-> new ObjetoNaoLocalizado());
	 }
	 
	 public List<ItemPedido> listAll(){
		 return itemPedidoRepository.findAll();
	 }
	 
}
