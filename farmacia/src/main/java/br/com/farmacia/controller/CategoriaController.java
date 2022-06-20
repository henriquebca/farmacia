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

import br.com.farmacia.exception.RecursoNaoEncontradoException;
import br.com.farmacia.model.Categoria;
import br.com.farmacia.service.impl.CategoriaServiceImpl;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	@GetMapping("/{codigo}")
	public Categoria findById(@PathVariable Short codigo) throws Exception {
			Categoria categoria = categoriaService.findById(codigo);
			return categoria;		
	}
	
	@GetMapping
	public List<Categoria> findAll() {
		List<Categoria> categorias = categoriaService.findAll();
		return categorias;
	}
	
	@PostMapping
	public Categoria save (@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.save(categoria);
		return categoriaSalva;
	}
	
	@PutMapping       
	public Categoria editar(@RequestBody Categoria categoria) {
		Categoria categoriaEditada = categoriaService.editar(categoria);
		return categoriaEditada;
	}
	

	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable Short codigo) throws Exception{
		categoriaService.delete(codigo);
		return;
	}
	
}
