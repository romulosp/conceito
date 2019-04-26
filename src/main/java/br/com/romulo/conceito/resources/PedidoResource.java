package br.com.romulo.conceito.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.domain.Pedido;

@RestController(value = "pedido")
public class PedidoResource {

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pedido> listarPedidoPorID(){
		return null;
	}
	
}
