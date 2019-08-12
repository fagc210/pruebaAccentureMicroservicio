package com.accenture.apptest.service;

import java.util.List;

import com.accenture.apptest.pojo.EmpleadosPojo;

public interface EmpleadoService {
	
	public List<EmpleadosPojo> findAll();
	
	public String create(EmpleadosPojo EmpleadosPojo);
	
	public Boolean deleted(Integer id);
	
	public EmpleadosPojo findById(Integer Id);
	
	

}