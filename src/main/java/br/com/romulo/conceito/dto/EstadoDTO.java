package br.com.romulo.conceito.dto;

import java.io.Serializable;
import java.util.List;

import br.com.romulo.conceito.domain.Estado;

public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public EstadoDTO() {
		
	}
	public EstadoDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	} 
	
	public EstadoDTO(Estado estado) {
		if(estado != null) {
			setId(estado.getId());
			setNome(estado.getNome());
		}
	}
	 
	private Integer id ;
	private String nome;
	private List<CidadeDTO> cidades;
	
	public List<CidadeDTO> getCidades() {
		return cidades;
	}

	public void setCidades(List<CidadeDTO> cidades) {
		this.cidades = cidades;
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
	 
}


