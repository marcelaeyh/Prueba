package com.tienda.mintic.service;

import java.util.Optional;

import com.tienda.mintic.model.clientes;

public interface clienteservice {
	
	public Iterable<clientes> findALL();
	public Optional<clientes> findById(long id);
	public clientes save(clientes clientesseer);
	public void delete(Long id);
	
	

}