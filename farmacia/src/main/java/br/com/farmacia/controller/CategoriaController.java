package br.com.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.farmacia.domain.Categoria;
import br.com.farmacia.exception.RecursoNaoEncontradoException;
import br.com.farmacia.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar() {
		List<Categoria> categorias = categoriaService.listar();
		return categorias;
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		try {
			Categoria categoria = categoriaService.buscarPorCodigo(codigo);
			return categoria;			
		} catch (RecursoNaoEncontradoException exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada", exception);
		}
		
	}
	
	@PostMapping
	public Categoria inserir (@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.inserir(categoria);
		return categoriaSalva;
	}
	
	@DeleteMapping("/{codigo}")
	public void excluir(@PathVariable Short codigo){
		categoriaService.excluir(codigo);
		return;
	}
	
	@PutMapping       
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaService.editar(categoria);
		return categoriaEditada;
	}
	
}
