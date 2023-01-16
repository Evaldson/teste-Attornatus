package com.attornatus.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Cliente;
import com.attornatus.model.Endereco;
import com.attornatus.respository.ClienteRespository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRespository clienteRepository;
	
	public Cliente updateCliente (Long id, Cliente cliente) {
		
	  Optional<Cliente>	findCliente = clienteRepository.findById(id);
	  
	  cliente.setId(findCliente.get().getId());
	  
	  return clienteRepository.save(cliente);
		
	}
	
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}
	
	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Endereco> listEndereco(Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		return cliente.get().getEndereco();
	}
	
	public Cliente findCliente(Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		return cliente.get();
	}

	public List<Endereco> addEndereco(Long id, Endereco endereco) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		cliente.get().getEndereco().add(endereco);
		
		clienteRepository.save(cliente.get());
		
		Optional<Cliente> clienteUpdated = clienteRepository.findById(id);
		
		return clienteUpdated.get().getEndereco();
	}
	
	
}
