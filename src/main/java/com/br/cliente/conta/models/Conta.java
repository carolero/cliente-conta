package com.br.cliente.conta.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Conta implements Serializable {
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DecimalMin(value = "100.0", message = "Valor mínimo de R$100,00 para conta corrente")
	private double saldoCorrente;
	
	private double saldoPolpanca;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Cliente cliente;
	
	public Conta() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSaldoCorrente() {
		return saldoCorrente;
	}

	public void setSaldoCorrente(double saldoCorrente) {
		this.saldoCorrente = saldoCorrente;
	}

	public double getSaldoPolpanca() {
		return saldoPolpanca;
	}

	public void setSaldoPolpanca(double saldoPolpanca) {
		this.saldoPolpanca = saldoPolpanca;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
