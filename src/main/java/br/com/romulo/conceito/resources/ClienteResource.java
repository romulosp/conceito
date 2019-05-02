package br.com.romulo.conceito.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.romulo.conceito.domain.Cliente;
import br.com.romulo.conceito.dto.ClienteDTO;
import br.com.romulo.conceito.services.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<ClienteDTO> recuperarPorCliente(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(new ClienteDTO(clienteService.recuperarClientePorCliente(id)));
	}
	
	@RequestMapping(value = "/all", method= RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> listAll() {
		List<Cliente> listAllCliente = clienteService.listAll();
		List<ClienteDTO> listAllClientesDTO = listAllCliente.stream().map(
				cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listAllClientesDTO);
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@Valid @RequestBody ClienteDTO clienteDTO){
			Cliente cliente  =  clienteService.inserir(clienteDTO.toCliente());
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().
					path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
			return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/update" ,method = RequestMethod.PUT)
	public ResponseEntity<?> update(@Valid @RequestBody ClienteDTO ClienteDTO){
		clienteService.update(ClienteDTO.toCliente());
			return ResponseEntity.noContent().build();
	 }
	
	 @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	 public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		 clienteService.delete(id);
		 return ResponseEntity.ok().build();
	 }
	 
}
