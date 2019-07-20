package com.br.cliente.conta.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente implements Serializable{
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@NotBlank(message = "Nome obrigatório")
	@Size(min = 3, message = "Nome precisa ter pelo menos 3 letras")
	private String nome;
	
	@NotNull
	@NotBlank(message = "CPF obrigatório")
	@Size(min = 11, message = "CPF precisa ter pelo menos 11 números")
	private String cpf;
	
	@NotNull
	@NotBlank(message = "Telefone obrigatório")
	@Size(min = 11, message = "Telefone precisa ter 11 números, contando o DDD")
	private String telefone;
	
	@OneToOne(mappedBy = "cliente")
	private Conta conta;
	
	public Cliente() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
