package br.com.farmacia.service.impl;

import static br.com.farmacia.exception.ErrorCode.NOT_FOUND_ERROR;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.farmacia.exception.EntidadeNaoProcessavelException;
import br.com.farmacia.exception.NaoEncontradoException;
import br.com.farmacia.model.Categoria;
import br.com.farmacia.repository.CategoriaRepository;
import br.com.farmacia.service.CategoriaService;
import br.com.farmacia.utils.Constants;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria findById(Short codigo) throws Exception {
		try {
			Optional<Categoria> resultado = categoriaRepository.findById(codigo);
			if (resultado.isPresent()) {
				return resultado.get();
			}
			return null;
		} catch (Exception ex) {
			throw new Exception(Constants.MSG_ERROR_REPOSITORY);

		}
	}

	@Override
	public List<Categoria> findAll() {
		List<Categoria> resultado = categoriaRepository.findAll();
		return resultado;
	}

	@Override
	public Categoria save(Categoria categoria) {
		Optional<Categoria> resultado = categoriaRepository.findById(new Short(categoria.getNome()));
		if (resultado.isPresent()) {
			throw new EntidadeNaoProcessavelException();
		}
		return categoriaRepository.save(categoria);
	}

	@Override
	public void update(Short codigo) throws Exception {
		
		Optional<Categoria> optional = categoriaRepository.findById(codigo);
		if (optional.isPresent()) {
			Categoria model = optional.get();
			Categoria modelUpdate = new Categoria();
			
			modelUpdate.setCodigo(model.getCodigo());
			modelUpdate.setNome(model.getNome());
			return;
			
		}
		throw new NaoEncontradoException(NOT_FOUND_ERROR.getValue());
	}

	@Override
	public void delete(Short codigo) throws Exception {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		if (categoria.isPresent()) {
			categoriaRepository.delete(categoria.get());
			return;
		}
		throw new NaoEncontradoException(NOT_FOUND_ERROR.getValue());
	}

}
