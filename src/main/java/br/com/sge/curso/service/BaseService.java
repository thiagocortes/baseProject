package br.com.sge.curso.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.BaseModel;

public abstract class BaseService <T extends BaseModel> {
	
	public abstract void delete(Long id);
	   
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public abstract T get(Long id);
 
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public abstract Page<T> list(Integer page);
    
    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public abstract Iterable<T> findAll();
 
    public abstract T save(T object);
    public abstract T update(T object); 
    
    public abstract List<T> listar();
}
