package com.mikael.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikael.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository  <Categoria, Integer>  {
	
}
