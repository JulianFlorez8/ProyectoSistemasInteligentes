package com.inteligentes.backend_inteligentes.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inteligentes.backend_inteligentes.model.Nodo;

@Service
@Transactional(readOnly = true)
public class AlgoritmoService {
	
	public AlgoritmoService() {
		
	}
	
	@Transactional
	public Nodo create(Nodo data) {
		return data;
	}
	
	@Transactional
	public Nodo update(Nodo data) {
		return data;
	}
	
	@Transactional
	public void delete(int data) {
		
	}
	
	public int findById(int id) {
		return id;
	}

}
