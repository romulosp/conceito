package br.com.romulo.conceito.dto;

import java.io.Serializable;

import br.com.romulo.conceito.domain.Categoria;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	} 
	
	public CategoriaDTO(Categoria categoria) {
		if(categoria != null) {
			setId(categoria.getId());
			setNome(categoria.getNome());
		}
		
	}
	
	private Integer id ;
	private String nome;

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


