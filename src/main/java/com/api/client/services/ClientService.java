package com.api.client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.client.model.Client;
import com.api.client.repository.ClientRepository;
import com.api.client.service.exceptions.ClientExistingException;
import com.api.client.service.exceptions.ClientNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> List() {
		return clientRepository.findAll();
	}

	public Client searchForCode(Long id) {
		
		Client client = clientRepository.findOne(id);

		if (client == null) {
			throw new ClientNotFoundException("client não encontrado.");
		}
		return client;
	}

	public Client save(Client client) {
		
		if( client.getId() != null) {
			
			Client clientExisting = searchForCode(client.getId());
			
			if(clientExisting != null) {
				throw new ClientExistingException("client already existing.");
			}									
		}		
		
		return clientRepository.save(client);
	}

	public void update(Client client) {
		
		checkExisting(client);
		
		clientRepository.save(client);
	}

	public void delete(Long id) {
		
		try {			
			clientRepository.delete(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ClientNotFoundException("client not found.");
		}
	}

	private void checkExisting(Client client) {		
		searchForCode(client.getId());
	}
}
