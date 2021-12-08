package com.agenda.resource;

import com.agenda.entities.Servico;
import com.agenda.service.servicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value ="/servico")
public class ServicoResource {
	
	@Autowired
	private servicoService service;
	
	
	  @GetMapping
	    public ResponseEntity<List<Servico>> findAll() {
	        List<Servico> list =  service.findAll();
	        return ResponseEntity.ok().body(list);
	    }

	    // Buscando Usuário por id
	    @GetMapping(value="/{id}")
	    public ResponseEntity<Servico> findById(@PathVariable  Long id) {
	    	Servico obj = service.findById(id);
	        return ResponseEntity.ok().body(obj);
	    }

	    // cadastrar um novo usuário
	    @PostMapping
	    public ResponseEntity<Servico> insert(@RequestBody Servico obj) {
	        obj = service.insert(obj);
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(obj.getId()).toUri();
	        return ResponseEntity.created(uri).body(obj);
	    }

	    // Deleta os usuário por id
	    @DeleteMapping(value="/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        service.repository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

	    // Atualizar usuário
	    @PutMapping(value="/{id}")
	    public ResponseEntity<Servico> update(@PathVariable Long id, @RequestBody Servico obj) {
	        obj = service.update(id, obj);
	        return ResponseEntity.ok().body(obj);
	    }

}
