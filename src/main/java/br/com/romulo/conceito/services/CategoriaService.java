package br.com.romulo.conceito.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.Categoria;
import br.com.romulo.conceito.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaDAO;
	
	public Categoria recuperarPorCategoria(Integer idCategoria) {
		Optional<Categoria> obj = categoriaDAO.findById(idCategoria);
		return obj.orElseThrow(() -> new ObjetoNaoLocalizado() );
	}

	public Categoria inserir(Categoria cat) {
		cat.setId(null);
		return categoriaDAO.save(cat);
	}
}
