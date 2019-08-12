package com.accenture.apptest.pojo.converter;


import com.accenture.apptest.domain.Empleados;
import com.accenture.apptest.pojo.EmpleadosPojo;

public class EmpleadosConverter {
	
	
	public EmpleadosPojo converterEmpleados2EmpleadosPojo(Empleados empleados){
		
		EmpleadosPojo empleadosPojo = new EmpleadosPojo();
		empleadosPojo.setId(empleados.getId());
		empleadosPojo.setName(empleados.getName());
		empleadosPojo.setDocumentNumber(empleados.getDocumentNumber());
		empleadosPojo.setEmail(empleados.getEmail());
		return empleadosPojo;
		
	}
	
	public Empleados converterEmpleadosPojo2Empleados(EmpleadosPojo empleadosPojo){
		
		Empleados empleados = new Empleados();
		empleados.setId(empleadosPojo.getId());
		empleados.setName(empleadosPojo.getName());
		empleados.setDocumentNumber(empleadosPojo.getDocumentNumber());
		empleados.setEmail(empleadosPojo.getEmail());
		return empleados;
		
	}

}