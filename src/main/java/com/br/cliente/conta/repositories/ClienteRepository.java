package com.br.cliente.conta.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.cliente.conta.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
