package com.accenture.apptest.repository;


import java.util.List;
import java.util.Optional;

import com.accenture.apptest.domain.Empleados;

public interface EmpleadosRepository {
	
	public List<Empleados> findAll();
	
	public Empleados save(Empleados Empleados);
	
	public Boolean deleteById(Integer id);
	
	public Optional<Empleados> findById(Integer Id);
    
}
