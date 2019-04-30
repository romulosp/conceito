package br.com.romulo.conceito.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.romulo.conceito.domain.Cliente;

public class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	
	private Set<String> telefones;
	private List<EnderecoDTO> enderecos;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(String nome, String email, String cpfOuCnpj, Integer tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo;
	}
	
	public ClienteDTO(Cliente cliente) {
		if(cliente != null) {
			setId(cliente.getId());
			setNome(cliente.getNome());
			setEmail(cliente.getEmail());
			setCpfOuCnpj(cliente.getCpfOuCnpj());
			if(cliente.getTipo() != null) {
				setTipo(cliente.getTipo().getCodigo());
			}
			
			setTelefones(cliente.getTelefones());
			if(cliente.getEnderecos() != null) {
				List<EnderecoDTO> listaEnderecoClienteDTO = cliente.getEnderecos().stream().map(endereco -> new EnderecoDTO(endereco)).collect(Collectors.toList());
				setEnderecos(listaEnderecoClienteDTO);
			}
			 
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
}
