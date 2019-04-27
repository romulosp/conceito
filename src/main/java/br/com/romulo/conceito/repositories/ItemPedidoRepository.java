package br.com.romulo.conceito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romulo.conceito.domain.ItemPedido;
import br.com.romulo.conceito.domain.ProdutoPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ProdutoPedidoPK>   {

}
