//package br.com.romulo.conceito.resources;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.romulo.conceito.domain.Pedido;
//import br.com.romulo.conceito.services.ItemPedidoService;
//import br.com.romulo.conceito.services.PedidoService;
//
//@RestController
//@RequestMapping(value = "/item")
//public class ItemPedidoResource {
//	
//	@Autowired
//	private ItemPedidoService itemPedidoService;
//
//	@RequestMapping(value="/{idPedido}", method = RequestMethod.GET)
//	public ResponseEntity<Pedido> listarPedidoPorID(@PathVariable("idPedido") Integer idPedido){
//		return ResponseEntity.ok().body(pedidoService.buscarPedidoPorID(idPedido));
//	}
//	
//}
