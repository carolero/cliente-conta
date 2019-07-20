package com.br.cliente.conta.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.cliente.conta.models.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
