package com.mikael.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mikael.cursomc.domain.Categoria;
import com.mikael.cursomc.domain.Produto;
import com.mikael.cursomc.repositories.CategoriaRepository;
import com.mikael.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { //CommandLineRunner é um macete de instanciação no momento
	//em que a aplicação iniciar. Ele nos permite executar uma ação quando a aplicação iniciar. O método começa na linha 16.
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); // Estamos pegando a instância da classe Repository que é 
		//responsável por fazer queries no banco de dados e estamos chamando o método .saveAll que é utilizado para salvar
		//dados no banco de dados, ele é um método da interface jpaRepository. Dentro nós passamos Arrays.asList que basicamente,
		//cria uma lista automatica, que me possibilita passar quantos elementos eu quiser.
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
