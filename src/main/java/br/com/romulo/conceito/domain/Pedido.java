package br.com.romulo.conceito.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Calendar instante;
	
	@ManyToMany
	@JoinTable(
				 name="PEDIDO_PRODUTO",
				 joinColumns=@JoinColumn(name="id_pedido"),
				 inverseJoinColumns=@JoinColumn(name="id_produto")
			)
	private List<Produto> produtos;


	public Pedido() {
	}
	
	
	public Pedido(Integer id, Calendar instante, List<Produto> produtos) {
		super();
		this.id = id;
		this.instante = instante;
		this.produtos = produtos;
	}
	

	public Pedido(Calendar instante, List<Produto> produtos) {
		super();
		this.instante = instante;
		this.produtos = produtos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Calendar getInstante() {
		return instante;
	}


	public void setInstante(Calendar instante) {
		this.instante = instante;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
