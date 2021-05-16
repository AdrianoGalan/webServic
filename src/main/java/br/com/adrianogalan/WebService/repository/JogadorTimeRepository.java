package br.com.adrianogalan.WebService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianogalan.WebService.model.entity.JogadorTime;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Integer>  {
	
	JogadorTime udfJogadorIdade(int codigo);

}
