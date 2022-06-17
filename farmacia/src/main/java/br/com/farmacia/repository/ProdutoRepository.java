package br.com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
