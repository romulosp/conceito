package br.com.romulo.conceito.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.romulo.conceito.domain.Cliente;
import br.com.romulo.conceito.domain.Endereco;
import br.com.romulo.conceito.domain.TipoCliente;

public class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	private Integer id;
	
	@NotEmpty(message="Favor preencher o nome do cliente")
	@Length(min=10, max=80, message="O nome do cliente tem que ter 25 à 80 caracteres.")
	private String nome;
	@NotEmpty(message="Favor preencher o email do cliente")
	@Length(min=10, max=30, message="O email do cliente tem que ter 10 à 30 caracteres.")
	private String email;
//	@NotEmpty(message="Favor preencher o cpf ou cpnj do cliente")
	private String cpfOuCnpj;
//	@NotEmpty(message="Favor informar o tipo do cliente")
	private Integer tipo;
	
//	@NotEmpty(message="Favor preencher a comunicação do cliente")
	private Set<String> telefones;
//	@NotEmpty(message="Favor preencher o endereço do cliente")
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

	public Cliente toCliente() {
		Cliente retorno = new Cliente();
		if(this != null) {
			retorno.setId(getId());
			retorno.setNome(getNome());
			retorno.setEmail(getEmail());
			retorno.setCpfOuCnpj(getCpfOuCnpj());
			retorno.setTipo(TipoCliente.getTipoCliente(getTipo()));
			retorno.setTelefones(getTelefones());
			List<Endereco> enderecosCliente= null;
			if(getEnderecos() != null) {
				enderecosCliente = getEnderecos()
						.stream()
						.map(endereco -> endereco.toEndreco()).collect(Collectors.toList());
			}
			retorno.setEnderecos(enderecosCliente);
		}
		return retorno;
	}
}
