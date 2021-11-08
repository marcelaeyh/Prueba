package com.tienda.mintic.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.mintic.model.productos;
import com.tienda.mintic.service.productosservice;

@RestController
@RequestMapping("/api/productos")
public class productoscontroller {
	@Autowired
	private productosservice usuarioService;
	
	// Crear usuario
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody productos usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
		
	}
	
	// Leer usuario
	
	@GetMapping("{id}")
	public ResponseEntity<?> read (@PathVariable(value="id") Long usuariod){
		
		Optional<productos> oUsuario = usuarioService.findById(usuariod);
		
		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUsuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody productos usuarioDetails, @PathVariable(value="id") Long usuarioid){
		Optional<productos> uUsuario = usuarioService.findById(usuarioid);
		
		if(!uUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		

		uUsuario.get().setIvacompra(usuarioDetails.getIvacompra());
		uUsuario.get().setNombre(usuarioDetails.getNombre());
		uUsuario.get().setPrecio(usuarioDetails.getPrecio());
		uUsuario.get().setPrecio2(usuarioDetails.getPrecio2());
		//uUsuario.get().setProveedores(usuarioDetails.getProveedores());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(uUsuario.get()));
	}
	
	//Borrar usuario
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") Long usuarioid){
		if(!usuarioService.findById(usuarioid).isPresent()) {
			
			return ResponseEntity.notFound().build();
		}
		usuarioService.delete(usuarioid);
		return ResponseEntity.ok().build();
	}
	
	//Obtener todos los usuarios
	@GetMapping
	public List<productos> readAll(){
		
		List<productos> usuario = StreamSupport.stream(usuarioService.findALL().spliterator(), false).collect(Collectors.toList());
		
		return usuario;
	}

}