package com.agenda.service;

import com.agenda.entities.Servico;
import com.agenda.repositories.ServicoRepository;
import com.agenda.service.exceptions.DatabaseException;
import com.agenda.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class servicoService {
	
	@Autowired
	public ServicoRepository repository;
	
	public List<Servico> findAll() {
		return repository.findAll();
	}
	
	public Servico findById(Long id) {
		Optional<Servico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Servico insert(Servico obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e ) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
	}
	
	public Servico update(Long id, Servico obj) {
        try {
        	Servico entity = repository.getOne(id);
            updateData(entity, obj);
            return  repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
	
	 public void updateData (Servico entity, Servico obj) {
	        entity.setCodigo(obj.getCodigo());
	        entity.setDescricao(obj.getDescricao());
	        entity.setValor(obj.getValor());
	    }
	
	

}
