package br.com.romulo.conceito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.Pedido;
import br.com.romulo.conceito.repositories.PedidoRepository;
import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;

@Service
public class PedidoService {
	
	@Autowired
	private  PedidoRepository pedidoRepository;
	
	 public Pedido buscarPedidoPorID(Integer idPedido){
		 Optional<Pedido> obj = pedidoRepository.findById(idPedido);
			return obj.orElseThrow(()-> new ObjetoNaoLocalizado());
	 }
	 
	 public List<Pedido> listAll(){
		 return pedidoRepository.findAll();
	 }
	 
}
