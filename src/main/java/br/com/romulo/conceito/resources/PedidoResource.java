package br.com.romulo.conceito.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.dto.PedidoDTO;
import br.com.romulo.conceito.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value="/{idPedido}", method = RequestMethod.GET)
	public ResponseEntity<PedidoDTO> listarPedidoPorID(@PathVariable("idPedido") Integer idPedido){
		return ResponseEntity.ok().body(new PedidoDTO(pedidoService.buscarPedidoPorID(idPedido)));
	}
	
}
