package br.com.farmacia.service;

import java.util.List;

import br.com.farmacia.model.Categoria;

public interface CategoriaService {
	
	Categoria findById(Short codigo)throws Exception;
	
	List<Categoria> findAll();
	
	Categoria save (Categoria categoria);
	
	void update(Short codigo) throws Exception;

	void delete(Short codigo) throws Exception;
	
}
