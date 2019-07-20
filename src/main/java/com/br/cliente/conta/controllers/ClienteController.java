package com.br.cliente.conta.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.cliente.conta.models.Cliente;
import com.br.cliente.conta.models.Conta;
import com.br.cliente.conta.services.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("cliente.html");
		modelAndView.addObject("clientes", clienteService.exibirClientes());
		return modelAndView;
	}
	
	@PostMapping("/")
	public ModelAndView cadastrarCliente(@Valid Cliente cliente, BindingResult bindingResultCliente, @Valid Conta conta, BindingResult bindingResultConta) {
		ModelAndView modelAndView = new ModelAndView("cliente.html");
		if(bindingResultCliente.hasErrors() || bindingResultConta.hasErrors()) {
			List<String> mensagens = new ArrayList<String>();
			for (ObjectError objectError : bindingResultCliente.getAllErrors()) {
				mensagens.add(objectError.getDefaultMessage());
			}
			for (ObjectError objectError : bindingResultConta.getAllErrors()) {
				mensagens.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
			modelAndView.addObject("clientes", clienteService.exibirClientes());
			return modelAndView;
		} else {
			modelAndView.addObject("mensagens", clienteService.cadastrarCliente(cliente, conta));
		}
		modelAndView.addObject("clientes", clienteService.exibirClientes());
		return modelAndView;
	}
	
	@GetMapping("/cliente/{id}")
	public ModelAndView exibirInfoCliente(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("informacao-cliente.html");
		modelAndView.addObject("cliente", clienteService.exibirInfoCliente(id));
		return modelAndView;
	}

}
