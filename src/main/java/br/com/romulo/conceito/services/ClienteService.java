package br.com.romulo.conceito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.Cliente;
import br.com.romulo.conceito.repositories.ClienteRepository;
import br.com.romulo.conceito.repositories.EnderecoRepository;
import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;
import br.com.romulo.conceito.services.expcetion.SegurancaIntegridadeException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente recuperarClientePorCliente(Integer idCliente) {
		Optional<Cliente> obj = clienteRepository.findById(idCliente);
		return obj.orElseThrow(() -> new ObjetoNaoLocalizado() );
	}

	
	public List<Cliente> listAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente inserir(Cliente cat) {
		cat.setId(null);
		return salvar(cat);
	}

	public Cliente update(Cliente cat) {
		recuperarClientePorCliente(cat.getId());
		return salvar(cat);
	}
	
	private Cliente salvar(final Cliente cliente) {
		Cliente clienteRetorno = new Cliente();
		clienteRetorno = clienteRepository.save(cliente);

		if(cliente.getEnderecos() != null && !cliente.getEnderecos().isEmpty()) {
			cliente.getEnderecos().stream().forEach(endereco -> endereco.setCliente(cliente));			
			enderecoRepository.saveAll(cliente.getEnderecos());
		}
		
		return clienteRetorno;
	}

	public void delete(Integer id) {
		try {
			recuperarClientePorCliente(id);
			clienteRepository.deleteById(id);
		} catch (ObjetoNaoLocalizado objetoNaolocalizado) {
			throw objetoNaolocalizado;
		}catch(DataIntegrityViolationException dataIntegrityViolationException) {
			throw new SegurancaIntegridadeException("Cliente está vinculado a um processo");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
