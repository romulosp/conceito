package br.com.romulo.conceito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romulo.conceito.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>   {

}
