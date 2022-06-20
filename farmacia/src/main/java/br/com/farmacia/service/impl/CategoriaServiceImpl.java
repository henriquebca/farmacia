package br.com.farmacia.service.impl;
import static br.com.farmacia.exception.ErrorCode.NOT_FOUND_ERROR;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.farmacia.exception.NaoEncontradoException;
import br.com.farmacia.exception.RecursoNaoEncontradoException;
import br.com.farmacia.model.Categoria;
import br.com.farmacia.repository.CategoriaRepository;
import br.com.farmacia.service.CategoriaService;
@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria findById(Short codigo) throws NaoEncontradoException {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		if (resultado.isPresent()) {
			Categoria categoria = resultado.get();
			return categoria;
		}
		throw new NaoEncontradoException(NOT_FOUND_ERROR.getValue());
			
		}
	@Override
	public List<Categoria> findAll(){
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}
	@Override
	public Categoria save (Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	@Override
	public Categoria editar(Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
	}
	
	@Override
	public Categoria delete(Short codigo) throws Exception{
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		if (categoria.isPresent()) {
			categoriaRepository.delete(categoria.get());
			Categoria categoriaRetorno = categoria.get();
			return categoriaRetorno;
		}
		throw new NaoEncontradoException(NOT_FOUND_ERROR.getValue());
	}
	
}	
