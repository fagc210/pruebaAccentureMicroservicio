package com.accenture.apptest.repository.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accenture.apptest.domain.Empleados;

public interface EmpleadosMongoRepo extends MongoRepository<Empleados, Integer> {

}
