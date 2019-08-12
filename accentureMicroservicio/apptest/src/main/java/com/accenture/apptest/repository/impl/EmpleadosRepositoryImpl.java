package com.accenture.apptest.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.apptest.domain.Empleados;
import com.accenture.apptest.repository.EmpleadosRepository;

@Service
public class EmpleadosRepositoryImpl implements  EmpleadosRepository {
	
	@Autowired
	private EmpleadosMongoRepo empleadosMongoRepo;
 
	@Override
	public List<Empleados> findAll() {
		return empleadosMongoRepo.findAll();
	}

	@Override
	public Empleados save(Empleados empleados) {
		return empleadosMongoRepo.save(empleados);
	}

	@Override
	public Boolean  deleteById(Integer id) {
		empleadosMongoRepo.deleteById(id);
		return true;
	}

	@Override
	public Optional<Empleados> findById(Integer id) {
		return empleadosMongoRepo.findById(id);
	}

}
