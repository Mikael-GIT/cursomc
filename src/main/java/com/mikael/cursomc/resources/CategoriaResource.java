package com.mikael.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mikael.cursomc.domain.Categoria;
import com.mikael.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {


	@Autowired
	private CategoriaService service;
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { //A anotação @PathVariable serve para dizer que este método irá
		//receber um id que virá na URL.  OBS: ResponseEntity é um objeto que encapsula várias informações de uma resposta
		//HTTP para um serviço rest, o <?> significa que ele pode receber qualquer tipo, pois pode ser tanto uma categoria como nulo.
		//OBS2: Este ResponseEntity pode ser substituido por uma lista do objeto que queremos utilizar. Ficaria: 
		//public List <Categoria> find (@PathVariable Integer id){ 
		
		Categoria obj = service.buscar(id);
		
		List <Categoria> lista = new ArrayList<>();
		return ResponseEntity.ok().body(obj);
	}
}
