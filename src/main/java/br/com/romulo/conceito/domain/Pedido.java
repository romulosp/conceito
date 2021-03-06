package br.com.romulo.conceito.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Temporal(TemporalType.DATE)
	private Calendar instante;
	
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Pagamento pagamento;
	
	@OneToOne
	private ItemPedido itemPedido;
	
	
	public Pedido() {}
	
	
	public Pedido(Calendar instante, Endereco endereco, Cliente cliente, Pagamento pagamento) {
		super();
		this.instante = instante;
		this.endereco = endereco;
		this.cliente = cliente;
		this.pagamento = pagamento;
	}

	public Pedido(Calendar instante, Endereco endereco, Cliente cliente) {
		super();
		this.instante = instante;
		this.endereco = endereco;
		this.cliente = cliente;
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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public ItemPedido getItemPedido() {
		return itemPedido;
	}


	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

 
}
