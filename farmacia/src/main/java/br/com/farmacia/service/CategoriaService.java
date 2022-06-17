package br.com.farmacia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farmacia.domain.Categoria;
import br.com.farmacia.exception.RecursoNaoEncontradoException;
import br.com.farmacia.repository.CategoriaRepository;
@Service
public class CategoriaService {	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		if (resultado.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		Categoria categoria = resultado.get();
		return categoria;	
		}
	
	public List<Categoria> listar(){
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}
	
	public Categoria inserir (Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	public Categoria excluir(Short codigo){
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
		Categoria categoriaRetorno = categoria.get();
		return categoriaRetorno;
	}
	
	public Categoria editar(Categoria categoria) {
		Categoria categoriaEditada = categoriaRepository.save(categoria);
		return categoriaEditada;
	}
	
	
}	
