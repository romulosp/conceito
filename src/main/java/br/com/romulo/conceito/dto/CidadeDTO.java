package br.com.romulo.conceito.dto;

import java.io.Serializable;

import br.com.romulo.conceito.domain.Cidade;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
    private Integer id;
	 
	 private String nome;

	 private EstadoDTO estado;
	 
	 public CidadeDTO() {
	 }
	 

	public CidadeDTO(Integer id, String nome, EstadoDTO estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}
	
	public CidadeDTO(Cidade cidade) {
		if(cidade != null) {
			setId(cidade.getId());
			setNome(cidade.getNome());
			if(cidade.getEstado() != null) {
				setEstado(new EstadoDTO(cidade.getEstado().getId(), cidade.getEstado().getNome()));
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

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
 
}
