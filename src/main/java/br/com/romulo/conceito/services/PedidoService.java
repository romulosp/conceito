package br.com.romulo.conceito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.Pedido;
import br.com.romulo.conceito.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private  PedidoRepository pedidoRepository;
	
	public Pedido recuperarPedidoPorID(Integer idPedido) {
		Optional<Pedido> obj = pedidoRepository.findById(idPedido);
		return obj.orElse(null);
	}
}
