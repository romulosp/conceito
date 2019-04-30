package br.com.romulo.conceito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.Categoria;
import br.com.romulo.conceito.repositories.CategoriaRepository;
import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;
import br.com.romulo.conceito.services.expcetion.SegurancaIntegridadeException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaDAO;
	
	public Categoria recuperarPorCategoria(Integer idCategoria) {
		Optional<Categoria> obj = categoriaDAO.findById(idCategoria);
		return obj.orElseThrow(() -> new ObjetoNaoLocalizado() );
	}

	
	public List<Categoria> listAll() {
		return categoriaDAO.findAll();
	}
	
	public Categoria inserir(Categoria cat) {
		cat.setId(null);
		return salvar(cat);
	}

	public Categoria update(Categoria cat) {
		recuperarPorCategoria(cat.getId());
		return salvar(cat);
	}
	
	private Categoria salvar(Categoria cat) {
		return categoriaDAO.save(cat);
	}

	public void delete(Integer id) {
		try {
			recuperarPorCategoria(id);
			categoriaDAO.deleteById(id);
		} catch (ObjetoNaoLocalizado objetoNaolocalizado) {
			throw objetoNaolocalizado;
		}catch(DataIntegrityViolationException dataIntegrityViolationException) {
			throw new SegurancaIntegridadeException(" não é possivel exclui uma categoria vinculada a um produto");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
