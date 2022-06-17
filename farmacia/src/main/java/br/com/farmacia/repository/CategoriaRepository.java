package br.com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

}
