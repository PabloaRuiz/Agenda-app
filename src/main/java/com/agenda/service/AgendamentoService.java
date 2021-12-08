package com.agenda.service;

import com.agenda.entities.Agendamento;
import com.agenda.repositories.AgendamentoRepository;
import com.agenda.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class AgendamentoService {
	
	@Autowired
	public AgendamentoRepository repository;
	
	
	public List<Agendamento> findAll() {
		return repository.findAll();
	}
	

	public Agendamento insert(Agendamento obj) {
		return repository.save(obj);
	}
	
	public Agendamento update(Long id, Agendamento obj) {
        try {
        	Agendamento entity = repository.getById(id);
            updateData(entity, obj);
            return  repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
	
	 public void updateData (Agendamento entity, Agendamento obj) {
	        entity.setDatahora(obj.getDatahora());
	}

	public Page<Agendamento> findPage(Integer page, Integer linesPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPage, Sort.Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}


}