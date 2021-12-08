package com.agenda.resource;

import com.agenda.DTO.AgendamentoDTO;
import com.agenda.entities.Agendamento;
import com.agenda.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoResource {
	
	@Autowired
	private AgendamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Agendamento>> findAll() {
		List<Agendamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
    public ResponseEntity<Agendamento> insert(@RequestBody Agendamento obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
	
	   @PutMapping(value="/{id}")
	    public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento obj) {
	        obj = service.update(id, obj);
	        return ResponseEntity.ok().body(obj);
	   }

	@GetMapping
	@RequestMapping(value = "/cliente")
	public ResponseEntity<Page<AgendamentoDTO>> findPage(
		@RequestParam(value = "page", defaultValue="0")	Integer page,
		@RequestParam(value = "linesPerPage", defaultValue="24") Integer linesPerPage,
		@RequestParam(value = "orderBy", defaultValue="cliente") String orderBy,
		@RequestParam(value = "direction", defaultValue="ASC") String direction) {
		Page<Agendamento> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page listDto = list.map(obj -> new AgendamentoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
