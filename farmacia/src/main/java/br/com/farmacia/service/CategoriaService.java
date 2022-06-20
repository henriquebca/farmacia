package br.com.farmacia.service;

import java.util.List;

import br.com.farmacia.model.Categoria;

public interface CategoriaService {
	
	Categoria findById(Short codigo)throws Exception;
	
	List<Categoria> findAll();
	
	Categoria save (Categoria categoria);
	
	Categoria editar(Categoria categoria);

	Categoria delete(Short codigo) throws Exception;
	
}
