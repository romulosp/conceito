package br.com.romulo.conceito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romulo.conceito.domain.PagamentoComBoleto;

@Repository
public interface PagamentoComBoletoRepository extends JpaRepository<PagamentoComBoleto,Integer>   {

}
