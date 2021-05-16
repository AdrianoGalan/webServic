package br.com.adrianogalan.WebService.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adrianogalan.WebService.model.dto.TimeDTO;
import br.com.adrianogalan.WebService.model.entity.Times;
import br.com.adrianogalan.WebService.repository.TimesRepository;

@RestController
@RequestMapping("/api")
public class TimesController {

	@Autowired
	private TimesRepository tRep;

	@GetMapping("/times")
	public List<TimeDTO> getAllTimes() {
		List<Times> listaTimes = tRep.findAll();
		List<TimeDTO> listaTimeDTO = converteListaTimes(listaTimes);
		return listaTimeDTO;
	}

	@GetMapping("/times/{idTime}")
	public ResponseEntity<TimeDTO> getTime(@PathVariable(value = "idTime") int idTime)
			throws ResourceNotFoundException {
		Times time = tRep.findById(idTime).orElseThrow(() -> new ResourceNotFoundException(idTime + "invalido"));

		TimeDTO timeDTO = converteTime(time);
		return ResponseEntity.ok().body(timeDTO);
	}

	@PostMapping("/times")
	public ResponseEntity<String> crudTimes(@Valid @RequestBody Times t) {
		String saida = tRep.spCrudTimes(t.getCod(), t.getId(), t.getNome(), t.getCidade());

		return ResponseEntity.ok().body(saida);
	}

	private TimeDTO converteTime(Times t) {

		TimeDTO tDTO = new TimeDTO();
		tDTO.setId(t.getId());
		tDTO.setNome(t.getNome());
		tDTO.setCidade(t.getCidade());

		return tDTO;

	}

	private List<TimeDTO> converteListaTimes(List<Times> listaTimes) {

		List<TimeDTO> listaTimesDTO = new ArrayList<TimeDTO>();

		for (Times t : listaTimes) {
			TimeDTO tDTO = new TimeDTO();
			tDTO.setId(t.getId());
			tDTO.setNome(t.getNome());
			tDTO.setCidade(t.getCidade());

			listaTimesDTO.add(tDTO);
		}

		return listaTimesDTO;
	}

}
