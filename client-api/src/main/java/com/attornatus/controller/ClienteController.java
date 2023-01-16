package com.attornatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.model.Cliente;
import com.attornatus.model.Endereco;
import com.attornatus.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> list() {
		return clienteService.list();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.create(cliente);
	}

	@RequestMapping(value = "/{id}/endereco", method = RequestMethod.GET)
	public List<Endereco> listEndereco(@PathVariable Long id) {
		return clienteService.listEndereco(id);
	}
	
	@RequestMapping(value = "/{id}/endereco", method = RequestMethod.PATCH)
	public List<Endereco> addEndereco(@RequestBody Endereco endereco, @PathVariable Long id) {
		return clienteService.addEndereco(id, endereco);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cliente findCliente(@PathVariable Long id) {
		return clienteService.findCliente(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
		return clienteService.updateCliente(id, cliente);
	}
	

}
