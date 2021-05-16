package br.com.adrianogalan.WebService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.adrianogalan.WebService.model.entity.Jogador;


public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
	
	List<Jogador> findJogadoresDataConv();
	Jogador findJogadorDataConv(int codigo);

}
