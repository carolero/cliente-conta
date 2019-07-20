package com.br.cliente.conta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cliente.conta.models.Cliente;
import com.br.cliente.conta.models.Conta;
import com.br.cliente.conta.repositories.ClienteRepository;
import com.br.cliente.conta.repositories.ContaRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaRepository contaRepository;
	
	public Iterable<Cliente> exibirClientes() {
		return clienteRepository.findAll();
	}
	
	public String cadastrarCliente(Cliente cliente, Conta conta) {
		if(conta.getSaldoCorrente() < 100) {
			return "Saldo insuficiente";
		} else {
			conta.setCliente(cliente);
			contaRepository.save(conta);
			return "Cliente cadastrado";
		}
	}
	
	public Cliente exibirInfoCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

}
