package com.tienda.mintic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="productos")
public class productos  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo_producto;

	private double ivacompra;

	private String nombre;
	

	private double precio;
	

	private double precio2;
	//@ManyToOne
	//	@JoinColumn(name="nitproveedor", nullable = false)
	//private proveedores proveedores;
	private String nit;
	
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio2() {
		return precio2;
	}
	public void setPrecio2(double precio2) {
		this.precio2 = precio2;
	}
	/*
	public proveedores getProveedores() {
		return proveedores;
	}
	public void setProveedores(proveedores proveedores) {
		this.proveedores = proveedores;
	}
	*/
	
	
}