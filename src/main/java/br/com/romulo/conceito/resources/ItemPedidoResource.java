package br.com.romulo.conceito.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.domain.ItemPedido;
import br.com.romulo.conceito.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/item_pedido")
public class ItemPedidoResource {
	
	@Autowired
	private ItemPedidoService itemPedidoService;

	@RequestMapping(value="/{idItemPedido}", method = RequestMethod.GET)
	public ResponseEntity<ItemPedido> listarPedidoPorID(@PathVariable("idItemPedido") Integer idItemPedido){
		return ResponseEntity.ok().body(itemPedidoService.buscarItemPedidoPorID(idItemPedido));
	}
	
}
