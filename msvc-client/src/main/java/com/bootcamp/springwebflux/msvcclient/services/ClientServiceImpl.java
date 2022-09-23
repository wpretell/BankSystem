package com.bootcamp.springwebflux.msvcclient.services;

import com.bootcamp.springwebflux.msvcclient.models.documents.Client;
import com.bootcamp.springwebflux.msvcclient.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{

    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Flux<Client> findAll() {
        logger.info("ClientServiceImpl: findAll");
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> findById(String id) {
        logger.info("ClientServiceImpl: findById");
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> save(Client client) {
        logger.info("ClientServiceImpl: save");
        return clientRepository.save(client);
    }

    @Override
    public Mono<Void> delete(Client client) {
        logger.info("ClientServiceImpl: delete");
        return clientRepository.delete(client);
    }

}
