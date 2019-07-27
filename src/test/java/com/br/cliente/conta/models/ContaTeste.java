package com.br.cliente.conta.models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ContaTeste {
	
	private Conta conta;
	
	@Before
	public void preparar() {
		conta = new Conta();
		Cliente cliente = new Cliente();
		
		cliente.setId(null);
		cliente.setNome("José Almeida");
		cliente.setCpf("1234567891011");
		cliente.setTelefone("11989999999");
		
		conta.setId(null);
		conta.setCliente(cliente);
		conta.setSaldoCorrente(100D);
		conta.setSaldoPolpanca(0D);
		
		cliente.setConta(conta);
	}
	
	@Test
	public void testarDepositoContaCorrente() {
		conta.depositarContaCorrente(300D);
		assertEquals(400D, conta.getSaldoCorrente(), 0D);
	}
	
	@Test
	public void testarSacarContaCorrente() {
		conta.sacarContaCorrente(50D);
		assertEquals(50D, conta.getSaldoCorrente(), 0D);
	}
	
	@Test
	public void testarTransferirEntreCorrenteEPouoanca() {
		conta.transferirDeContaCorrenteParaPoupanca(100D);
		assertEquals(100D, conta.getSaldoPolpanca(), 0D);
		assertEquals(0D, conta.getSaldoCorrente(), 0D);
	}

}
