package br.com.romulo.conceito.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.romulo.conceito.domain.Produto;

public class ProdutoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	
	private List<CategoriaDTO> categorias;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public ProdutoDTO(Produto produto) {
		if(produto != null) {
			setId(produto.getId());
			setNome(produto.getNome());
			setPreco(produto.getPreco());
			if(produto.getCategorias() != null) {
				List<CategoriaDTO> listaCategorias = new ArrayList<CategoriaDTO>();
				produto.getCategorias().stream().map(categoria -> listaCategorias.add(new CategoriaDTO(categoria)));
				setCategorias(listaCategorias);
			}
		}
	}

	public ProdutoDTO(String nome, Double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	
	public ProdutoDTO(String nome, Double preco, List<CategoriaDTO> categorias) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.categorias = categorias;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}
}
