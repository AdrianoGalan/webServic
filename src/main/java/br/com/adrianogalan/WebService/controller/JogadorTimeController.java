package br.com.adrianogalan.WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adrianogalan.WebService.model.dto.JogadorDTO;
import br.com.adrianogalan.WebService.model.dto.TimeDTO;
import br.com.adrianogalan.WebService.model.entity.JogadorTime;
import br.com.adrianogalan.WebService.repository.JogadorTimeRepository;

@RestController
@RequestMapping("/api")
public class JogadorTimeController {

	@Autowired
	private JogadorTimeRepository jTimeRep;

	@GetMapping("/jogador/idade/{codigo}")
	public ResponseEntity<JogadorDTO> getJogadorIdade(@PathVariable(value = "codigo") int codigo) {
		JogadorTime j = jTimeRep.udfJogadorIdade(codigo);
		JogadorDTO jDTO = converteJogadorTime(j);
		return ResponseEntity.ok().body(jDTO);
	}

	private JogadorDTO converteJogadorTime(JogadorTime j) {
		JogadorDTO jDTO = new JogadorDTO();
		jDTO.setCodigo(j.getCodigo());
		jDTO.setNomeJogador(j.getNomeJogador());
		jDTO.setSexo(j.getSexo());
		jDTO.setAltura(j.getAltura());
		jDTO.setDtNasc(j.getDtNasc());

		TimeDTO tDTO = new TimeDTO();
		tDTO.setId(j.getId());
		tDTO.setNome(j.getNome());
		tDTO.setCidade(j.getCidade());

		jDTO.setTimes(tDTO);

		return jDTO;

	}
}
