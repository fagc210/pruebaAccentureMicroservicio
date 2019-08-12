package com.accenture.apptest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.apptest.domain.Empleados;
import com.accenture.apptest.pojo.EmpleadosPojo;
import com.accenture.apptest.pojo.converter.EmpleadosConverter;
import com.accenture.apptest.repository.EmpleadosRepository;
import com.accenture.apptest.service.EmpleadoService;
@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@Override
	public List<EmpleadosPojo> findAll() {
		EmpleadosConverter  empleadosConverter = new EmpleadosConverter();
		List<EmpleadosPojo> empleadosPojoList = new ArrayList<EmpleadosPojo>();
		List<Empleados> empleadosList = empleadosRepository.findAll();
		for (Empleados empleados : empleadosList) {
			empleadosPojoList.add(empleadosConverter.converterEmpleados2EmpleadosPojo(empleados));
		}
		return empleadosPojoList;
	}

	@Override
	public String create(EmpleadosPojo empleadosPojo) {
		EmpleadosConverter  empleadosConverter = new EmpleadosConverter();
		Empleados emple = empleadosConverter.converterEmpleadosPojo2Empleados(empleadosPojo);
		try {
			
			Empleados empleado = empleadosRepository.save(emple);
			if(empleado!=null) {
				return empleado.getName();
			}
		} catch (Exception e) {
			if(e.getMessage().contains("E11000 duplicate key"))
			return "ya esiste un empeado con el id: "+empleadosPojo.getId();
		}
		
		return null;
	}

	@Override
	public Boolean deleted(Integer id) {
		return empleadosRepository.deleteById(id);
	}

	@Override
	public EmpleadosPojo findById(Integer id) {
		EmpleadosConverter  empleadosConverter = new EmpleadosConverter();
		Optional<Empleados> empleadoOptional = empleadosRepository.findById(id);
		if(empleadoOptional.isPresent()) {
			Empleados empleado =empleadoOptional.get(); 
			return empleadosConverter.converterEmpleados2EmpleadosPojo(empleado);
		}
		return null;
	}
	

}
