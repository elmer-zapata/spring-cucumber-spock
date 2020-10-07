package com.example.accessingmongodbdatarest.comercio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;



public interface ComercioRepository extends MongoRepository<Comercio,String> {
//    Comercio findByName(@Param("nombreComercio") String name);
}
