package br.com.romulo.conceito.dto;

import java.io.Serializable;

import br.com.romulo.conceito.domain.Endereco;

public class EnderecoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	 
	private CidadeDTO cidade;
	
	 
	private ClienteDTO cliente;
 
	
	public EnderecoDTO() {
	}
	
	
	public EnderecoDTO(String logradouro, String numero, String complemento, String bairro, String cep) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
	}
	

	public EnderecoDTO(Endereco endereco) {
		if(endereco != null) {
			setLogradouro(endereco.getLogradouro());
			setNumero(endereco.getNumero());
			setComplemento(endereco.getComplemento());
			setBairro(endereco.getBairro());
			setCep(endereco.getCep());
		}
		
	}
	
	
	public Endereco toEndreco() {
		Endereco retorno = null;
		if(this != null) {
			retorno = new Endereco();
			retorno.setLogradouro(getLogradouro());
			retorno.setBairro(getBairro());
			retorno.setNumero(getNumero());
			retorno.setComplemento(getComplemento());
			retorno.setCep(getCep());
		}
		return retorno;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public CidadeDTO getCidade() {
		return cidade;
	}
	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}
	
}
