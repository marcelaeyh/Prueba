package com.tienda.mintic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.mintic.model.clientes;

@Repository
public interface clientesdao extends JpaRepository<clientes, Long> {
	

}
