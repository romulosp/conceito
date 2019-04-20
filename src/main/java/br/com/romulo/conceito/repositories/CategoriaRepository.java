package br.com.romulo.conceito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.romulo.conceito.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>   {

}
