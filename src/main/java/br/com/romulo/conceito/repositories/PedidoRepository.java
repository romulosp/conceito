package br.com.romulo.conceito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romulo.conceito.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>   {

}
