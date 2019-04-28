package br.com.romulo.conceito.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.romulo.conceito.domain.Categoria;
import br.com.romulo.conceito.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Categoria> teste(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body(categoriaService.recuperarPorCategoria(id));
		
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	 public ResponseEntity<Void> inserir(@RequestBody Categoria cat){
			Categoria categoria  =  categoriaService.inserir(cat);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().
					path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
			return ResponseEntity.created(uri).build();
	 }
	
	@RequestMapping(value="/update" ,method = RequestMethod.PUT)
	 public ResponseEntity<?> update(@RequestBody Categoria cat){
			categoriaService.update(cat);
			return ResponseEntity.noContent().build();
	 }
	
	 @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	 public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		 categoriaService.delete(id);
		 return ResponseEntity.ok().build();
	 }
}
