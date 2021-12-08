package com.agenda.service;

import com.agenda.entities.Cliente;
import com.agenda.repositories.ClienteRepository;
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
public class ClienteService {
	
	@Autowired
	public ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente insert(Cliente obj) {
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
	
	public Cliente update(Long id, Cliente obj) {
        try {
        	Cliente entity = repository.getOne(id);
            updateData(entity, obj);
            return  repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
	
	 public void updateData (Cliente entity, Cliente obj) {
	        entity.setNome(obj.getNome());
	        entity.setCPF(obj.getCPF());
	    }

} 
