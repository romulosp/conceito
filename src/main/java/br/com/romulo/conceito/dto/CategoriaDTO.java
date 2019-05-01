package br.com.romulo.conceito.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
	@NotEmpty(message="Favor preencher o nome")
	@Length(min=5, max=40, message="O nome da categoria tem que ter 5 à 40 caracteres.")
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

	public Categoria toCategoria() {
		return  new Categoria(getId(), getNome());
	}
	 
}


