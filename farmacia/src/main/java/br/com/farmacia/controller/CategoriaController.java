package br.com.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.farmacia.exception.EntidadeNaoProcessavelException;
import br.com.farmacia.model.Categoria;
import br.com.farmacia.service.impl.CategoriaServiceImpl;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaServiceImpl categoriaService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> findById(@PathVariable Short codigo) throws Exception {
			Categoria categoria = categoriaService.findById(codigo);
			if (categoria == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);		
	}
	
	@GetMapping
	public  List<Categoria> findAll() {
		List<Categoria> categorias = categoriaService.findAll();
		return categorias;
	}
	
//	@PostMapping
//	public ResponseEntity<Categoria> save (@RequestBody Categoria categoria) {
//		Categoria categoriaSalva = categoriaService.save(categoria);
//		return ;
//	}
	
	@PutMapping       
	public ResponseEntity<?> update(@RequestBody Short codigo) throws Exception {
		categoriaService.update(codigo);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Short codigo) throws Exception{
		categoriaService.delete(codigo);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
