package com.example.accessingmongodbdatarest.cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,Long> {
}
