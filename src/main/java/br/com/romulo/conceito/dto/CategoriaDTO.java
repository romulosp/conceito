package br.com.romulo.conceito.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
			if(categoria.getProduto() != null) {
				List<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();
				categoria.getProduto().stream().map(produto -> listaProduto.add(new ProdutoDTO(produto)));
				setProduto(listaProduto);
			}
		}
		
	}
	
	private Integer id ;
	private String nome;
	private List<ProdutoDTO> produto;

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
	
	public List<ProdutoDTO> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoDTO> produto) {
		this.produto = produto;
	}
}


