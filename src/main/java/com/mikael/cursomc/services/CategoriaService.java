package com.mikael.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikael.cursomc.domain.Categoria;
import com.mikael.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
		@Autowired
		private CategoriaRepository repo;
		public Categoria buscar (Integer id) {
			Optional<Categoria> obj = repo.findById(id); //Vai no banco de dados, busca uma categoria pelo Id e retorna para
			//um objeto de Optional o objeto que foi encontrado no id buscado pelo método findById.
			return obj.orElse(null); //Se o objeto não for null, ele retornará uma Categoria com seus dados, ou se for nulo ele retorna
			//null. (.orElse(null);
			
		}
}
